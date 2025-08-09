package net.javaguides.productservices.controllers;

import ch.qos.logback.core.net.SyslogOutputStream;
import net.javaguides.productservices.NotFoundException;
import net.javaguides.productservices.dtos.ExceptionDto;
import net.javaguides.productservices.dtos.GenericProductDto;
import net.javaguides.productservices.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class productController {

    //@Autowired --- Field Injection
    private ProductService productService;

    //Constructor Injection Preferred because of testing

    @Autowired
    public productController(@Qualifier("fakeStoreProductService") ProductService productService){
        this.productService = productService;
    }

    @GetMapping()
    public List<GenericProductDto> getAllProducts() {

        return productService.getAllProducts();
    }

    @GetMapping("{id}")
    public GenericProductDto getProductById(@PathVariable("id") Long id) throws NotFoundException {
        System.out.println("calling from methods");
        System.out.println("calling from methods again");
        GenericProductDto genericProductDto = productService.getProductById(id);

        if(genericProductDto == null){
            return new GenericProductDto();
        }

        return genericProductDto;

    }
    @PutMapping("{id}")

    public GenericProductDto updateProductById(@PathVariable("id") Long id , @RequestBody GenericProductDto genericProductDto){

        return productService.updateProductById(id, genericProductDto);

    }
    @PostMapping()
    public GenericProductDto createProduct(@RequestBody GenericProductDto genericProductDto){
         return productService.createProduct(genericProductDto);

    }

    @DeleteMapping("{id}")
    public GenericProductDto deleteProduct(@PathVariable("id") Long id){

        return productService.deleteProduct(id);
    }

//    @ExceptionHandler(NotFoundException.class)
//    public  ResponseEntity<ExceptionDto> handleNotFoundException (NotFoundException notFoundException) {
//      return new ResponseEntity<>(new ExceptionDto(HttpStatus.NOT_FOUND, notFoundException.getMessage()),
//               HttpStatus.NOT_FOUND);
//    }


}



