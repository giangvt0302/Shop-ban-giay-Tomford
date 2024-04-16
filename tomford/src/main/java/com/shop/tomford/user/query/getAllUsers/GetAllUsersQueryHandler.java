package com.shop.tomford.user.query.getAllUsers;


import com.shop.tomford.user.UserDto;
import com.shop.tomford.user.entity.User;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.shop.tomford.auth.repository.IUserRepository;
import com.shop.tomford.common.Cqrs.HandleResponse;
import com.shop.tomford.common.Cqrs.IRequestHandler;
import com.shop.tomford.common.dto.Paginated;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;


@AllArgsConstructor
@Service
public class GetAllUsersQueryHandler implements IRequestHandler<GetAllUsersQuery, Paginated<UserDto>> {
    private final IUserRepository IUserRepository;
    private final ModelMapper modelMapper;
    private final EntityManager entityManager;

    @Override
    @Transactional
    public HandleResponse<Paginated<UserDto>> handle(GetAllUsersQuery request) throws Exception {
        Page<User> users;
        var accountType = request.getAccountType().toUpperCase();
        if (accountType.equals("EMPLOYEE")) {
            users = IUserRepository.searchEmployee(request.getKeyword(), request.getPageable("userId"));
        } else if (accountType.equals("CUSTOMER")) {
            users = IUserRepository.searchCustomer(request.getKeyword(), request.getPageable("userId"));
        } else {
            users = IUserRepository.search(request.getKeyword(), request.getPageable("userId"));
        }
        var dtos = users.map(user -> modelMapper.map(user, UserDto.class));
        return HandleResponse.ok(Paginated.of(dtos));
    }

}
