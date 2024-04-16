package com.shop.tomford.stockReceipt.entity;

import com.shop.tomford.common.AuditableEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table

public class StockReceipt extends AuditableEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false,name = "stock_receipt_id")
    private int stockReceiptId;

    @Column(nullable = false)
    private int total = 0;

    @Column(length = 255)
    private String note;

    @ManyToOne(fetch = FetchType.EAGER)
    private Supplier supplier;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "stock_receipt_id")
    private java.util.List<StockReceiptItem> stockReceiptItems;



}
