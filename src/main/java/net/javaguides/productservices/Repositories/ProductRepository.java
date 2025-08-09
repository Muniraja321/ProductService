package net.javaguides.productservices.Repositories;

import net.javaguides.productservices.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository

public interface ProductRepository extends JpaRepository<Product, UUID> {

   //List<Product> findByTitleAndPrice_currency(String Title, String currency);


//   @Query(value = "select * from Product where title = title", nativeQuery = true)
//    List<Product> findByTitle(String Title);
}
