package com.shop.tomford.auth.endpoint;

import com.shop.tomford.auth.commands.role.addPermissionToRole.AddPermissionToRoleCommand;
import com.shop.tomford.auth.commands.role.createRole.CreateRoleCommand;
import com.shop.tomford.auth.commands.role.deleteRole.DeleteRoleCommand;
import com.shop.tomford.auth.commands.role.removePermissionFromRole.RemovePermissionFromRoleCommand;
import com.shop.tomford.auth.commands.role.updateRole.UpdateRoleCommand;
import com.shop.tomford.auth.dto.RoleDto;
import com.shop.tomford.auth.query.role.getAllRoles.GetAllRolesQuery;
import com.shop.tomford.common.Cqrs.ISender;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/role")
@Secured("ROLE_MANAGEMENT")
@AllArgsConstructor
public class RoleApiController {
    private  final ISender sender;
    @GetMapping()
    public ResponseEntity<List<RoleDto>> getAllRoles() {
        var query = new GetAllRolesQuery();
        var result = sender.send(query);
        return ResponseEntity.ok(result.orThrow());
    }

    @PutMapping()
    public ResponseEntity<Void> updateRole(@Valid @RequestBody UpdateRoleCommand command)  {
        sender.send(command).orThrow();
        return ResponseEntity.ok().build();
    }
    @PostMapping()
    public ResponseEntity<Void> createRole(@Valid @RequestBody CreateRoleCommand command)  {
        sender.send(command).orThrow();
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{roleName}")
    @ResponseStatus(org.springframework.http.HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> deleteRole(@PathVariable String roleName)  {
        sender.send(new DeleteRoleCommand(roleName)).orThrow();
        return ResponseEntity.noContent().build();
    }
    @PatchMapping("/assign-permission")
    public ResponseEntity<Void> assignPermission(@Valid @RequestBody AddPermissionToRoleCommand command)  {
        sender.send(command).orThrow();
        return ResponseEntity.ok().build();
    }
    @PatchMapping("/remove-permission")
    public ResponseEntity<Void> removePermissionFromRole(@Valid @RequestBody RemovePermissionFromRoleCommand command)  {
        sender.send(command).orThrow();
        return ResponseEntity.ok().build();
    }
}
