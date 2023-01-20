package com.example.FinalPil.model;

public enum Capacity {

    EMPTY(0),
    HALFFULL(1),
    FULL(2),
    EXCEEDSCAPACITY(3);

    private Integer capacity;

    Capacity(int i) {
        this.capacity = i;
    }

    public boolean isFasterThan(Capacity other) {
        return this.capacity > other.capacity;
    }

    public boolean areEmpty(Capacity other) {
        return this.capacity.equals(0) && other.capacity.equals(0);
    }
}
