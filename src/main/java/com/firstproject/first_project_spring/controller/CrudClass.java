package com.firstproject.first_project_spring.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.firstproject.first_project_spring.Item;
import com.firstproject.first_project_spring.service.ItemService;

import jakarta.validation.Valid;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;



@Controller
public class CrudClass {
    ItemService itemService = new ItemService();
    @GetMapping("/")
    public String getItems(Model model, @RequestParam(required = false) String id) {              
        model.addAttribute("item", itemService.getItemById(id));
        return "itemForm";
    }

    
    @PostMapping("/dataSubmitForm")
    public String dataSubmitForm(@Valid @ModelAttribute("item") Item item, BindingResult result) {
        if(result.hasErrors()) {
            return "itemForm";
        }
        this.itemService.resolveItem(item);
        return "redirect:/getAllItems";
    }
    @GetMapping("getAllItems")
    public String getAllItems(Model model) {
        model.addAttribute("allItems", itemService.getAllItems());
        return "items";
    }
    
    
}
