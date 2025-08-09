package net.javaguides.productservices.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.action.internal.OrphanRemovalAction;

@Getter
@Setter
@Entity
public class Product extends BaseModel {
    private String title;
    private String description;
    private String image;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
//    private double price;

//cascade = CascadeType.REMOVE

//    @OneToOne()
//    private Price price;

    @OneToOne(cascade = {CascadeType.REMOVE, CascadeType.PERSIST} )
    private Price price;

    private int inventorycount;


}
