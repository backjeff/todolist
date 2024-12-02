package com.backjeff.todolist.controller.todolist;

import com.backjeff.todolist.controller.todolist.models.TodoListSaveParameters;
import com.backjeff.todolist.domain.model.TodoList;
import com.backjeff.todolist.service.todolist.TodoListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/list")
public class TodoListController {

    private final TodoListService toDoListService;

    @Autowired
    public TodoListController(TodoListService toDoListService) {
        this.toDoListService = toDoListService;
    }

    @PostMapping
    public ResponseEntity<TodoList> createToDoList(@RequestBody TodoListSaveParameters params) {
        TodoList toDoList = toDoListService.create(params.name());
        return new ResponseEntity<>(toDoList, HttpStatus.CREATED);
    }

    @GetMapping("/{toDoListId}")
    public ResponseEntity<TodoList> getToDoListById(@PathVariable String toDoListId) {
        Optional<TodoList> toDoList = toDoListService.getById(toDoListId);
        return toDoList.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @GetMapping
    public ResponseEntity<List<TodoList>> getAllToDoLists() {
        List<TodoList> toDoLists = toDoListService.getAll();
        return new ResponseEntity<>(toDoLists, HttpStatus.OK);
    }

    @DeleteMapping("/{todoListId}")
    public ResponseEntity<Void> deleteToDoList(@PathVariable String todoListId) {
        try {
            toDoListService.delete(todoListId);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
