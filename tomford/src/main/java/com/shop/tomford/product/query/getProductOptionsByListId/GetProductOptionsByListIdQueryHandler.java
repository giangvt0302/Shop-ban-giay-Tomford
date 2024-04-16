package com.shop.tomford.product.query.getProductOptionsByListId;

import com.shop.tomford.common.Cqrs.HandleResponse;
import com.shop.tomford.common.Cqrs.IRequestHandler;
import com.shop.tomford.product.dto.ProductOptionDetailDto;
import com.shop.tomford.product.repository.ProductOptionRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@AllArgsConstructor
@Service
public class GetProductOptionsByListIdQueryHandler implements IRequestHandler<GetProductOptionsByListIdQuery, List<ProductOptionDetailDto>> {
   private final ProductOptionRepository productOptionRepository;
   private final ModelMapper modelMapper;

    @Override
    @Transactional(readOnly = true)
    public HandleResponse<List<ProductOptionDetailDto>> handle(GetProductOptionsByListIdQuery getProductOptionsByListIdQuery) {
        var productOptions = productOptionRepository.findAllById(getProductOptionsByListIdQuery.ids());
        var productOptionDetailDtos = productOptions.stream().map(productOption -> modelMapper.map(productOption, ProductOptionDetailDto.class)).toList();
        return HandleResponse.ok(productOptionDetailDtos);
    }
}
