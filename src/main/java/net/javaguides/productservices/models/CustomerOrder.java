package net.javaguides.productservices.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

import java.util.List;

@Getter
@Setter
@Entity(name = "customer_orders")
public class CustomerOrder extends BaseModel {

    @ManyToMany
    @JoinTable(
            name = "CustomerOrder_Product",
            joinColumns = @JoinColumn(name = "CustomerordersId"),
            inverseJoinColumns = @JoinColumn(name = "productId")
    )
    private List<Product> products;
}
