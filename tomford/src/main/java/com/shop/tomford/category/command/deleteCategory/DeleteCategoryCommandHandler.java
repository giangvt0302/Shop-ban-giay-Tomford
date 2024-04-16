package com.shop.tomford.category.command.deleteCategory;

import com.shop.tomford.category.CategoryRepository;
import com.shop.tomford.common.Cqrs.HandleResponse;
import com.shop.tomford.common.Cqrs.IRequestHandler;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class DeleteCategoryCommandHandler implements IRequestHandler<DeleteCategoryCommand, Void> {
    private final CategoryRepository categoryRepository;

    @Override
    @Transactional
    public HandleResponse<Void> handle(DeleteCategoryCommand deleteCategoryCommand) {
        var category = categoryRepository.findById(deleteCategoryCommand.id());
        if (category.isEmpty()) {
            return HandleResponse.error("Category not found");
        }
        if(category.get().getChildren().isEmpty() && category.get().getProducts().isEmpty()){
            categoryRepository.hardDeleteById(deleteCategoryCommand.id());
            return HandleResponse.ok();
        }

        categoryRepository.delete(category.get());

        return HandleResponse.ok();

    }


}
