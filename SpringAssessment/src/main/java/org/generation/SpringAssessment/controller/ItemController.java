package org.generation.SpringAssessment.controller;

import org.generation.SpringAssessment.controller.dto.ItemDto;
import org.generation.SpringAssessment.repository.entity.Item;
import org.generation.SpringAssessment.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.time.LocalDate;


@RestController
@RequestMapping("/item")
public class ItemController {

    //ItemController is dependent on ItemService to perform the save, delete, all, findItemById

    final ItemService itemService;

    public ItemController(@Autowired ItemService itemService) {
        this.itemService = itemService;
    }

    //1)) Create an API endpoint for GET HTTP Request from the client
    //CORS (Cross-origin resource sharing)
    @CrossOrigin
    @GetMapping("/all")
    public Iterable<Item> getItems() {
        return itemService.all();
    }


    //2) Create an An API endpoint for POST HTTP Request from the client
    @CrossOrigin
    @PostMapping("/add")
    public void save(@RequestParam(name = "Title", required = true) String Title,
                     @RequestParam(name = "Description", required = true) String Description,
                     @RequestParam(name = "TargetDate", required = true) LocalDate TargetDate) {
        ItemDto itemDto = new ItemDto(Title, Description, TargetDate);
        itemService.save(new Item(itemDto));
    }


    }
