package com.shop.tomford.auth.commands.role.deleteRole;

import com.shop.tomford.common.Cqrs.IRequest;

public record DeleteRoleCommand(String roleName) implements IRequest<Void> {
}
