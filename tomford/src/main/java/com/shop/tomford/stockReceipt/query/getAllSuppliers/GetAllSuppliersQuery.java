package com.shop.tomford.stockReceipt.query.getAllSuppliers;

import com.shop.tomford.common.Cqrs.IRequest;
import com.shop.tomford.common.PaginationRequest;
import com.shop.tomford.common.dto.Paginated;
import com.shop.tomford.stockReceipt.dto.SupplierDto;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class GetAllSuppliersQuery extends PaginationRequest implements IRequest<Paginated<SupplierDto>> {
}
