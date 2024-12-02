package com.backjeff.todolist.service.todolist;

import com.backjeff.todolist.domain.model.TodoList;

import java.util.List;
import java.util.Optional;

public interface TodoListService {
    TodoList create(String name);
    Optional<TodoList> getById(String id);
    List<TodoList> getAll();
    void delete(String listId);
}