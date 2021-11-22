package ru.geekbrains.java3.hw;

public abstract class Fruit {
    private final float weight;

    public Fruit(float weight) {
        this.weight = weight;
    }

    float getWeight() {
        return weight;
    }
}
