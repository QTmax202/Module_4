package com.example.spring_srcurity.service.user;

import com.example.spring_srcurity.model.User;
import com.example.spring_srcurity.service.IGeneralService;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Optional;

public interface IUserService extends IGeneralService<User>, UserDetailsService {
    Optional<User> findByUsername(String username);
}
