package com.example.demo.Item;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class ItemController {

    @Autowired
    ItemService itemService;

    @GetMapping("/api")
    /* https://spring.io/guides/gs/rest-service-cors/ */
//    @CrossOrigin(origins = "http://localhost:3000")
    public Iterable<Item> getAllItems() {
        Iterable<Item> items = itemService.getAllItems();
        return items;
    };

    // https://www.baeldung.com/spring-request-param
    @GetMapping("/api/getOne")
//    @CrossOrigin(origins = "http://localhost:3000")
    public Optional<Item> getOneItem(@RequestParam Long id) {
        return itemService.getOneItem(id);
    };

    @PostMapping("/api")
//    @CrossOrigin(origins = "http://localhost:3000")
    public Item addOneItem(@RequestBody Item item) {
        return itemService.addOneItem(item);
    };

    @PutMapping("/api")
//    @CrossOrigin(origins = "http://localhost:3000")
    public void updateOneItem(@RequestBody Item item) {
        itemService.updateOneItem(item);
    }

    @DeleteMapping("/api")
//    @CrossOrigin(origins = "http://localhost:3000")
    public String deleteOneItem(@RequestParam Long id) {
        return itemService.deleteOneItem(id);
    };

}
