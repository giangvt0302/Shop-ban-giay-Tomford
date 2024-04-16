package com.shop.tomford.product.command.deleteProductImage;

import com.shop.tomford.common.Cqrs.HandleResponse;
import com.shop.tomford.common.Cqrs.IRequestHandler;
import com.shop.tomford.file.IFileService;
import com.shop.tomford.product.repository.ProductImageRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class DeleteProductImageCommandHandler implements IRequestHandler<DeleteProductImageCommand,Void> {
   private final IFileService fileService;
   private final ProductImageRepository productImageRepository;

    @Override
    public HandleResponse<Void> handle(DeleteProductImageCommand deleteProductImageCommand) throws Exception {
        var productImage = productImageRepository.findByUrl(deleteProductImageCommand.url());
        if(productImage.isEmpty()){
            return HandleResponse.error("Product image not found");
        }
        fileService.deleteFile(deleteProductImageCommand.url());
        productImageRepository.delete(productImage.get());
        return HandleResponse.ok();
    }
}
