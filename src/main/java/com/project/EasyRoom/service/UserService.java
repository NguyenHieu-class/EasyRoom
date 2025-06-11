package com.project.EasyRoom.service;

import java.util.List;
import java.util.Optional;

import com.project.EasyRoom.model.User;

public interface UserService {

    void saveUser(User user);
    List<User> getAllUsers();
    List<User> getAllUsersOrderByUsername();
    void deleteUser(int idUser);
    User getUserById(int idUser);
    void updateTotalMoney(int totalMoney, int idUser);
    int countUsers();
    Optional<User> findUserByUsername(String username);
    User getUserByRoomId(int idRoom);
}
