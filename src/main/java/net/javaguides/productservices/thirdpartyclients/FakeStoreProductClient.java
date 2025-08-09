package net.javaguides.productservices.thirdpartyclients;

import net.javaguides.productservices.NotFoundException;
import net.javaguides.productservices.dtos.GenericProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;


@Component
public class FakeStoreProductClient {

    @Value("${fakestore.api.baseurl}")
    private String fakeStoreApiBaseUrl;

    @Value("${fakestore.api.product}")
    private String fakeStoreProductPath;

    private final String productPath = "/products";


    private String producturl = fakeStoreApiBaseUrl + productPath + "/{id}";

    private String createProductUrl = "https://fakestoreapi.com/products/";
    private String productRequestUrl = fakeStoreApiBaseUrl + fakeStoreProductPath;


    //private String UpdateProductUrl = "https://fakestoreapi.com/products/{id}";

    private RestTemplateBuilder restTemplateBuilder;

    @Autowired
    public FakeStoreProductClient(RestTemplateBuilder restTemplateBuilder,
                                  @Value("${fakestore.api.baseurl}") String fakeStoreApiBaseUrl,
                                  @Value("${fakestore.api.product}") String fakeStoreProductPath) {
        this.restTemplateBuilder = restTemplateBuilder;
        this.producturl = fakeStoreApiBaseUrl + fakeStoreProductPath + "/{id}";
        this.productRequestUrl = fakeStoreApiBaseUrl + fakeStoreProductPath;
    }


    public FakeStoreProductDto getProductById(Long id) throws NotFoundException {


        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> response = restTemplate.getForEntity(producturl,
                FakeStoreProductDto.class,
                id);

        FakeStoreProductDto fakeStoreProductDto = response.getBody();

        if(fakeStoreProductDto == null){

            return null;

            //throw new NotFoundException("product with id:" + id + "Not found");

        }


        return fakeStoreProductDto;
    }


    public FakeStoreProductDto createProduct(GenericProductDto product) {

        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> response = restTemplate.postForEntity(createProductUrl,
                product,
                FakeStoreProductDto.class);

        FakeStoreProductDto fakeStoreProductDto = response.getBody();



        return fakeStoreProductDto;
    }





    public FakeStoreProductDto updateProductById(Long id,GenericProductDto product) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> response = restTemplate.exchange(
                producturl,
                HttpMethod.PUT,
                new HttpEntity<>(product),
                FakeStoreProductDto.class,
                id
        );
        FakeStoreProductDto fakeStoreProductDto = response.getBody();

        return fakeStoreProductDto;
    }

    public List<FakeStoreProductDto> getAllProducts() {

        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto[]> response = restTemplate.getForEntity(productRequestUrl,FakeStoreProductDto[].class);

        FakeStoreProductDto[] fakeStoreProductDtos = response.getBody();



        return Arrays.asList(fakeStoreProductDtos);
    }


    public FakeStoreProductDto deleteProduct(Long id) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> response = restTemplate.exchange(producturl,
                HttpMethod.DELETE,
                null,
                FakeStoreProductDto.class,
                id);
        FakeStoreProductDto fakeStoreProductDto = response.getBody();


        return fakeStoreProductDto;


    }
}
