package com.example.demo.Item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ItemService {

    @Autowired
    ItemRepository itemRepository;

    public Iterable<Item> getAllItems() {
        return itemRepository.findAll();
    }

    public Optional<Item> getOneItem(Long id) {
        return itemRepository.findById(id);
    }

    public Item addOneItem(Item item) {
        itemRepository.save(item);
        return item;
    }

    public void updateOneItem(Item item) {
        try {
            itemRepository.findById(item.getId()).map(itemFromDB -> {
                itemFromDB = item;
                itemRepository.save(itemFromDB);
                System.out.println("Success");
                return null;
            });
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    };

    public String deleteOneItem(Long id) {
        itemRepository.deleteById(id);
        return "Success";
    }
}
