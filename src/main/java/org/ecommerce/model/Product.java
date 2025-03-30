package org.ecommerce.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name="product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId ;

    @NotNull
    @Column
    private String name;

    @NotNull
    @Column(length = 1000)
    private String description;

    @NotNull
    @Column
    private double Price;

    @NotNull
    @Column
    private int stockQuantity;

    @NotNull
    @Column
    private String imageURL ;

    @NotNull
    @Column
    private int oldPrice;

    @NotNull
    @Column
    private  String fullDescription;

    @NotNull
    @Column
    private String brand;

    @NotNull
    @Column
    private  String shortDescription ;

    @NotNull
    @Column
    private int stock;

    @NotNull
    @Column
    private String[] features;


    public Product(){

    }

    public Product(String name,
                   String description,
                   double price,
                   int stockQuantity,
                   String imageURL,
                   int oldPrice,
                   String fullDescription ,
                   String brand,
                   String shortDescription,
                   int stock,
                   String[] features) {

        this.name = name;
        this.description = description;
        this.Price = price;
        this.stockQuantity =stockQuantity;
        this.imageURL = imageURL;
        this.oldPrice = oldPrice;
        this.fullDescription = fullDescription;
        this.brand = brand;
        this.shortDescription = shortDescription;
        this.stock = stock;
        this.features = features;


    }
}
