package com.backjeff.todolist.repository.todolist;

import com.backjeff.todolist.domain.model.TodoList;
import com.backjeff.todolist.repository.todoitem.TodoItemEntity;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class TodoListEntity {

        @Id
        private String id;
        private String name;

        @OneToMany(mappedBy = "list")
        private List<TodoItemEntity> todoItems;

        // Default constructor
        public TodoListEntity() {
        }

        // Parameterized constructor
        public TodoListEntity(String id, String name, List<TodoItemEntity> todoItems) {
                this.id = id;
                this.name = name;
                this.todoItems = todoItems;
        }

        // Getters
        public String getId() {
                return id;
        }

        public String getName() {
                return name;
        }

        public List<TodoItemEntity> getTodoItems() {
                return todoItems;
        }

        // Setters
        public void setId(String id) {
                this.id = id;
        }

        public void setName(String name) {
                this.name = name;
        }

        public void setTodoItems(List<TodoItemEntity> todoItems) {
                this.todoItems = todoItems;
        }

        // Method to convert to domain model
        public TodoList toDomain() {
                return new TodoList(
                        this.id,
                        this.name,
                        this.todoItems.stream()
                                .map(TodoItemEntity::toDomain)
                                .toList()
                );
        }
}