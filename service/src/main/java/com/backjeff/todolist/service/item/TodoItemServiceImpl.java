package com.backjeff.todolist.service.item;

import com.backjeff.todolist.domain.model.TodoItem;
import com.backjeff.todolist.repository.todoitem.TodoItemEntity;
import com.backjeff.todolist.repository.todoitem.TodoItemRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TodoItemServiceImpl implements TodoItemService {
    private final TodoItemRepository todoItemRepository;

    public TodoItemServiceImpl(TodoItemRepository todoItemRepository) {
        this.todoItemRepository = todoItemRepository;
    }

    @Override
    public TodoItem create(String listId, String name) {
        String id = String.valueOf(new Date().toInstant().toEpochMilli());
        TodoItemEntity todoItem = new TodoItemEntity(id, name, false);
        return todoItemRepository.save(todoItem).toDomain();
    }

    @Override
    public Optional<TodoItem> getById(String id) {
        return todoItemRepository.findById(id)
                .map(TodoItemEntity::toDomain);
    }

    @Override
    public List<TodoItem> getByListId(String listId) {
        return todoItemRepository.findByListId(listId)
                .stream()
                .map(TodoItemEntity::toDomain)
                .toList();
    }

    @Override
    public List<TodoItem> getAll() {
        return todoItemRepository.findAll()
                .stream()
                .map(TodoItemEntity::toDomain)
                .toList();
    }

    @Override
    public void delete(String id) {
        todoItemRepository.deleteById(id);
    }
}