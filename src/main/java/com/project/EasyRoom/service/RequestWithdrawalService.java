package com.project.EasyRoom.service;

import java.util.List;
import com.project.EasyRoom.model.RequestWithdrawal;

public interface RequestWithdrawalService {

    void saveRequestWithdrawal(RequestWithdrawal entity);
    void deleteRequestWithdrawalById(int id);
    RequestWithdrawal getRequestWithdrawalById(int id);
    List<RequestWithdrawal> getAllRequestWithdrawals();
    long countRequestWithdrawals();
}
