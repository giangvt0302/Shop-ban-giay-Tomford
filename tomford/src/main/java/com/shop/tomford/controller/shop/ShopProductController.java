package com.shop.tomford.controller.shop;

import com.shop.tomford.category.query.getAllCategories.GetAllCategoriesQueries;
import com.shop.tomford.common.Cqrs.ISender;
import com.shop.tomford.product.dto.ProductDetailDto;
import com.shop.tomford.product.query.getAllColors.GetAllColorQuery;
import com.shop.tomford.product.query.getAllSizes.GetAllSizesQuery;
import com.shop.tomford.product.query.getProductById.GetProductByIdQuery;
import com.shop.tomford.product.query.getProductBySlug.GetProductBySlugQuery;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.server.ResponseStatusException;

@Controller
@AllArgsConstructor
@RequestMapping("/product")
public class ShopProductController {
    private final ISender sender;
    @GetMapping("{slug}")
    public String productDetail(Model model, @PathVariable String slug) {
        var regex = "[0-9]+";
        com.shop.tomford.common.Cqrs.HandleResponse<ProductDetailDto> result;
        if (slug.matches(regex)) {
            result = sender.send(new GetProductByIdQuery(Integer.parseInt(slug)));
        } else {
            result = sender.send(new GetProductBySlugQuery(slug));
        }
        if (result.hasError()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Không tìm thấy sản phẩm");
        }

        model.addAttribute("product", result.get());

        return "productDetail";
    }
    @GetMapping("/search")
    public String searchProduct(Model model) {
        var getAllCategoriesQueries = new GetAllCategoriesQueries();
        getAllCategoriesQueries.setPageSize(1000);
        getAllCategoriesQueries.setSortDir("asc");
        getAllCategoriesQueries.setSortField("name");
        var categories = sender.send(getAllCategoriesQueries).get();
        model.addAttribute("categories", categories.getData());
        var allColors = sender.send(new GetAllColorQuery()).get();
        model.addAttribute("colors", allColors);
        var allSizes = sender.send(new GetAllSizesQuery()).get();
        model.addAttribute("sizes", allSizes);

        return "search";
    }
}
