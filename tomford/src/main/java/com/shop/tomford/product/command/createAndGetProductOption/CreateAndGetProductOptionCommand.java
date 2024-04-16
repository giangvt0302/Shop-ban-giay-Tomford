package com.shop.tomford.product.command.createAndGetProductOption;

import com.shop.tomford.common.Cqrs.IRequest;
import com.shop.tomford.product.dto.ProductOptionDetailDto;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class CreateAndGetProductOptionCommand implements IRequest<ProductOptionDetailDto> {
    @NotNull(message = "Màu không được để trống")
    @NotEmpty(message = "Màu không được để trống")
    private String colorName;
    @NotEmpty(message = "Size không được để trống")
    @NotNull(message = "Size không được để trống")
    private String size;
    private  int stock=0;
    @Min(value = 1, message = "Sản phẩm không hợp lệ")
    @NotNull(message = "Sản phẩm không được để trống")
    private int productId;
}
