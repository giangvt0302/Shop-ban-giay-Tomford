package com.shop.tomford.auth.commands.resetPassword;

import com.shop.tomford.common.Cqrs.IRequest;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
public class ResetPasswordCommand implements IRequest<Void> {
    private String token;
    @Length(min = 8, message = "Mật khẩu phải có ít nhất 8 ký tự")
    private String newPassword;

}
