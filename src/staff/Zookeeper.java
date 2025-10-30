// Zookeeper.java
package staff;

import interfaces.Animal;
import interfaces.Staff;
import infrastructure.Enclosure;

public class Zookeeper implements Staff {
    private String name;
    private String specialization;
    private double salary;
    private int shift;

    public Zookeeper(String name, String specialization, double salary, int shift) {
        setName(name);
        setSpecialization(specialization);
        setSalary(salary);
        setShift(shift);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Имя не может быть пустым");
        }
        this.name = name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        if (specialization == null || specialization.trim().isEmpty()) {
            throw new IllegalArgumentException("Специализация не может быть пустой");
        }
        this.specialization = specialization;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        if (salary < 0) {
            throw new IllegalArgumentException("Зарплата не может быть отрицательной");
        }
        this.salary = salary;
    }

    public int getShift() {
        return shift;
    }

    public void setShift(int shift) {
        if (shift < 1 || shift > 3) {
            throw new IllegalArgumentException("Смена должна быть от 1 до 3");
        }
        this.shift = shift;
    }

    @Override
    public String getPosition() {
        return "Смотритель";
    }

    @Override
    public void work() {
        System.out.println(getPosition() + " " + name + " работает на " + shift + " смене");
    }

    @Override
    public void cleanEnclosure(Enclosure enclosure) {
        System.out.println(getPosition() + " " + name + " чистит вольер " + enclosure.getName());
        System.out.println("Вольер " + enclosure.getName() + " теперь чист!");
    }

    public void feedAnimalsInEnclosure(Enclosure enclosure) {
        System.out.println("\n=== Кормление животных в вольере " + enclosure.getName() + " ===");
        System.out.println(getPosition() + " " + name + " начинает кормление:");

        for (Animal animal : enclosure.getAnimals()) {
            System.out.print("Кормит " + animal.getName() + ": ");
            // Полиморфный вызов метода feed()
            animal.feed();
        }

        System.out.println("Кормление в вольере " + enclosure.getName() + " завершено!");
    }

    public void conductEnclosureTour(Enclosure enclosure) {
        System.out.println("\n=== Экскурсия по вольеру " + enclosure.getName() + " ===");
        System.out.println(getPosition() + " " + name + " проводит экскурсию:");

        for (Animal animal : enclosure.getAnimals()) {
            System.out.println("--- " + animal.getName() + " ---");
            animal.move();
            animal.makeSound();
        }

        System.out.println("Экскурсия завершена!");
    }
}