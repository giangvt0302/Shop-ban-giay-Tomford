package com.shop.tomford.user.query.getMyProfile;

import com.shop.tomford.common.Cqrs.IRequest;
import com.shop.tomford.user.UserDto;


public record GetMyProfileQuery() implements IRequest<UserDto> {

}
