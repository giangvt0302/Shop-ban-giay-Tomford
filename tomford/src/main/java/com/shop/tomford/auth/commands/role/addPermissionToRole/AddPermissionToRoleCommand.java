package com.shop.tomford.auth.commands.role.addPermissionToRole;

import com.shop.tomford.common.Cqrs.IRequest;
import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AddPermissionToRoleCommand implements IRequest<Void> {
    @NotEmpty(message = "Tên vai trò không được để trống")
    private String roleName;
    @NotEmpty(message = "Tên quyền không được để trống")
    private String permissionName;
}
