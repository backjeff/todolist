package com.backjeff.todolist.controller.todoitem;

import com.backjeff.todolist.controller.todoitem.models.TodoItemSaveParameters;
import com.backjeff.todolist.domain.model.TodoItem;
import com.backjeff.todolist.service.item.TodoItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/item")
public class TodoItemController {

    private final TodoItemService toDoItemService;

    @Autowired
    public TodoItemController(TodoItemService toDoItemService) {
        this.toDoItemService = toDoItemService;
    }

    @PostMapping
    public ResponseEntity<TodoItem> createToDoItem(@RequestBody TodoItemSaveParameters params) {
        TodoItem toDoItem = toDoItemService.create(params.listId(), params.name());
        return new ResponseEntity<>(toDoItem, HttpStatus.CREATED);
    }

    @GetMapping("/{toDoItemId}")
    public ResponseEntity<TodoItem> getToDoItemById(@PathVariable String toDoItemId) {
        Optional<TodoItem> toDoItem = toDoItemService.getById(toDoItemId);
        return toDoItem.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @GetMapping("/list/{listId}")
    public List<TodoItem> getItemsByListId(@PathVariable String listId) {
        return toDoItemService.getByListId(listId);
    }

    @GetMapping
    public ResponseEntity<List<TodoItem>> getAllToDoItems() {
        List<TodoItem> toDoItems = toDoItemService.getAll();
        return new ResponseEntity<>(toDoItems, HttpStatus.OK);
    }

    @DeleteMapping("/{todoItemId}")
    public ResponseEntity<Void> deleteToDoItem(@PathVariable String todoItemId) {
        try {
            toDoItemService.delete(todoItemId);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}