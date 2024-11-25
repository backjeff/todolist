package com.backjeff.todolist.controller;

import com.backjeff.todolist.model.Item;
import com.backjeff.todolist.model.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ListController {

    @GetMapping("list/{id}")
    public List getList(@PathVariable String id) {
        Item[] items = { new Item("1i2391", "clean room", false) };
        return new List(id, items);
    }
}
