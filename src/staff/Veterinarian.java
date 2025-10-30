// Veterinarian.java
package staff;

import interfaces.Animal;
import interfaces.Staff;
import infrastructure.Enclosure;

public class Veterinarian implements Staff {
    private String name;
    private String licenseNumber;
    private double salary;
    private int yearsOfExperience;

    public Veterinarian(String name, String licenseNumber, double salary, int yearsOfExperience) {
        setName(name);
        setLicenseNumber(licenseNumber);
        setSalary(salary);
        setYearsOfExperience(yearsOfExperience);
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

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        if (licenseNumber == null || licenseNumber.trim().isEmpty()) {
            throw new IllegalArgumentException("Номер лицензии не может быть пустым");
        }
        this.licenseNumber = licenseNumber;
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

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(int yearsOfExperience) {
        if (yearsOfExperience < 0) {
            throw new IllegalArgumentException("Опыт работы не может быть отрицательным");
        }
        this.yearsOfExperience = yearsOfExperience;
    }

    @Override
    public String getPosition() {
        return "Ветеринар";
    }

    @Override
    public void work() {
        System.out.println(getPosition() + " " + name + " проводит плановый осмотр животных");
    }

    @Override
    public void cleanEnclosure(Enclosure enclosure) {
        System.out.println(getPosition() + " " + name + " дезинфицирует вольер " + enclosure.getName());
    }

    public void examineAnimal(Animal animal) {
        System.out.println("\n=== Осмотр животного ===");
        System.out.println(getPosition() + " " + name + " осматривает " + animal.getName());

        if (animal.isHealthy()) {
            System.out.println("✓ " + animal.getName() + " здоров");
        } else {
            System.out.println("✗ " + animal.getName() + " требует лечения");
            animal.setHealthy(true);
            System.out.println("✓ Проведено лечение: " + animal.getName() + " теперь здоров");
        }

        // Демонстрация полиморфизма
        animal.makeSound();
        System.out.println("Осмотр завершен для: " + animal.getName());
    }

    public void conductHealthCheck(Enclosure enclosure) {
        System.out.println("\n=== Медосмотр в вольере " + enclosure.getName() + " ===");
        for (Animal animal : enclosure.getAnimals()) {
            examineAnimal(animal);
        }
    }
}