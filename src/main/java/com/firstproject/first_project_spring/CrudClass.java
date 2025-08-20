package com.firstproject.first_project_spring;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;



import org.springframework.ui.Model;



@Controller
public class CrudClass {
    List<Item> items = new ArrayList<>();
    @GetMapping("/")
    public String getItems(Model model) {              
        Item item = new Item();
        model.addAttribute("item", item);
        return "itemForm";
    }
    @PostMapping("/dataSubmitForm")
    public String dataSubmitForm(Item item) {
        
        items.add(item);
        return "redirect:/getAllItems";
    }
    @GetMapping("getAllItems")
    public String getAllItems(Model model) {
        model.addAttribute("allItems", items);
        return "items";
    }
    
    
}
