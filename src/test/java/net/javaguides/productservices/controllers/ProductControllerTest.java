package net.javaguides.productservices.controllers;

import net.javaguides.productservices.NotFoundException;
import net.javaguides.productservices.dtos.GenericProductDto;
import net.javaguides.productservices.services.ProductService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.Mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.context.bean.override.mockito.MockitoBean;

import static org.mockito.Mockito.*;

@SpringBootTest
//@ExtendWith(MockitoExtension.class)
public class ProductControllerTest {

    @Autowired
    private productController productController;


    @MockitoBean
    private ProductService ProductServiceMock;

//    private void productControllerTest(){
//
//        ProductServiceMock = Mockito.mock(ProductService.class);
//        productController = new productController(ProductServiceMock);
//
//    }



//    @MockitoBean
//    private ProductService productServiceMock;

    @Test
    public void testGetProductById() {

    }
//
//    //    @Test()
//    public void testMathOperations() {
//        int result = add(1, 2);
////        assert(result == 3);
//
////        Assertions.assertEquals(4, result, "Some failure happened");
////
////        Integer result2 = add2(1,2);
////
////        Assertions.assertNull(result2);
//
////        Assertions.assertThrows(NullPointerException.class,
////                () -> call());
//
////        boolean flag = false;
////        try {
////            call();
////        } catch (Exception e) {
////            Assertions.assertEquals(0,0);
////            flag = true;
////        }
////
////        if(flag == false) {
////            Assertions.assertEquals(0,1);
////        }
//
//        Assertions.assertThrows(NullPointerException.class, () -> doSomething());
//    }

//    private int add(int a, int b) {
//        return a + b;
//    }
//
//    private Integer add2(int a, int b) {
//        return null;
//    }
//
//    private void doSomething() {
//        throw new NullPointerException();
//    }


//    @Test
//    public void testGetProductByIdReturnsEmptyObjectWhenNoProductIsFound() throws NotFoundException {
//        when(productServiceMock.getProductById(any(Long.class)))
//                .thenReturn(null);
//
//        GenericProductDto response = productController.getProductById(1L);
//
//        Assertions.assertNotNull(response);
//    }
//
//    @Test
//    public void testGetProductByIdReturnsCorrectResponse() throws NotFoundException {
//        GenericProductDto expectedOutput = new GenericProductDto();
//        expectedOutput.setId(1L);
//        expectedOutput.setTitle("iPhone");
//
//        GenericProductDto toBeReturned = new GenericProductDto();
//        toBeReturned.setId(1L);
//        toBeReturned.setTitle("iPhone");
//
//        when(productServiceMock.getProductById(any()))
//                .thenReturn(toBeReturned);
//
//        GenericProductDto response = productController.getProductById(1L);
//
//        Assertions.assertEquals(response.getId(),toBeReturned.getId());
//        Assertions.assertEquals(response.getTitle(),toBeReturned.getTitle());
//
//
       @Test
       public void testGetProductByIdReturnsEmptyObjectWhenNoProductIsFound() throws NotFoundException {

       when(ProductServiceMock.getProductById(1L)).thenReturn(null);

       GenericProductDto response = productController.getProductById(1L);

      Assertions.assertNotNull(response);

}

@Test
    public void testGetProductByIdReturnsCorrectResponse() throws NotFoundException {

    GenericProductDto expectedOutput = new GenericProductDto();

    expectedOutput.setId(1L);
    expectedOutput.setTitle("Android");

    GenericProductDto toBeReturned = new GenericProductDto();

    toBeReturned.setId(1L);
    toBeReturned.setTitle("Android");


    when(ProductServiceMock.getProductById(1L))
            .thenReturn(toBeReturned);

    GenericProductDto response = productController.getProductById(1L);

   Assertions.assertEquals(response.getId(),toBeReturned.getId());
   Assertions.assertEquals(response.getTitle(),toBeReturned.getTitle());

}

@Test
public void testGetProductByIdThrowsNotFoundException() throws NotFoundException {

    when(ProductServiceMock.getProductById(any()))
            .thenThrow(new NotFoundException("Product Not Found"));

    Assertions.assertThrows(NotFoundException.class,()-> productController.getProductById(1L));
}

@Test
public void testCreateProduct_NullResponse(){

    when(ProductServiceMock.createProduct(any(GenericProductDto.class)))
            .thenReturn(null);

    GenericProductDto response = productController.createProduct(new GenericProductDto());

    Assertions.assertNull(response);

}

@Test
public void testCreateProductReturns_CorrectResponse(){

    GenericProductDto expected = new GenericProductDto();

    expected.setId(1L);
    expected.setTitle("Android");

    when(ProductServiceMock.createProduct(any(GenericProductDto.class)))
            .thenReturn(expected);

//    GenericProductDto toBeReturned = new GenericProductDto();
//    toBeReturned.setId(1L);
//    toBeReturned.setTitle("Android");

    GenericProductDto response = productController.createProduct(new GenericProductDto());

    Assertions.assertNotNull(response);
    Assertions.assertEquals(1L,response.getId());
    Assertions.assertEquals("Android",response.getTitle());

}

@Test
public void testCreateProductThrowsRunTimeException(){

    when(ProductServiceMock.createProduct(any(GenericProductDto.class)))
            .thenThrow(new RuntimeException("Unable to createProduct"));

    Assertions.assertThrows(RuntimeException.class,()->productController.createProduct(new GenericProductDto()));

}
































}
