package com.firstproject.first_project_spring.repository;

import java.util.ArrayList;
import java.util.List;

import com.firstproject.first_project_spring.Item;

public class ItemRepository {
    private List<Item> items = new ArrayList<>();

    public Item getItemByIndex(int index) {
        return this.items.get(index);
     }
    public void addItem(Item item) {
        this.items.add(item);
    }

    public void updateItem(Item item ,int index) {
        this.items.set(index, item);
    }
    
    public List<Item> getItems() {
        return items;
    }
    
}
