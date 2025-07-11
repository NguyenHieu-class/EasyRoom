package com.project.EasyRoom.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.EasyRoom.model.Province;

@Repository
public interface ProvinceRepository extends JpaRepository<Province, Integer> {

    @Query(value = "SELECT * FROM province ORDER BY nameProvince ASC", nativeQuery = true)
    List<Province> findAllProvinceOrderbyName();

    // Đếm tổng số tỉnh
    long count();
}