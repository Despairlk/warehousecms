package com.fenger.sys.service.impl;

import com.fenger.sys.domain.User;
import com.fenger.sys.mapper.UserMapper;
import com.fenger.sys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Override
    public User selectByLoginname(String loginname) {
        return this.userMapper.selectByLoginname(loginname);
    }
}
