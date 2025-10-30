package animals;

import abstract_classes.Vertebrate;

public class Lion extends Vertebrate {
    private String maneColor;

    public Lion(String name, int age, double weight, String maneColor) {
        super(name, age, weight);
        setManeColor(maneColor);
    }

    public String getManeColor() {
        return maneColor;
    }

    public void setManeColor(String maneColor) {
        if (maneColor == null || maneColor.trim().isEmpty()) {
            throw new IllegalArgumentException("Цвет гривы не может быть пустым");
        }
        this.maneColor = maneColor;
    }

    @Override
    public void makeSound() {
        System.out.println(getName() + " рычит: РРРРРР!");
    }

    @Override
    public void move() {
        System.out.println(getName() + " гордо шагает по вольеру");
    }
}