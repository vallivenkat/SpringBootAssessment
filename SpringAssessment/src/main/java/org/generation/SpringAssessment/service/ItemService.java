package org.generation.SpringAssessment.service;

import org.generation.SpringAssessment.repository.entity.Item;

import java.util.List;

public interface ItemService {

    List<Item> all();  //all is a method

    // this method is used for both add items and edit items
    Item save (Item item);
}
