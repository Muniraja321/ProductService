package net.javaguides.productservices.models;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.List;

@Getter
@Setter
@Entity
public class Category extends BaseModel{

    private String name;
    //fetch = FetchType.LAZY

    @OneToMany(mappedBy = "category", fetch = FetchType.EAGER)
    // fetch type tells us when to fetch the data whereas fetch mode tells us how to fetch that the queries work
   // @Fetch(FetchMode.JOIN)
    //@Fetch(FetchMode.SELECT)
    //@Fetch(FetchMode.SUBSELECT)
    private List<Product> product;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Product> getProduct() {
        return product;
    }

    public void setProduct(List<Product> product) {
        this.product = product;
    }
}
