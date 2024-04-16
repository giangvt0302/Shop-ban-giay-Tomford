package com.shop.tomford.product.query.getAllSizes;


import com.shop.tomford.common.Cqrs.HandleResponse;
import com.shop.tomford.common.Cqrs.IRequestHandler;
import com.shop.tomford.product.repository.ProductOptionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;

@AllArgsConstructor
@Service

public class GetAllSizesQueryHandler  implements IRequestHandler<GetAllSizesQuery,Collection<String>> {
   private final ProductOptionRepository productOptionRepository;

    @Override
    public HandleResponse<Collection<String>> handle(GetAllSizesQuery getAllSizesQuery) throws Exception {
        return HandleResponse.ok(productOptionRepository.getAllSizes());
    }
}
