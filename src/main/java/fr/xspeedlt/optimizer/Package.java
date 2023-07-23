package fr.xspeedlt.optimizer;

import java.util.ArrayList;
import java.util.List;

public class Package {
    List<Item> items = new ArrayList<>();

    public int getCapacity() {
        return capacity;
    }

    private int capacity;

    public Package(int capacity) {
        this.capacity = capacity;
    }

    public boolean add(Item item) {
        if (item.size().getValue() > capacity) {
            return false;
        }

        items.add(item);
        capacity = capacity - item.size().getValue();
        return true;
    }

    @Override
    public String toString() {
        return "Package{" +
                "items=" + items +
                ", capacity=" + capacity +
                '}';
    }
}

