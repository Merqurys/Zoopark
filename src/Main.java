import animals.Lion;
import animals.Elephant;
import animals.Snake;
import abstract_classes.Vertebrate;
import infrastructure.Enclosure;
import interfaces.Animal;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Система Управления Зоопарком ===\n");


        Lion lion = new Lion("Симба", 5, 190.5, "золотистый");
        Elephant elephant = new Elephant("Дамбо", 10, 4500.0, 1.8);
        Snake snake = new Snake("Каа", 3, 15.5, 25.0, 4.2);


        // Vertebrate vertebrate = new Vertebrate("test", 1, 1.0); // Ошибка компиляции!


        Enclosure bigCatsEnclosure = new Enclosure("Большие кошки");
        Enclosure elephantsEnclosure = new Enclosure("Слоны");
        Enclosure reptilesEnclosure = new Enclosure("Рептилии");


        bigCatsEnclosure.addAnimal(lion);
        elephantsEnclosure.addAnimal(elephant);
        reptilesEnclosure.addAnimal(snake);


        System.out.println("\n=== Демонстрация полиморфизма ===");


        Animal[] allAnimals = {lion, elephant, snake};


        for (Animal animal : allAnimals) {
            System.out.print(animal.getName() + ": ");
            animal.makeSound();
        }


        System.out.println("\n=== Процесс кормления ===");
        for (Animal animal : allAnimals) {
            animal.feed();
        }


        System.out.println("\n=== Специальные способности ===");
        elephant.sprayWater(); // Слон
        snake.baskInSun();     // Рептилия


        System.out.println("\n=== Состояние вольеров ===");
        bigCatsEnclosure.displayAnimals();
        elephantsEnclosure.displayAnimals();
        reptilesEnclosure.displayAnimals();


        System.out.println("\n=== Демонстрация инкапсуляции ===");
        System.out.println("Возраст льва: " + lion.getAge() + " лет");
        System.out.println("Вес слона: " + elephant.getWeight() + " кг");
        System.out.println("Длина змеи: " + snake.getLength() + " м");

        // Попытка установить невалидные данные
        try {
            lion.setAge(-5);
        } catch (IllegalArgumentException e) {
            System.out.println("\nОшибка при установке возраста: " + e.getMessage());
        }
    }
}