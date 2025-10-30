package infrastructure;

import interfaces.Animal;
import java.util.ArrayList;
import java.util.List;

public class Enclosure {
    // Инкапсуляция: приватное поле
    private List<Animal> animals;
    private String name;

    public Enclosure(String name) {
        this.name = name;
        this.animals = new ArrayList<>();
    }

    // Контролируемый доступ к списку животных
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
        // Возвращаем копию для защиты от внешних изменений
        return new ArrayList<>(animals);
    }

    public String getName() {
        return name;
    }

    public void displayAnimals() {
        System.out.println("\n=== Вольер " + name + " ===");
        if (animals.isEmpty()) {
            System.out.println("Вольер пуст");
        } else {
            for (Animal animal : animals) {
                System.out.println("- " + animal.getName());
            }
        }
    }
}