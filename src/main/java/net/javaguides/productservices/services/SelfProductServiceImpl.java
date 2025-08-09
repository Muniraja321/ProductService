package net.javaguides.productservices.services;

import net.javaguides.productservices.dtos.GenericProductDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("SelfProductServiceImpl")
public class SelfProductServiceImpl implements ProductService{
    @Override
    public GenericProductDto getProductById(Long id) {
        System.out.println("calling from SelfProductServiceImpl");
        return null;
    }

    @Override
    public GenericProductDto createProduct(GenericProductDto genericProductDto) {
        return null;
    }

    @Override
    public GenericProductDto updateProductById(Long id, GenericProductDto genericProductDto){
        return null;
  }

    @Override
    public List<GenericProductDto> getAllProducts() {
        return null;
    }

    @Override
    public GenericProductDto deleteProduct(Long id) {
        return null;
    }
}
