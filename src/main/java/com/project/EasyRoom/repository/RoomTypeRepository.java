package com.project.EasyRoom.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.EasyRoom.model.RoomType;

@Repository
public interface RoomTypeRepository extends JpaRepository<RoomType, Integer> {

    // Truy vấn tất cả loại phòng, sắp xếp theo tên
    @Query(value = "SELECT * FROM roomtype ORDER BY nameType ASC", nativeQuery = true)
    List<RoomType> getAllRoomTypeOrderByNameAsc();

    // Kiểm tra tồn tại theo tên loại phòng (dùng trong logic kiểm tra trùng)
    RoomType findByNameTypeIgnoreCase(String nameType);
}
