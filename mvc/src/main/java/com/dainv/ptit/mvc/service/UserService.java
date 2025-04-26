package com.dainv.ptit.mvc.service;

import com.dainv.ptit.mvc.entity.User;
import com.dainv.ptit.mvc.model.UserRegisterInfo;
import org.springframework.security.core.Authentication;

import java.util.Optional;

public interface UserService {
    void register(UserRegisterInfo user);
    Optional<User> getUser(String id);
}
