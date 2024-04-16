package com.shop.tomford.auth.commands.permission.updatePermissionCommand;

import com.shop.tomford.auth.repository.PermissionRepository;
import com.shop.tomford.common.Cqrs.HandleResponse;
import com.shop.tomford.common.Cqrs.IRequestHandler;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class UpdatePermissionCommandHandler implements IRequestHandler<UpdatePermissionCommand, Void> {
    private final PermissionRepository permissionRepository;

    @Override
    @Transactional
    public HandleResponse<Void> handle(UpdatePermissionCommand command) {
        var existPermission = permissionRepository.findById(command.getNormalizedName());
        if (existPermission.isEmpty()) {
            return HandleResponse.error("Quyền với mã " + command.getNormalizedName() + " không tồn tại");
        }
        var permission = existPermission.get();
        permission.setDisplayName(command.getDisplayName());
        permission.setDescription(command.getDescription());
        permissionRepository.save(permission);
        return HandleResponse.ok();
    }
}
