package com.project.EasyRoom.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.EasyRoom.model.District;

@Repository
public interface DistrictRepository extends JpaRepository<District, Integer> {

    // 1. Truy vấn danh sách quận/huyện có kèm tên tỉnh
    @Query(value = """
        SELECT d.idDistrict, d.nameDistrict, d.createDate, d.updateDate, 
               p.idProvince, p.nameProvince
        FROM district d
        JOIN province p ON p.idProvince = d.id_province
        """, nativeQuery = true)
    List<District> getAllDistrictWithProvince();

    // 2. Tìm danh sách quận/huyện theo id tỉnh
    List<District> findByProvinceIdProvince(int idProvince);

    // 3. Đếm tổng số quận/huyện
    long count();
}
