package com.fenger.sys.service;

import com.fenger.sys.domain.User;

public interface UserService {
    User selectByLoginname(String loginname);
}
