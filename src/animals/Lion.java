// Lion.java
package animals;

import abstract_classes.Vertebrate;

public class Lion extends Vertebrate {
    private String maneColor;
    private boolean isAlpha;

    public Lion(String name, int age, double weight, String maneColor) {
        super(name, age, weight);
        setManeColor(maneColor);
        this.isAlpha = false;
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

    public boolean isAlpha() {
        return isAlpha;
    }

    public void setAlpha(boolean alpha) {
        isAlpha = alpha;
        if (alpha) {
            System.out.println(getName() + " теперь вожак прайда!");
        }
    }

    @Override
    public void makeSound() {
        if (isAlpha) {
            System.out.println(getName() + " громко рычит: РРРРРР! (Вожак прайда)");
        } else {
            System.out.println(getName() + " рычит: Ррррр!");
        }
    }

    @Override
    public void move() {
        if (isAlpha) {
            System.out.println(getName() + " гордо шествует по территории");
        } else {
            System.out.println(getName() + " грациозно перемещается");
        }
    }

    public void hunt() {
        System.out.println(getName() + " отправляется на охоту");
        setHungry(true);
    }
}