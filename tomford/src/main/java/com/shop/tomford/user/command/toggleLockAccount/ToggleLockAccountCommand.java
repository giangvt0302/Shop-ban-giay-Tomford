package com.shop.tomford.user.command.toggleLockAccount;

import com.shop.tomford.common.Cqrs.IRequest;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ToggleLockAccountCommand implements IRequest<Void> {
    private String userId;

}
