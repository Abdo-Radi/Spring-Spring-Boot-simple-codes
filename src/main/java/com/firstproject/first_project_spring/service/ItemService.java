package com.firstproject.first_project_spring.service;

import java.util.List;

import com.firstproject.first_project_spring.Constant;
import com.firstproject.first_project_spring.Item;
import com.firstproject.first_project_spring.repository.ItemRepository;

public class ItemService {
    ItemRepository itemRepository = new ItemRepository();

    public Item getItemByIndex(int index) {
        return this.itemRepository.getItemByIndex(index);
    }
    public void addItem(Item item) {
        this.itemRepository.addItem(item);
    }

    public void updateItem(int index, Item item) {
        this.itemRepository.updateItem(item, index);
    }

    public int getItemIndex (String id) {
        for(int i=0; i< getAllItems().size(); i++) {
            if(getItemByIndex(i).getId().equals(id)) return i;
        }
        return Constant.No_Match;
    }

    public Item getItemById(String id) {
        int index = getItemIndex(id);
        return index == Constant.No_Match ? new Item() : getItemByIndex(index);
    }

    public void resolveItem(Item item) {
        int index = getItemIndex(item.getId());
        if(index == Constant.No_Match) {
            addItem(item);
        } else {
            updateItem(index, item);
        }
    }

    public List<Item> getAllItems() {
        return itemRepository.getItems();
    }
    
}
