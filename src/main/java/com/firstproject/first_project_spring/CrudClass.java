package com.firstproject.first_project_spring;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;



@Controller
public class CrudClass {
    List<Item> items = new ArrayList<>();
    @GetMapping("/")
    public String getItems(Model model, @RequestParam(required = false) String id) {              
        int index = getItemIndex(id);
        model.addAttribute("item", index == Constant.No_Match ? new Item() : items.get(index));
        return "itemForm";
    }

    public int getItemIndex (String id) {
        for(int i=0; i< items.size(); i++) {
            if(items.get(i).getId().equals(id)) return i;
        }
        return Constant.No_Match;
    }
    @PostMapping("/dataSubmitForm")
    public String dataSubmitForm(@Valid @ModelAttribute("item") Item item, BindingResult result) {
        if(result.hasErrors()) {
            return "itemForm";
        }
        int index = getItemIndex(item.getId());
        if(index == Constant.No_Match) {
            items.add(item);
        } else {
            items.set(index, item);
        }
        return "redirect:/getAllItems";
    }
    @GetMapping("getAllItems")
    public String getAllItems(Model model) {
        model.addAttribute("allItems", items);
        return "items";
    }
    
    
}
