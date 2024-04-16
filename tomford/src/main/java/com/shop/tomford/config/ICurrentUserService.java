package com.shop.tomford.config;

import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public interface ICurrentUserService {
    public Optional<String> getCurrentUserId();
    public Optional<UserDetails> getCurrentUser();


}
