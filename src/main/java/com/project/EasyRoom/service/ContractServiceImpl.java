package com.project.EasyRoom.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.EasyRoom.model.Contract;
import com.project.EasyRoom.repository.ContractRepository;

@Service
public class ContractServiceImpl implements ContractService{

	@Autowired
	private ContractRepository repository;
	@Override
	public List<Contract> getAllContract() {
		
		return repository.findAll();
	}

	@Override
	public Contract getContractById(int idContract) {
		
		return repository.findById(idContract).get();
	}

	@Override
	public void saveContract(Contract contract) {
		repository.save(contract);
	}

	@Override
	public void deleteContract(int idContract) {
		repository.deleteById(idContract);
		
	}

}
