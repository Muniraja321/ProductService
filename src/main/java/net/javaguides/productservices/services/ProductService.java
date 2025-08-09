package net.javaguides.productservices.services;

import net.javaguides.productservices.NotFoundException;
import net.javaguides.productservices.dtos.GenericProductDto;

import java.util.List;

public interface ProductService  {

    public GenericProductDto getProductById(Long id) throws NotFoundException;

    public GenericProductDto createProduct(GenericProductDto genericProductDto);



    public GenericProductDto updateProductById(Long id, GenericProductDto genericProductDto);

    public List<GenericProductDto> getAllProducts();

    public GenericProductDto deleteProduct(Long id);


}