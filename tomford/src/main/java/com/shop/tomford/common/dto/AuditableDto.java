package com.shop.tomford.common.dto;

import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class AuditableDto {
    //    private String createdBy;
    private java.time.LocalDateTime createdDate;

    public String getCreatedDateDisplay() {
        return createdDate == null ? "" : createdDate.format(java.time.format.DateTimeFormatter.ofPattern("hh:mm dd/MM/yyyy"));
    }
//    private String lastModifiedBy;
//    private java.time.LocalDateTime lastModifiedDate;
}
