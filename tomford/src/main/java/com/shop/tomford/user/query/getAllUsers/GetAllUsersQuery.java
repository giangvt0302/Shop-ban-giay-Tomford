package com.shop.tomford.user.query.getAllUsers;


import com.shop.tomford.common.PaginationRequest;
import com.shop.tomford.common.Cqrs.IRequest;
import com.shop.tomford.common.dto.Paginated;

import com.shop.tomford.user.UserDto;
import lombok.*;


@Getter
@Setter

public class GetAllUsersQuery extends PaginationRequest implements IRequest<Paginated<UserDto>>{
    private String accountType = "ALL";

}
