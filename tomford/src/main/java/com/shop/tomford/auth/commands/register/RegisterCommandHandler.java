package com.shop.tomford.auth.commands.register;

import com.shop.tomford.user.entity.User;
import com.shop.tomford.common.Cqrs.HandleResponse;
import com.shop.tomford.common.Cqrs.IRequestHandler;
import com.shop.tomford.auth.repository.RoleRepository;
import com.shop.tomford.auth.repository.IUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class RegisterCommandHandler  implements IRequestHandler<RegisterCommand, User>{
    private final IUserRepository IUserRepository;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;
    @Override
    @Transactional
    public HandleResponse<User> handle(RegisterCommand registerCommand) {
        var existedUser = IUserRepository.findByEmail(registerCommand.getEmail());
        if (existedUser.isPresent()) {
            return HandleResponse.error("Email đã tồn tại");
        }
        var user = User.builder()
                .firstName(registerCommand.getFirstName())
                .lastName(registerCommand.getLastName())
                .email(registerCommand.getEmail())
                .isCustomer(true)
                .isEmailVerified(false)
                .isAccountEnabled(true)
                .passwordHash(passwordEncoder.encode(registerCommand.getRawPassword()))
                .roles(List.of(roleRepository.findByName("ROLE_CUSTOMER").orElseThrow()))
                .build();

        IUserRepository.save(user);
        return HandleResponse.ok(user);
    }
}
