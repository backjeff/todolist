package com.backjeff.todolist.repository.todoitem;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoItemRepository extends JpaRepository<TodoItemEntity, String> {
    // Custom query method to find items by their associated list ID
    List<TodoItemEntity> findByListId(String listId);
}
