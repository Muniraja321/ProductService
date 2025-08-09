package net.javaguides.productservices.controllers;

import net.javaguides.productservices.models.Product;
import net.javaguides.productservices.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("category")
public class CategoryController {

    private CategoryService categoryService;


    public CategoryController(CategoryService categoryService){
        this.categoryService = categoryService;


    }

    @GetMapping("{uuid}")
    public void getCategory(@PathVariable("uuid") String uuid){
       categoryService.getCategory(uuid);
    }


}
