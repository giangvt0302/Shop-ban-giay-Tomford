package com.shop.tomford.category.command.createCategory;

import com.shop.tomford.category.Category;
import com.shop.tomford.category.CategoryRepository;
import com.shop.tomford.common.Cqrs.HandleResponse;
import com.shop.tomford.common.Cqrs.IRequestHandler;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class CreateCategoryCommandHandler implements IRequestHandler<CreateCategoryCommand, Integer> {

    private final CategoryRepository categoryRepository;
    @Override
    @Transactional
    public HandleResponse<Integer> handle(CreateCategoryCommand request)  {
        var category = new Category();
        var parent = categoryRepository.findById(request.getParentId());
        if (request.getParentId() != 0 && parent.isEmpty()) {
            return HandleResponse.error("Danh mục cha không tồn tại");
        }
        var categoryByName = categoryRepository.findByName(request.getName());
        if (categoryByName.isPresent()) {
            return HandleResponse.error("Danh mục đã tồn tại");
        }
        category.setName(request.getName());
        category.setParent(parent.orElse(null));
        categoryRepository.save(category);
        return HandleResponse.ok(category.getCategoryId());
    }
}
