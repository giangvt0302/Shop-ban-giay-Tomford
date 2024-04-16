package com.shop.tomford.auth.query.permission.getAllPermissions;

import com.shop.tomford.auth.dto.PermissionDto;
import com.shop.tomford.auth.repository.PermissionRepository;
import com.shop.tomford.common.Cqrs.HandleResponse;
import com.shop.tomford.common.Cqrs.IRequestHandler;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class GetAllPermissionQueryHandler implements IRequestHandler<GetAllPermissionQuery, List<PermissionDto>> {
    private final PermissionRepository permissionRepository;
    private final ModelMapper modelMapper;
    @Override
    public HandleResponse<List<PermissionDto>> handle(GetAllPermissionQuery getAllPermissionQuery)  {
            var permissions = permissionRepository.findAll();
            var permissionDtos = permissions.stream().map(permission -> {
                return modelMapper.map(permission, PermissionDto.class);
            }).toList();
            return HandleResponse.ok(permissionDtos);


    }
}
