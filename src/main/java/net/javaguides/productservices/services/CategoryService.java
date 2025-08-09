package net.javaguides.productservices.services;

import jakarta.transaction.Transactional;
import net.javaguides.productservices.Repositories.CategoryRepository;
import net.javaguides.productservices.models.Category;
import net.javaguides.productservices.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CategoryService {

    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }

    @Transactional
    public void getCategory(String uuid){

        Optional<Category> categoryOptional = categoryRepository.findById(UUID.fromString(uuid));
        Category category=categoryOptional.get();
        System.out.println(category);

         List<Product> products = category.getProduct();


    }
}
