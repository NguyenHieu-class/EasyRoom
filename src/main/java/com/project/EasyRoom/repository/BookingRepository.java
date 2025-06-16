package com.project.EasyRoom.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.EasyRoom.model.Booking;

import jakarta.transaction.Transactional;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer> {

    // 1. Tìm tất cả đơn đặt theo người dùng
    List<Booking> findBookingByUserIdUserOrderByDateStartDesc(int idUser);

    List<Booking> findBookingByUserIdUserAndStatusBillOrderByDateStartDesc(int idUser, int statusBill);

    List<Booking> findBookingByStatusBill(int statusBill);

    List<Booking> findBookingByRoomIdRoomAndDateStartGreaterThanEqualAndDateEndLessThanEqual(int idRoom, Date dateStart, Date dateEnd);

    // 2. Đếm số booking theo phòng
    int countByRoomIdRoom(int idRoom);

    long count();

    // 3. Cập nhật trạng thái hóa đơn
    @Transactional
    @Modifying
    @Query(value = "UPDATE booking SET status_bill = :statusBill WHERE idBooking = :idBooking", nativeQuery = true)
    void changeStatusBill(@Param("statusBill") int statusBill, @Param("idBooking") int idBooking);

    // 4. Kiểm tra trùng thời gian
    @Query(value = """
        SELECT * FROM booking 
        WHERE id_room = :idRoom 
        AND CONVERT(nvarchar(10), date_start, 127) >= :dateStart 
        AND CONVERT(nvarchar(10), date_end, 127) <= :dateEnd
        """, nativeQuery = true)
    List<Booking> checkBookingExistOnTime(@Param("idRoom") int idRoom,
                                          @Param("dateStart") String dateStart,
                                          @Param("dateEnd") String dateEnd);

    // 5. Booking theo thời gian
    @Query(value = """
        SELECT * FROM booking 
        WHERE CONVERT(nvarchar(10), date_start, 127) >= :dateStart 
        AND CONVERT(nvarchar(10), date_end, 127) <= :dateEnd
        """, nativeQuery = true)
    List<Booking> getAllBookingOnTime(@Param("dateStart") String dateStart,
                                      @Param("dateEnd") String dateEnd);

    @Query(value = """
        SELECT * FROM booking
        WHERE status_bill = :statusBill
          AND CONVERT(nvarchar(10), date_start, 127) >= :dateStart
          AND CONVERT(nvarchar(10), date_end, 127) <= :dateEnd
        """, nativeQuery = true)
    List<Booking> getBookingOnTimeWithStatus(@Param("statusBill") int statusBill,
                                             @Param("dateStart") String dateStart,
                                             @Param("dateEnd") String dateEnd);

    // 6. Truy vấn booking + phòng + chủ trọ
    String sql = """
        SELECT b.*, r.title, r.addressRoom, r.price, u.username, u.nameDisplay, u.phone 
        FROM booking b
        JOIN room r ON r.idRoom = b.id_room
        JOIN users u ON u.id_user = r.id_user
        """;

    @Query(value = sql + " WHERE r.id_user = :idUser", nativeQuery = true)
    List<Booking> getAllBookingWithRoomOwner(@Param("idUser") int idUser);

    @Query(value = sql + " WHERE r.id_user = :idUser AND status_bill = :statusBill", nativeQuery = true)
    List<Booking> getAllBookingWithRoomOwnerAndStatusBill(@Param("idUser") int idUser,
                                                          @Param("statusBill") int statusBill);

    @Query(value = sql + " WHERE status_bill = :statusBill", nativeQuery = true)
    List<Booking> getAllBookingByStatusBill(@Param("statusBill") int statusBill);

    // 7. Doanh thu tổng theo ngày
    @Query(value = """
        SELECT CONVERT(nvarchar(10), date_start, 127) AS ngaydat,
               SUM(bill_total) AS tongtien
        FROM booking
        WHERE CONVERT(nvarchar(10), date_start, 127) >= :dateStart
          AND CONVERT(nvarchar(10), date_end, 127) <= :dateEnd
          AND status_bill = :statusBill
        GROUP BY CONVERT(nvarchar(10), date_start, 127)
        """, nativeQuery = true)
    String[] sumRevenueOnTime(@Param("dateStart") String dateStart,
                              @Param("dateEnd") String dateEnd,
                              @Param("statusBill") int statusBill);

    // 8. Doanh thu theo chủ trọ
    @Query(value = """
        SELECT CONVERT(nvarchar(10), date_start, 127) AS ngaydat,
               SUM(bill_total) AS tongtien
        FROM booking b
        JOIN room r ON r.idRoom = b.id_room
        WHERE CONVERT(nvarchar(10), date_start, 127) >= :dateStart
          AND CONVERT(nvarchar(10), date_end, 127) <= :dateEnd
          AND status_bill = :statusBill
          AND r.id_user = :idUser
        GROUP BY CONVERT(nvarchar(10), date_start, 127)
        """, nativeQuery = true)
    String[] sumRevenueOnTimeByIdUser(@Param("dateStart") String dateStart,
                                      @Param("dateEnd") String dateEnd,
                                      @Param("statusBill") int statusBill,
                                      @Param("idUser") int idUser);
}
