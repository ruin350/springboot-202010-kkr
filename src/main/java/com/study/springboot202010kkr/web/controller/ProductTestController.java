package com.study.springboot202010kkr.web.controller;

import com.study.springboot202010kkr.web.dto.ProductDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ProductTestController {

    @GetMapping("/product/addition")
    public String loadAddition(){
        return "product/product_add";
    }

//    @PostMapping("/api/product")
//    public String registerProduct(HttpServletRequest request) {
//        System.out.println(request.getParameter("price"));
//        return "product/product_view";
//    }

//    @PostMapping("/api/product")
//    public String registerProduct(String productName ,@RequestParam("price") int p) {
//        System.out.println(productName);
//        System.out.println(p);
//        return "product/product_view";
//    }
    @PostMapping("/api/product")
    public String registerProduct(Model model, ProductDto dto) {
        model.addAttribute("productDto", dto);
        System.out.println(dto);

        return "product/product_view";
    }

    @GetMapping("/product/addition2")
    public String loadAddition2() {
        return "product/product_add2";
    }

    @ResponseBody
    @PostMapping("/api/product/2")
    public String registerProduct(@RequestBody ProductDto productDto) {
        System.out.println(productDto);
        return "텍스트 데이터 응답";
    }
}
