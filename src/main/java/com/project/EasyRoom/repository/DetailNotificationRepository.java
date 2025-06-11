package com.project.EasyRoom.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.EasyRoom.model.DetailNotification;

import jakarta.transaction.Transactional;

@Repository
public interface DetailNotificationRepository extends JpaRepository<DetailNotification, Integer> {

    // 1. Lấy danh sách chi tiết thông báo của 1 user theo thời gian mới nhất
    @Query(value = """
        SELECT dt.* FROM notification n
        JOIN detailnotification dt ON dt.id_notification = n.idNoti
        JOIN users u ON u.id_user = dt.id_user
        WHERE u.id_user = :idUser
        ORDER BY n.createDate DESC
        """, nativeQuery = true)
    List<DetailNotification> getDetailNotification(@Param("idUser") int idUser);

    // 2. Đánh dấu đã đọc toàn bộ thông báo cho user
    @Modifying
    @Transactional
    @Query(value = """
        UPDATE detailnotification
        SET statusRead = :status
        WHERE id_user = :idUser
        """, nativeQuery = true)
    void updateStatusAllByUserId(@Param("status") int status, @Param("idUser") int idUser);

    // 3. Đánh dấu đã đọc một thông báo cụ thể
    @Modifying
    @Transactional
    @Query(value = """
        UPDATE detailnotification
        SET statusRead = :status
        WHERE id_user = :idUser AND id_notification = :idNoti
        """, nativeQuery = true)
    void updateStatusByUserAndNotification(@Param("status") int status,
                                           @Param("idUser") int idUser,
                                           @Param("idNoti") int idNoti);
}
