package com.dainv.ptit.mvc.service.impl;
import com.dainv.ptit.mvc.entity.User;
import com.dainv.ptit.mvc.mapper.UserMapper;
import com.dainv.ptit.mvc.model.UserRegisterInfo;
import com.dainv.ptit.mvc.repository.UserRepository;
import com.dainv.ptit.mvc.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserDetailsService, UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;

    @Override
    public void register(UserRegisterInfo user) {
        User userEntity = new User();
        userEntity.setUsername(user.getUsername());
        userEntity.setFullName(user.getFullName());
        userEntity.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(userEntity);
    }

    @Override
    public Optional<User> getUser(String id) {
        return userRepository.findById(id);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return this.userRepository.findByUsername(username)
                .map(userMapper::toUserDetails)
                .orElseThrow(() -> new UsernameNotFoundException(username));
    }
}

