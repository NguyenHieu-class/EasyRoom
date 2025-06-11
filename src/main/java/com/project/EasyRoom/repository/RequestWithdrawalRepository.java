package com.project.EasyRoom.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.EasyRoom.model.RequestWithdrawal;

import jakarta.transaction.Transactional;

@Repository
public interface RequestWithdrawalRepository extends JpaRepository<RequestWithdrawal, Integer> {

    // 1. Lấy tất cả yêu cầu rút tiền, sắp xếp theo ngày tạo mới nhất
    @Query(value = "SELECT * FROM requestwithdrawal ORDER BY createDate DESC", nativeQuery = true)
    List<RequestWithdrawal> getAllWithdrawal();

    // 2. Lấy tất cả yêu cầu rút tiền của 1 user
    @Query(value = "SELECT * FROM requestwithdrawal WHERE id_user = :idUser ORDER BY createDate DESC", nativeQuery = true)
    List<RequestWithdrawal> getAllWithdrawalByIdUser(@Param("idUser") int idUser);

    // 3. Cập nhật trạng thái yêu cầu rút tiền
    @Modifying
    @Transactional
    @Query(value = "UPDATE requestwithdrawal SET statusRequest = :statusRequest WHERE idRequest = :idRequest", nativeQuery = true)
    void changeStatusRequestPayment(@Param("statusRequest") int statusRequest, @Param("idRequest") int idRequest);
}
