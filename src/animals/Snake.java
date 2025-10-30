// Snake.java
package animals;

import abstract_classes.Reptile;

public class Snake extends Reptile {
    private double length;
    private boolean isVenomous;

    public Snake(String name, int age, double weight, double bodyTemperature, double length, boolean isVenomous) {
        super(name, age, weight, bodyTemperature);
        setLength(length);
        this.isVenomous = isVenomous;
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

    public boolean isVenomous() {
        return isVenomous;
    }

    public void setVenomous(boolean venomous) {
        isVenomous = venomous;
    }

    @Override
    public void makeSound() {
        System.out.println(getName() + " предупреждающе шипит: Шшшшшш!");
    }

    @Override
    public void feed() {
        super.feed();
        System.out.println(getName() + " заглатывает добычу целиком");
    }

    @Override
    public void move() {
        System.out.println(getName() + " бесшумно скользит");
    }

    public void shedSkin() {
        System.out.println(getName() + " сбрасывает кожу");
        setHealthy(true);
    }
}