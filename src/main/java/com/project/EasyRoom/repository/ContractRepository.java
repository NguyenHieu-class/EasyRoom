package com.project.EasyRoom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.EasyRoom.model.Contract;

@Repository
public interface ContractRepository extends JpaRepository<Contract, Integer> {

}
