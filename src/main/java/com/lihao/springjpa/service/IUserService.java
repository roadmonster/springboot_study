package com.lihao.springjpa.service;

import com.lihao.springjpa.model.User;

import java.util.List;

public interface IUserService {
    List<User> list();
    List<User> findByUsername(String username);
    User get(String userId);
}
