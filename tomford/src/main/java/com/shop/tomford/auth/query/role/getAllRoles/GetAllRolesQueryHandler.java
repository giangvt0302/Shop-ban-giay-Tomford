package com.shop.tomford.auth.query.role.getAllRoles;

import com.shop.tomford.auth.dto.RoleDto;
import com.shop.tomford.auth.repository.RoleRepository;
import com.shop.tomford.common.Cqrs.HandleResponse;
import com.shop.tomford.common.Cqrs.IRequestHandler;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@AllArgsConstructor
@Service
public class GetAllRolesQueryHandler implements IRequestHandler<GetAllRolesQuery, List<RoleDto>>{
    private final RoleRepository roleRepository;
    private final ModelMapper modelMapper;

    @Override
    @Transactional(readOnly = true)
    public HandleResponse<List<RoleDto>> handle(GetAllRolesQuery getAllRolesQuery){
        var roles = roleRepository.findAll();
        var roleDtos = roles.stream().map(role -> {
            return modelMapper.map(role, RoleDto.class);
        }).toList();
        return HandleResponse.ok(roleDtos);
    }
}
