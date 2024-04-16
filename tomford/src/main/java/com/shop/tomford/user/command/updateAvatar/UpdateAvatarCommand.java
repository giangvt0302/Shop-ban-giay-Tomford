package com.shop.tomford.user.command.updateAvatar;

import com.shop.tomford.common.Cqrs.IRequest;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;


@Getter
@Setter
public class UpdateAvatarCommand implements IRequest<String> {
    private MultipartFile file;
}
