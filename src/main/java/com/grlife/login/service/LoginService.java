package com.grlife.login.service;

import com.grlife.login.domain.UserInfo;
import com.grlife.login.repository.LoginRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class LoginService implements UserDetailsService {

    private final LoginRepository loginRepository;

    public Long save(UserInfo userInfo) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        userInfo.setPassword(encoder.encode(userInfo.getPassword()));

        System.out.println("프린트%%%%");

        Long t = loginRepository.save(UserInfo.builder()
                .email(userInfo.getEmail())
                .auth(userInfo.getAuth())
                .password(userInfo.getPassword()).build()).getCode();

        System.out.println("프린트 : " + t);

        return t;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}
