package com.backjeff.todolist.repository.todoitem;

import com.backjeff.todolist.domain.model.TodoItem;
import com.backjeff.todolist.repository.todolist.TodoListEntity;
import jakarta.persistence.*;

@Entity
public class TodoItemEntity {

        @Id
        private String id;
        private String name;
        private boolean checked;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "list_id")
        private TodoListEntity list;

        // Default constructor
        public TodoItemEntity() {
        }

        // Parameterized constructor with list
        public TodoItemEntity(String id, String name, boolean checked) {
                this.id = id;
                this.name = name;
                this.checked = checked;
        }

        // Getters
        public String getId() {
                return id;
        }

        public String getName() {
                return name;
        }

        public boolean isChecked() {
                return checked;
        }

        // Setters
        public void setId(String id) {
                this.id = id;
        }

        public void setName(String name) {
                this.name = name;
        }

        public void setChecked(boolean checked) {
                this.checked = checked;
        }

        // Method to convert to domain model
        public TodoItem toDomain() {
                return new TodoItem(
                        this.id,
                        this.name,
                        this.checked
                );
        }
}