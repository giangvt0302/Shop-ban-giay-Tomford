package com.shop.tomford.report.endpoint;

import com.shop.tomford.common.Cqrs.ISender;
import com.shop.tomford.report.dto.CategoryReportDto;
import com.shop.tomford.report.dto.ImportProductReportDto;
import com.shop.tomford.report.dto.ProductReportDto;
import com.shop.tomford.report.dto.SoldReportDto;
import com.shop.tomford.report.query.getCategoryReport.GetReportByCategoryQuery;
import com.shop.tomford.report.query.getImportReport.GetImportReportQuery;
import com.shop.tomford.report.query.getSoldReport.GetSoldReportQuery;
import com.shop.tomford.report.query.getTopSoldProductReport.GetTopSoldProductReportQuery;
import lombok.AllArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RequestMapping("/api/report")
@RestController
public class ReportApiController {
    private final ISender sender;

    @GetMapping("/sold")
    public ResponseEntity<List<SoldReportDto>> getSoldReport(@ParameterObject GetSoldReportQuery getSoldReportQuery) throws Exception {
        var result = sender.send(getSoldReportQuery); //
        return ResponseEntity.ok(result.orThrow());
    }

    @GetMapping("/import")
    public ResponseEntity<List<ImportProductReportDto>> getImportReport(@ParameterObject GetImportReportQuery query) throws Exception {
        var result = sender.send(query); //
        return ResponseEntity.ok(result.orThrow());
    }

    @GetMapping("/top-sold")
    public ResponseEntity<List<ProductReportDto>> getTopSoldProductReport(@ParameterObject GetTopSoldProductReportQuery query) throws Exception {
        var result = sender.send(query); //
        return ResponseEntity.ok(result.orThrow());
    }

    @GetMapping("/category")
    public ResponseEntity<List<CategoryReportDto>> getCategoryReport(@ParameterObject GetReportByCategoryQuery query) throws Exception {
        var result = sender.send(query); //
        return ResponseEntity.ok(result.orThrow());
    }
}
