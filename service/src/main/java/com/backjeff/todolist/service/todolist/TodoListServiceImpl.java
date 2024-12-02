package com.backjeff.todolist.service.todolist;

import com.backjeff.todolist.domain.model.TodoList;
import com.backjeff.todolist.repository.todolist.TodoListEntity;
import com.backjeff.todolist.repository.todolist.TodoListRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TodoListServiceImpl implements TodoListService {
    private final TodoListRepository todoListRepository;

    public TodoListServiceImpl(TodoListRepository todoListRepository) {
        this.todoListRepository = todoListRepository;
    }

    @Override
    public TodoList create(String name) {
        String id = String.valueOf(new Date().toInstant().toEpochMilli());
        TodoListEntity todoList = new TodoListEntity(id, name, List.of());
        return todoListRepository.save(todoList).toDomain();
    }

    @Override
    public Optional<TodoList> getById(String id) {
        return todoListRepository.findById(id)
                .map(TodoListEntity::toDomain);
    }

    @Override
    public List<TodoList> getAll() {
        return todoListRepository.findAll()
                .stream()
                .map(TodoListEntity::toDomain)
                .toList();
    }

    @Override
    public void delete(String listId) {
        todoListRepository.deleteById(listId);
    }
}