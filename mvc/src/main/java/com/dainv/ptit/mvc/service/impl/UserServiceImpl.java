package com.dainv.ptit.mvc.service.impl;
import com.dainv.ptit.mvc.entity.User;
import com.dainv.ptit.mvc.model.UserRegisterInfo;
import com.dainv.ptit.mvc.repository.UserRepository;
import com.dainv.ptit.mvc.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void register(UserRegisterInfo user) {
        User userEntity = new User();
        userEntity.setUsername(user.getUsername());
        userEntity.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(userEntity);
    }
}

