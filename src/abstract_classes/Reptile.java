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
    }

    @Override
    public void move() {
        System.out.println(getName() + " ползет");
    }
}