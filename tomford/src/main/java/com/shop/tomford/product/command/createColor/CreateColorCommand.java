package com.shop.tomford.product.command.createColor;

import com.shop.tomford.common.Cqrs.IRequest;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CreateColorCommand implements IRequest<Integer> {
    @NotNull(message = "Tên màu không được để trống")
    @NotEmpty(message = "Tên màu không được để trống")
    private String name;

    private String image;
}
