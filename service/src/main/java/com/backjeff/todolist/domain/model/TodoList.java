package com.backjeff.todolist.domain.model;

import java.util.List;

public record TodoList(String id, String name, List<TodoItem> todoItems) {}
