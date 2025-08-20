package com.firstproject.first_project_spring;

public class Item {
    private Integer id;
    private String name;
    private Double price;
    public Item(Integer id, String name, Double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
    public Item(){};
    public Integer getId() {
        return this.id;
    }
    public void setId(Integer newId) {
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
}
