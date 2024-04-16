package com.shop.tomford.auth.commands.role.createRole;

import com.shop.tomford.auth.entity.Role;
import com.shop.tomford.auth.repository.RoleRepository;
import com.shop.tomford.common.Cqrs.HandleResponse;
import com.shop.tomford.common.Cqrs.IRequestHandler;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class CreateRoleCommandHandler implements IRequestHandler<CreateRoleCommand, String> {

    private final RoleRepository roleRepository;
    @Override
    @Transactional
    public HandleResponse<String> handle(CreateRoleCommand createRoleCommand) {
        var existRole = roleRepository.findById(createRoleCommand.getNormalizedName());
        if (existRole.isPresent()) {
            return HandleResponse.error("Role with name " + createRoleCommand.getNormalizedName() + " already exist");
        }
        var role = Role.builder()
                .normalizedName(createRoleCommand.getNormalizedName())
                .displayName(createRoleCommand.getDisplayName())
                .description(createRoleCommand.getDescription())
                .build();
        roleRepository.save(role);
        return HandleResponse.ok(role.getNormalizedName());
    }
}
