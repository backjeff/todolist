package com.backjeff.todolist.model;

import java.util.Arrays;
import java.util.Objects;

public record List(String id, Item[] items) {
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        List list = (List) o;
        return Objects.equals(id, list.id) && Arrays.equals(items, list.items);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id);
        result = 31 * result + Arrays.hashCode(items);
        return result;
    }

    @Override
    public String toString() {
        return "List{" +
                "id=" + id +
                ", items=" + Arrays.toString(items) +
                '}';
    }
}
