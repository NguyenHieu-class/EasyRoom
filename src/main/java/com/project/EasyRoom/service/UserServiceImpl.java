package com.project.EasyRoom.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.EasyRoom.model.User;
import com.project.EasyRoom.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public List<User> getAllUsersOrderByUsername() {
        return userRepository.findAllUserOrderByUsername();
    }

    @Override
    public void deleteUser(int idUser) {
        userRepository.deleteById(idUser);
    }

    @Override
    public User getUserById(int idUser) {
        Optional<User> optional = userRepository.findById(idUser);
        return optional.orElse(null);
    }

    @Override
    public void updateTotalMoney(int totalMoney, int idUser) {
        userRepository.updateTotalMoney(totalMoney, idUser);
    }

    @Override
    public int countUsers() {
        return (int) userRepository.count();
    }

    @Override
    public Optional<User> findUserByUsername(String username) {
        return userRepository.findUserByUsername(username);
    }

    @Override
    public User getUserByRoomId(int idRoom) {
        return userRepository.getUserByIdRoom(idRoom);
    }
}
