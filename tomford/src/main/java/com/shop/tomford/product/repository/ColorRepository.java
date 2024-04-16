package com.shop.tomford.product.repository;

import com.shop.tomford.product.entity.Color;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ColorRepository  extends JpaRepository<Color,Integer> {
    Optional<Color> findByNameIgnoreCase(String name);
}
