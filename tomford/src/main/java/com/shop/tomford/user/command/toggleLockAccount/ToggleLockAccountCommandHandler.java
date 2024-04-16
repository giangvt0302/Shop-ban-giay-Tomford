package com.shop.tomford.user.command.toggleLockAccount;

import com.shop.tomford.auth.repository.IUserRepository;
import com.shop.tomford.common.Cqrs.HandleResponse;
import com.shop.tomford.common.Cqrs.IRequestHandler;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class ToggleLockAccountCommandHandler implements IRequestHandler<ToggleLockAccountCommand, Void> {
    private final IUserRepository IUserRepository;

    @Override
    @Transactional

    public HandleResponse<Void> handle(ToggleLockAccountCommand toggleLockAccountCommand) throws Exception {
        var user = IUserRepository.findById(toggleLockAccountCommand.getUserId());
        if (user.isEmpty()) {
            return HandleResponse.error("Không tìm thấy người dùng");
        }
        user.get().setAccountEnabled(!user.get().isAccountEnabled());
        IUserRepository.save(user.get());
        return HandleResponse.ok();
    }
}
