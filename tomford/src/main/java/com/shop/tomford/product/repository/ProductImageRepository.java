package com.shop.tomford.product.repository;

import com.shop.tomford.product.entity.ProductImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductImageRepository extends JpaRepository<ProductImage, Integer> {
    Optional<ProductImage> findByUrl(String url);
}
