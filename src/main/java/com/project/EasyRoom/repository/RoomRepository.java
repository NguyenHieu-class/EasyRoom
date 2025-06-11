package com.project.EasyRoom.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.EasyRoom.model.Room;

import jakarta.transaction.Transactional;

@Repository
public interface RoomRepository extends JpaRepository<Room, Integer> {

    // 1. Truy vấn tất cả phòng, sắp xếp theo tên
    @Query(value = "SELECT * FROM room ORDER BY title ASC", nativeQuery = true)
    List<Room> getAllRoomsOrderByTitleAsc();

    // 2. Cập nhật trạng thái khả dụng (isAvailable)
    @Modifying
    @Transactional
    @Query(value = "UPDATE room SET isAvailable = :isAvailable WHERE idRoom = :idRoom", nativeQuery = true)
    void updateRoomAvailability(@Param("isAvailable") boolean isAvailable, @Param("idRoom") int idRoom);

    // 3. Tìm theo người dùng (user là chủ trọ)
    List<Room> findRoomByUserIdUserOrderByTitleAsc(int idUser);

    List<Room> findRoomByUserIdUserAndIsAvailableOrderByTitleAsc(int idUser, boolean isAvailable);

    // 4. Tìm theo tiêu đề chứa từ khóa
    List<Room> findRoomByTitleContainingIgnoreCase(String keyword);

    // 5. Tìm theo địa chỉ và khuyến mãi
    List<Room> findRoomByAddressRoomContainingAndPromotionalPriceGreaterThan(String address, int minPromo);

    // 6. Đếm theo địa chỉ hoặc loại thuê
    int countByAddressRoomContaining(String address);
    int countByAddressRoomContainingAndRentalType(String address, boolean rentalType);

    // 7. Cập nhật toàn bộ giá khuyến mãi
    @Modifying
    @Transactional
    @Query(value = "UPDATE room SET promotionalPrice = :promotionalPrice", nativeQuery = true)
    void updateAllPromotionalPrices(@Param("promotionalPrice") int promotionalPrice);

    // 8. Cập nhật giá khuyến mãi cho phòng cụ thể
    @Modifying
    @Transactional
    @Query(value = "UPDATE room SET promotionalPrice = :promotionalPrice WHERE idRoom = :idRoom", nativeQuery = true)
    void updatePromotionalPriceById(@Param("promotionalPrice") int promotionalPrice, @Param("idRoom") int idRoom);

    // 9. Truy vấn các phòng có tiện ích
    List<Room> findByHasWifiTrue();
    List<Room> findByHasAirConditioningTrue();
    List<Room> findByHasParkingTrue();
    List<Room> findByHasWashingMachineTrue();
    List<Room> findByHasSecurityCameraTrue();

    // 10. Lọc kết hợp tiện ích + địa chỉ
    List<Room> findByHasAirConditioningTrueAndAddressRoomContaining(String addressRoom);

    List<Room> findByHasWifiTrueAndHasParkingTrueAndIsAvailableTrueOrderByPriceAsc();

    // 11. Truy vấn các phòng rảnh trong khoảng thời gian
    @Query(value = """
        SELECT * FROM room 
        WHERE rentalType = :rentalType 
        AND addressRoom LIKE %:address% 
        AND idRoom NOT IN (
            SELECT id_room FROM booking 
            WHERE CONVERT(nvarchar(10), dateStart, 127) <= :dateEnd 
            AND CONVERT(nvarchar(10), dateEnd, 127) >= :dateStart
        )
        AND isAvailable = :isAvailable
        ORDER BY title ASC
        """, nativeQuery = true)
    List<Room> findAvailableRoomsInTimeRange(
        @Param("rentalType") boolean rentalType,
        @Param("address") String address,
        @Param("dateStart") String dateStart,
        @Param("dateEnd") String dateEnd,
        @Param("isAvailable") boolean isAvailable
    );
}
