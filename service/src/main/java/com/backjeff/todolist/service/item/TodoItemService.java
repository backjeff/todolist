package com.backjeff.todolist.service.item;

import com.backjeff.todolist.domain.model.TodoItem;

import java.util.List;
import java.util.Optional;

public interface TodoItemService {
    TodoItem create(String listId, String name);
    Optional<TodoItem> getById(String id);
    List<TodoItem> getByListId(String listId);
    List<TodoItem> getAll();
    void delete(String itemId);
}