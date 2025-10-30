// Elephant.java
package animals;

import abstract_classes.Vertebrate;

public class Elephant extends Vertebrate {
    private double tuskLength;
    private double trunkLength;

    public Elephant(String name, int age, double weight, double tuskLength) {
        super(name, age, weight);
        setTuskLength(tuskLength);
        this.trunkLength = 1.5;
    }

    public double getTuskLength() {
        return tuskLength;
    }

    public void setTuskLength(double tuskLength) {
        if (tuskLength < 0) {
            throw new IllegalArgumentException("Длина бивней не может быть отрицательной");
        }
        this.tuskLength = tuskLength;
    }

    public double getTrunkLength() {
        return trunkLength;
    }

    public void setTrunkLength(double trunkLength) {
        if (trunkLength <= 0) {
            throw new IllegalArgumentException("Длина хобота должна быть положительной");
        }
        this.trunkLength = trunkLength;
    }

    @Override
    public void makeSound() {
        System.out.println(getName() + " трубно приветствует: УУУУУУ!");
    }

    @Override
    public void move() {
        System.out.println(getName() + " неторопливо шагает, покачивая хоботом");
    }

    public void sprayWater() {
        System.out.println(getName() + " брызгается водой из хобота");
    }

    public void useTrunk() {
        System.out.println(getName() + " ловко использует хобот для различных задач");
    }
}