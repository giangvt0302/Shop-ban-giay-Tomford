package com.shop.tomford.auth.commands.role.updateRole;

import com.shop.tomford.auth.repository.RoleRepository;
import com.shop.tomford.common.Cqrs.HandleResponse;
import com.shop.tomford.common.Cqrs.IRequestHandler;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class UpdateRoleCommandHandler implements IRequestHandler<UpdateRoleCommand, Void> {
    private final RoleRepository roleRepository;
    @Override
    @Transactional
    public HandleResponse<Void> handle(UpdateRoleCommand updateRoleCommand) {
        var existRole = roleRepository.findById(updateRoleCommand.getNormalizedName());
        if (existRole.isEmpty()) {
            return HandleResponse.error("Role with name " + updateRoleCommand.getNormalizedName() + " not found");
        }
        var role = existRole.get();
        role.setDisplayName(updateRoleCommand.getDisplayName());
        role.setDescription(updateRoleCommand.getDescription());
        roleRepository.save(role);
        return HandleResponse.ok(null);
    }
}
