package com.shop.tomford.controller.admin;

import com.shop.tomford.common.Cqrs.ISender;
import lombok.AllArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
@RequestMapping("/admin/supplier")
@Secured("SUPPLIER_MANAGEMENT")
public class SupplierController {
    private final ISender sender;

    @GetMapping()
    public String index(Model model) {

        return "admin/supplier/index";
    }
}
