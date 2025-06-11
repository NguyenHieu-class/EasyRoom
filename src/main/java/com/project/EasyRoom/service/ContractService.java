package com.project.EasyRoom.service;

import java.util.List;

import com.project.EasyRoom.model.Contract;

public interface ContractService {
	List<Contract> getAllContract();
	Contract getContractById(int idContract);
	void saveContract(Contract contract);
	void deleteContract(int idContract);
}
