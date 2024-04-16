package com.shop.tomford.auth.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PermissionDto {

    private String normalizedName;

    private String displayName;

    private String description;
}
