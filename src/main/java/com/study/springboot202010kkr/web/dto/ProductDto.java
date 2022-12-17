package com.study.springboot202010kkr.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductDto {
    private String productCode;
    private String productName;
    private String price;
    private String stock;

}
