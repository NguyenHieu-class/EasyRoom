package com.project.EasyRoom.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.EasyRoom.model.Ward;

@Repository
public interface WardRepository extends JpaRepository<Ward, Integer> {

    // 1. Lấy danh sách xã/phường kèm tên quận/huyện
    @Query(value = """
        SELECT w.* FROM ward w
        JOIN district d ON d.idDistrict = w.id_district
        """, nativeQuery = true)
    List<Ward> getAllWardWithDistrict();

    // 2. Lấy danh sách xã/phường kèm cả quận/huyện và tỉnh/thành
    @Query(value = """
        SELECT w.* FROM ward w
        JOIN district d ON d.idDistrict = w.id_district
        JOIN province p ON p.idProvince = d.id_province
        """, nativeQuery = true)
    List<Ward> getAllWardWithDistrictWithProvinces();

    // 3. Tìm xã/phường theo quận/huyện
    List<Ward> findWardByDistrictIdDistrict(int idDistrict);

    // 4. Đếm tổng số xã/phường
    long count();
}
