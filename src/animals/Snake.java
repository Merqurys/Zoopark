package animals;

import abstract_classes.Reptile;

public class Snake extends Reptile {
    private double length;

    public Snake(String name, int age, double weight, double bodyTemperature, double length) {
        super(name, age, weight, bodyTemperature);
        setLength(length);
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        if (length <= 0) {
            throw new IllegalArgumentException("Длина должна быть положительной");
        }
        this.length = length;
    }

    @Override
    public void makeSound() {
        System.out.println(getName() + " шипит: Шшшшшш!");
    }

    @Override
    public void feed() {
        super.feed();
        System.out.println(getName() + " заглатывает добычу целиком");
    }
}