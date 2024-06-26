package com.shop.tomford.user.query.getMyProfile;

import com.shop.tomford.auth.repository.IUserRepository;
import com.shop.tomford.common.Cqrs.HandleResponse;
import com.shop.tomford.common.Cqrs.IRequestHandler;
import com.shop.tomford.config.CurrentUserService;
import com.shop.tomford.user.UserDto;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class GetMyProfileQueryHandler implements IRequestHandler<GetMyProfileQuery, UserDto> {
    private final IUserRepository IUserRepository;
    private final ModelMapper modelMapper;
    private final CurrentUserService currentUserService;

    @Override
    public HandleResponse<UserDto> handle(GetMyProfileQuery getMyProfileQuery) {
        var currentUserId = currentUserService.getCurrentUserId();
        if (currentUserId.isEmpty()) {
            return HandleResponse.error("Bạn chưa đăng nhập");
        }
        var user = IUserRepository.findById(currentUserId.get());
        if (user.isEmpty()) {
            return HandleResponse.error("Không tìm thấy người dùng");
        }
        var dto = modelMapper.map(user.get(), UserDto.class);
        dto.setPermissions(user.get().getPermissions());
        return HandleResponse.ok(dto);
    }
}
