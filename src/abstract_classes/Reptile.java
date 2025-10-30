// Reptile.java
package abstract_classes;

public abstract class Reptile extends Vertebrate {
    private double bodyTemperature;

    public Reptile(String name, int age, double weight, double bodyTemperature) {
        super(name, age, weight);
        setBodyTemperature(bodyTemperature);
    }

    public double getBodyTemperature() {
        return bodyTemperature;
    }

    public void setBodyTemperature(double bodyTemperature) {
        this.bodyTemperature = bodyTemperature;
    }

    public void baskInSun() {
        System.out.println(getName() + " греется на солнце");
        this.bodyTemperature += 2;
        System.out.println("Температура тела повысилась до: " + bodyTemperature + "°C");
    }

    public void coolDown() {
        System.out.println(getName() + " охлаждается в тени");
        this.bodyTemperature -= 1;
        System.out.println("Температура тела понизилась до: " + bodyTemperature + "°C");
    }

    @Override
    public void move() {
        System.out.println(getName() + " ползет");
    }
}