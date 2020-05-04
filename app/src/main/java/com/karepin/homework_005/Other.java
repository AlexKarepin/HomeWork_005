package com.karepin.homework_005;

public class Other {
    Double weight;
    int steps;

    public Other(Double weight, int steps) {
        this.weight = weight;
        this.steps = steps;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public int getSteps() {
        return steps;
    }

    public void setSteps(int steps) {
        this.steps = steps;
    }

    @Override
    public String toString() {
        return "Вес: " + weight + ", кол.шагов: " + steps;
    }
}
