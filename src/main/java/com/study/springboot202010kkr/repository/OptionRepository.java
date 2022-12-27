package com.study.springboot202010kkr.repository;

import com.study.springboot202010kkr.web.dto.CategoryDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OptionRepository {
    public int saveCategory(CategoryDto categoryDto);
    public List<CategoryDto> getCategories();
    public CategoryDto getCategory(int categoryId);
    public int modifyCategory(CategoryDto categoryDto);
}
