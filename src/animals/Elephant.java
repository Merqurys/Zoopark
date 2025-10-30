package animals;

import abstract_classes.Vertebrate;

public class Elephant extends Vertebrate {
    private double tuskLength;

    public Elephant(String name, int age, double weight, double tuskLength) {
        super(name, age, weight);
        setTuskLength(tuskLength);
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

    @Override
    public void makeSound() {
        System.out.println(getName() + " трубит: УУУУУУ!");
    }

    @Override
    public void move() {
        System.out.println(getName() + " медленно идет, покачивая хоботом");
    }

    public void sprayWater() {
        System.out.println(getName() + " брызгается водой из хобота");
    }
}