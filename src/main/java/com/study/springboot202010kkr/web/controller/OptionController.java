package com.study.springboot202010kkr.web.controller;

import com.study.springboot202010kkr.service.OptionService;
import com.study.springboot202010kkr.web.dto.CategoryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/api/option")
public class OptionController {

    @Autowired
    private OptionService optionService;

    @PostMapping("/category")
    public ResponseEntity<?> addCategory(@RequestBody CategoryDto categoryDto) {
        return ResponseEntity
                .created(URI.create("/api/option/category" + optionService.addCategory(categoryDto)))
                .body(categoryDto);
    }
    @GetMapping("/categories")
    public ResponseEntity<?> getCategories(){
      return ResponseEntity.ok(optionService.getCategories());
    };

    @GetMapping("/category/{categoryId}")
    public ResponseEntity<?> getCategory(@PathVariable int categoryId){
        CategoryDto categoryDto = optionService.getCategory(categoryId);
        return ResponseEntity.ok().body(categoryDto);
    }

    @PutMapping("/category/{categoryId}")
    public ResponseEntity<?> modifyCategory(@PathVariable int categoryId, @RequestBody CategoryDto categoryDto){
        optionService.modifyCategory(categoryId, categoryDto);
        return ResponseEntity.ok(true);
    }
}
