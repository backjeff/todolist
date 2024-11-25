package com.backjeff.todolist.model;

import java.util.Objects;

public record Item(String id, String title, boolean checked) {
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Objects.equals(id, item.id) && checked == item.checked && Objects.equals(title, item.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, checked);
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", checked=" + checked +
                '}';
    }
}
