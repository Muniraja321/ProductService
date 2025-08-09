package net.javaguides.productservices.services;

import net.javaguides.productservices.NotFoundException;
import net.javaguides.productservices.thirdpartyclients.FakeStoreProductClient;
import net.javaguides.productservices.thirdpartyclients.FakeStoreProductDto;
import net.javaguides.productservices.dtos.GenericProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service("fakeStoreProductService")
@Primary
public class FakeStoreProductService implements ProductService {

   private FakeStoreProductClient fakeStoreProductClient;

    @Autowired
    public FakeStoreProductService(FakeStoreProductClient fakeStoreProductClient){
        this.fakeStoreProductClient = fakeStoreProductClient;
    }

    public GenericProductDto convertFakeStoreProductDtoToGenericProductDto(FakeStoreProductDto fakeStoreProductDto){

        if(fakeStoreProductDto == null) {
            return null;
        }

        GenericProductDto genericProductDto = new GenericProductDto();
        genericProductDto.setId(fakeStoreProductDto.getId());
        genericProductDto.setTitle(fakeStoreProductDto.getTitle());
        genericProductDto.setCategory(fakeStoreProductDto.getCategory());
        genericProductDto.setPrice(fakeStoreProductDto.getPrice());
        genericProductDto.setImage(fakeStoreProductDto.getImage());
        genericProductDto.setDescription(fakeStoreProductDto.getDescription());

        return genericProductDto;

    }


    @Override
    public GenericProductDto getProductById(Long id) throws NotFoundException{
        System.out.println("calling from fake store product service");
        return convertFakeStoreProductDtoToGenericProductDto(fakeStoreProductClient.getProductById(id));
    }

    @Override
    public GenericProductDto createProduct(GenericProductDto product) {

        return convertFakeStoreProductDtoToGenericProductDto(fakeStoreProductClient.createProduct(product));
    }

    @Override
    public GenericProductDto updateProductById(Long id,GenericProductDto product) {

        return  convertFakeStoreProductDtoToGenericProductDto(fakeStoreProductClient.updateProductById(id, product));



    }

    @Override
    public List<GenericProductDto> getAllProducts() {


        List<FakeStoreProductDto> fakeStoreProductDtos = fakeStoreProductClient.getAllProducts();
        List<GenericProductDto> genericProductDtos = new ArrayList<>();
        for(FakeStoreProductDto fakeStoreProductDto: fakeStoreProductDtos){

            GenericProductDto genericProductDto = convertFakeStoreProductDtoToGenericProductDto(fakeStoreProductDto);

            genericProductDtos.add(genericProductDto);

        }


        return genericProductDtos;
    }

    @Override
    public GenericProductDto deleteProduct(Long id) {

       return convertFakeStoreProductDtoToGenericProductDto(fakeStoreProductClient.deleteProduct(id));
    }
}

