package net.javaguides.productservices.services;

import net.javaguides.productservices.NotFoundException;
import net.javaguides.productservices.dtos.GenericProductDto;
import net.javaguides.productservices.thirdpartyclients.FakeStoreProductClient;
import net.javaguides.productservices.thirdpartyclients.FakeStoreProductDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class FakeStoreProductServiceTest {

    @Autowired
    private FakeStoreProductService fakeStoreProductService;

    @MockitoBean
    private FakeStoreProductClient fakeStoreProductClient;

    @Test
    public void testGetProductByIdReturnsNull() throws NotFoundException {

        when(fakeStoreProductClient.getProductById(any()))
                .thenReturn(null);

        GenericProductDto response = fakeStoreProductService.getProductById(any());

        Assertions.assertNull(response);

    }

    @Test
    public void testGetProductByIdReturnsCorrectResponse() throws NotFoundException {

        FakeStoreProductDto expected = new FakeStoreProductDto();
        expected.setId(1L);
        expected.setTitle("Android");

        when(fakeStoreProductClient.getProductById(1L))
                .thenReturn(expected);

       GenericProductDto response =  fakeStoreProductService.getProductById(1L);

       Assertions.assertNotNull(response);
       Assertions.assertEquals(1L,response.getId());
       Assertions.assertEquals("Android",response.getTitle());

    }

    @Test
    public void testGetProductByIdThrowsNotFoundException() throws NotFoundException {

        when(fakeStoreProductClient.getProductById(1L))
                .thenThrow(new NotFoundException("Product Not Found"));

        Assertions.assertThrows(NotFoundException.class,()->fakeStoreProductService.getProductById(1L));
    }

    @Test
    public void testCreateProduct_ReturnsNullResponse(){

        when(fakeStoreProductClient.createProduct(any(GenericProductDto.class)))
                .thenReturn(null);

        GenericProductDto response = fakeStoreProductService.createProduct(new GenericProductDto());

        Assertions.assertNull(response);

    }

    @Test
    public void testCreateProduct_ReturnsCorrectResponse(){

        FakeStoreProductDto expected  = new FakeStoreProductDto();
        expected.setId(1L);
        expected.setTitle("IPHONE");

        when(fakeStoreProductClient.createProduct(any(GenericProductDto.class)))
                .thenReturn(expected);

        GenericProductDto response = fakeStoreProductService.createProduct(new GenericProductDto());

        Assertions.assertNotNull(response);
        Assertions.assertEquals(1L,response.getId());
        Assertions.assertEquals("IPHONE",response.getTitle());

    }

    @Test
    public void testCreateProductThrowsRuntimeException(){

        when(fakeStoreProductClient.createProduct(any(GenericProductDto.class)))
                .thenThrow(new RuntimeException());
        Assertions.assertThrows(RuntimeException.class,()->fakeStoreProductService.createProduct(new GenericProductDto()));

    }





}
