package com.dainv.ptit.mvc.service.impl;
import com.dainv.ptit.mvc.entity.User;
import com.dainv.ptit.mvc.mapper.UserToUserDetailMapper;
import com.dainv.ptit.mvc.model.UserRegisterInfo;
import com.dainv.ptit.mvc.repository.UserRepository;
import com.dainv.ptit.mvc.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserDetailsService, UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserToUserDetailMapper userToUserDetailMapper;

    @Override
    public void register(UserRegisterInfo user) {
        User userEntity = new User();
        userEntity.setUsername(user.getUsername());
        userEntity.setFullName(user.getFullName());
        userEntity.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(userEntity);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return this.userRepository.findByUsername(username)
                .map(userToUserDetailMapper::toUserDetails)
                .orElseThrow(() -> new UsernameNotFoundException(username));
    }
}

