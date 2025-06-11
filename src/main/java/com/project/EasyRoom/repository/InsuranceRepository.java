package com.project.EasyRoom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.EasyRoom.model.Insurance;
@Repository
public interface InsuranceRepository extends JpaRepository<Insurance, Integer> {

	long count();
}
