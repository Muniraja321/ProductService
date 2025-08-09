package net.javaguides.productservices.thirdpartyclient;

import net.javaguides.productservices.NotFoundException;
import net.javaguides.productservices.dtos.GenericProductDto;
import net.javaguides.productservices.thirdpartyclients.FakeStoreProductClient;
import net.javaguides.productservices.thirdpartyclients.FakeStoreProductDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.web.client.RestTemplate;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@SpringBootTest
public class FakeStoreProductClientTest {

    @Autowired
    private FakeStoreProductClient fakeStoreProductClient;

    @MockitoBean
    private RestTemplateBuilder restTemplateBuilder;

    private RestTemplate restTemplate;

    @BeforeEach
    void setUp(){
         restTemplate = Mockito.mock(RestTemplate.class);

        when(restTemplateBuilder.build())
                .thenReturn(restTemplate);



    }

    @Test
    public void testFakeStoreProductClientGetProductById_ReturnsNull() throws NotFoundException {


//            RestTemplate restTemplate = Mockito.mock(RestTemplate.class);
//
//            when(restTemplateBuilder.build())
//                    .thenReturn(restTemplate);
//
            ResponseEntity<FakeStoreProductDto> responseMock = new ResponseEntity<>(null, HttpStatus.OK);



        when(restTemplate.getForEntity(anyString(), eq(FakeStoreProductDto.class),any(Long.class)))
                .thenReturn(responseMock);

        FakeStoreProductDto response = fakeStoreProductClient.getProductById(1L);

        Assertions.assertNull(response);

    }

    @Test
    public void testFakeStoreProductClientGetProductById_ReturnsCorrectResponse() throws NotFoundException {

        FakeStoreProductDto expected = new FakeStoreProductDto();
        expected.setId(1L);
        expected.setTitle("iphone");

        ResponseEntity<FakeStoreProductDto> responseMock = new ResponseEntity<>(expected, HttpStatus.OK);

        when(restTemplate.getForEntity(anyString(),eq(FakeStoreProductDto.class),any(Long.class)))
                .thenReturn(responseMock);

        FakeStoreProductDto response = fakeStoreProductClient.getProductById(1L);

        Assertions.assertNotNull(response);
        Assertions.assertEquals(1L,response.getId());
        Assertions.assertEquals("iphone",response.getTitle());

    }

    @Test
    public void testFakeStoreProductClientGetProductById_ThrowsRunTimeException(){

        when(restTemplate.getForEntity(anyString(),eq(FakeStoreProductDto.class),any(Long.class)))
                .thenThrow(new RuntimeException("ProductNotFound"));

        Assertions.assertThrows(RuntimeException.class,()->fakeStoreProductClient.getProductById(1L));
    }


}
