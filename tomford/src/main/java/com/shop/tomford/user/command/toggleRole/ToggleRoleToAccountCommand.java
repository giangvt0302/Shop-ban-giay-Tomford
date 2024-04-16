package com.shop.tomford.user.command.toggleRole;

import com.shop.tomford.common.Cqrs.IRequest;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ToggleRoleToAccountCommand implements IRequest<Void> {
    private String userId;
    private String roleId;
}
