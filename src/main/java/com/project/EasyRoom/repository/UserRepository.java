package com.project.EasyRoom.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.EasyRoom.model.User;

import jakarta.transaction.Transactional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    // Lấy tất cả user sắp xếp theo username
    @Query(value = "SELECT * FROM users ORDER BY username ASC", nativeQuery = true)
    List<User> findAllUserOrderByUsername();

    // Cập nhật tổng số tiền người dùng
    @Transactional
    @Modifying
    @Query(value = "UPDATE users SET total_money = :totalMoney WHERE id_user = :idUser", nativeQuery = true)
    void updateTotalMoney(@Param("totalMoney") int totalMoney, @Param("idUser") int idUser);

    // Tìm user theo username
    Optional<User> findUserByUsername(String username);

    Optional<User> findByUsername(String username);

    // Lấy thông tin chủ phòng từ idRoom (JOIN room)
    @Query(value = """
        SELECT u.* FROM room r
        JOIN users u ON u.id_user = r.id_user
        WHERE r.idRoom = :idRoom
        """, nativeQuery = true)
    User getUserByIdRoom(@Param("idRoom") int idRoom);

    long count();
}
