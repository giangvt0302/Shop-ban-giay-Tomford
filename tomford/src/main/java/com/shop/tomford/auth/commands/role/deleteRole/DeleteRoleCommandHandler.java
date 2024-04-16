package com.shop.tomford.auth.commands.role.deleteRole;

import com.shop.tomford.auth.repository.RoleRepository;
import com.shop.tomford.common.Cqrs.HandleResponse;
import com.shop.tomford.common.Cqrs.IRequestHandler;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@AllArgsConstructor
@Service
public class DeleteRoleCommandHandler implements IRequestHandler<DeleteRoleCommand, Void> {
    private final RoleRepository roleRepository;
    @Override
    public HandleResponse<Void> handle(DeleteRoleCommand deleteRoleCommand) throws Exception {
        var role = roleRepository.findByName(deleteRoleCommand.roleName());
        roleRepository.delete(role.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Role not found")));
        return HandleResponse.ok();
    }
}
