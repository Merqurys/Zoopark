// Enclosure.java
package infrastructure;

import interfaces.Animal;
import java.util.ArrayList;
import java.util.List;

public class Enclosure {
    private List<Animal> animals;
    private String name;
    private double area;
    private boolean needsCleaning;

    public Enclosure(String name, double area) {
        this.name = name;
        setArea(area);
        this.animals = new ArrayList<>();
        this.needsCleaning = true;
    }

    public String getName() {
        return name;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        if (area <= 0) {
            throw new IllegalArgumentException("Площадь должна быть положительной");
        }
        this.area = area;
    }

    public boolean needsCleaning() {
        return needsCleaning;
    }

    public void setNeedsCleaning(boolean needsCleaning) {
        this.needsCleaning = needsCleaning;
    }

    public void addAnimal(Animal animal) {
        if (animal == null) {
            throw new IllegalArgumentException("Животное не может быть null");
        }
        animals.add(animal);
        System.out.println(animal.getName() + " добавлен в вольер " + name);
    }

    public void removeAnimal(Animal animal) {
        if (animals.remove(animal)) {
            System.out.println(animal.getName() + " удален из вольера " + name);
        } else {
            System.out.println("Животное не найдено в вольере " + name);
        }
    }

    public List<Animal> getAnimals() {
        return new ArrayList<>(animals);
    }

    public int getAnimalCount() {
        return animals.size();
    }

    public void displayAnimals() {
        System.out.println("\n=== Вольер " + name + " (" + area + " м²) ===");
        if (animals.isEmpty()) {
            System.out.println("Вольер пуст");
        } else {
            System.out.println("Количество животных: " + getAnimalCount());
            for (Animal animal : animals) {
                String healthStatus = animal.isHealthy() ? "здоров" : "требует внимания";
                System.out.println("- " + animal.getName() + " (" + healthStatus + ")");
            }
        }
        System.out.println("Статус уборки: " + (needsCleaning ? "требуется уборка" : "чистый"));
    }

    public void performMaintenance() {
        System.out.println("Проведение технического обслуживания вольера " + name);
        needsCleaning = false;
        System.out.println("Вольер " + name + " готов к приему посетителей!");
    }
}