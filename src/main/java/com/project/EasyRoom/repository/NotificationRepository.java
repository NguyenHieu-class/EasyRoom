package com.project.EasyRoom.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.EasyRoom.model.Notification;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Integer> {

    // 1. Đếm tổng số thông báo
    long count();

    // 2. Lấy thông báo mới nhất
    @Query(value = "SELECT TOP 1 * FROM notification ORDER BY idNoti DESC", nativeQuery = true)
    Notification getNotificationLatest();

    // 3. Lấy danh sách thông báo gửi đến người dùng cụ thể
    @Query(value = """
        SELECT n.* FROM notification n
        JOIN detailnotification dt ON dt.id_notification = n.idNoti
        JOIN users u ON u.id_user = dt.id_user
        WHERE u.id_user = :idUser
        ORDER BY n.createDate DESC
        """, nativeQuery = true)
    List<Notification> getNotificationByUserId(@Param("idUser") int idUser);
}
