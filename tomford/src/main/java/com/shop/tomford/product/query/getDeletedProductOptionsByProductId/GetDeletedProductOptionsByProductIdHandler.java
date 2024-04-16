package com.shop.tomford.product.query.getDeletedProductOptionsByProductId;

import com.shop.tomford.common.Cqrs.HandleResponse;
import com.shop.tomford.common.Cqrs.IRequestHandler;
import com.shop.tomford.product.dto.ProductOptionDto;
import com.shop.tomford.product.repository.ProductOptionRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@AllArgsConstructor
@Service
public class GetDeletedProductOptionsByProductIdHandler implements IRequestHandler<GetDeletedProductOptionsByProductId, List<ProductOptionDto>> {
    private final ProductOptionRepository productOptionRepository;
    private final ModelMapper modelMapper;
    @Override
    @Transactional(readOnly = true)
    public HandleResponse<List<ProductOptionDto>> handle(GetDeletedProductOptionsByProductId getDeletedProductOptionsByProductId) throws Exception {
       var productOptions = productOptionRepository.getDeletedProductOptionsByProductId(getDeletedProductOptionsByProductId.productId());
         return HandleResponse.ok(productOptions.stream().map(productOption -> modelMapper.map(productOption, ProductOptionDto.class)).toList());
    }
}
