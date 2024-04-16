package com.shop.tomford.auth.commands.login;


import com.shop.tomford.common.Cqrs.IRequest;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginRequest implements IRequest<Integer> {
    private String username;
    private String password;
}
