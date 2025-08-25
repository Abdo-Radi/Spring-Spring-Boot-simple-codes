package com.firstproject.first_project_spring;

import jakarta.validation.constraints.NotBlank;
import java.util.UUID;


public class Item {
    
    private String id;
    @NotBlank(message = "the name input should not be blank")
    private String name;
    @NotBlank(message = "the brand input should not be blank")
    private String brand;
    private Double price;
    // public Item(String id, String name, String brand, Double price) {
    //     this.id = id;        
    //     this.name = name;
    //     this.brand = brand;
    //     this.price = price;
    // }
    public Item(){
        this.id = UUID.randomUUID().toString();
    };
    
    public String getId() {
        return this.id;
    }
    public void setId(String newId) {
        this.id = newId;
    }

    public String getName() {
        return this.name;
    }
    public void setName(String newName) {
        this.name = newName;
    }

    public Double getPrice() {
        return this.price;
    }
    public void setPrice(Double newPrice) {
        this.price = newPrice;
    }
    public String getBrand() {
        return brand;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }
}
