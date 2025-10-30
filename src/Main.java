// Main.java
import animals.Lion;
import animals.Elephant;
import animals.Snake;
import staff.Veterinarian;
import staff.Zookeeper;
import infrastructure.Enclosure;
import interfaces.Animal;
import interfaces.Staff;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Улучшенная Система Управления Зоопарком ===\n");

        // Создание животных с улучшенными характеристиками
        Lion lion = new Lion("Симба", 5, 190.5, "золотистый");
        Elephant elephant = new Elephant("Дамбо", 10, 4500.0, 1.8);
        Snake snake = new Snake("Каа", 3, 15.5, 25.0, 4.2, false);

        // Установка специальных свойств
        lion.setAlpha(true);
        elephant.setTrunkLength(2.1);

        // Создание вольеров с площадью
        Enclosure bigCatsEnclosure = new Enclosure("Большие кошки", 200.0);
        Enclosure elephantsEnclosure = new Enclosure("Слоны", 500.0);
        Enclosure reptilesEnclosure = new Enclosure("Рептилии", 50.0);

        // Добавление животных в вольеры
        bigCatsEnclosure.addAnimal(lion);
        elephantsEnclosure.addAnimal(elephant);
        reptilesEnclosure.addAnimal(snake);

        // Создание персонала
        Veterinarian vet = new Veterinarian("Доктор Айболит", "VET-12345", 75000, 8);
        Zookeeper keeper1 = new Zookeeper("Иван Петров", "Хищники", 45000, 1);
        Zookeeper keeper2 = new Zookeeper("Мария Сидорова", "Травоядные", 45000, 2);

        System.out.println("\n=== Персонал зоопарка ===");
        Staff[] staffMembers = {vet, keeper1, keeper2};
        for (Staff staff : staffMembers) {
            System.out.println(staff.getPosition() + ": " + staff.getName());
        }

        // Демонстрация работы ветеринара
        System.out.println("\n=== Работа ветеринара ===");
        vet.work();
        vet.examineAnimal(lion);
        vet.conductHealthCheck(reptilesEnclosure);

        // Демонстрация работы смотрителей
        System.out.println("\n=== Работа смотрителей ===");
        keeper1.work();
        keeper1.feedAnimalsInEnclosure(bigCatsEnclosure);
        keeper1.conductEnclosureTour(bigCatsEnclosure);

        keeper2.work();
        keeper2.feedAnimalsInEnclosure(elephantsEnclosure);
        keeper2.cleanEnclosure(elephantsEnclosure);

        // Демонстрация полиморфизма с животными
        System.out.println("\n=== Демонстрация полиморфизма животных ===");
        Animal[] allAnimals = {lion, elephant, snake};

        for (Animal animal : allAnimals) {
            System.out.print(animal.getName() + " демонстрирует поведение: ");
            animal.move();
            animal.makeSound();
            System.out.println();
        }

        // Специальные способности животных
        System.out.println("\n=== Специальные способности животных ===");
        elephant.sprayWater();
        elephant.useTrunk();
        lion.hunt();
        snake.baskInSun();
        snake.shedSkin();

        // Состояние вольеров
        System.out.println("\n=== Состояние вольеров ===");
        bigCatsEnclosure.displayAnimals();
        elephantsEnclosure.displayAnimals();
        reptilesEnclosure.displayAnimals();

        // Техническое обслуживание
        System.out.println("\n=== Техническое обслуживание ===");
        bigCatsEnclosure.performMaintenance();
        reptilesEnclosure.performMaintenance();

        // Демонстрация инкапсуляции и валидации
        System.out.println("\n=== Демонстрация инкапсуляции ===");
        System.out.println("Возраст льва: " + lion.getAge() + " лет");
        System.out.println("Вес слона: " + elephant.getWeight() + " кг");
        System.out.println("Длина змеи: " + snake.getLength() + " м");
        System.out.println("Лицензия ветеринара: " + vet.getLicenseNumber());

        // Тестирование валидации
        System.out.println("\n=== Тестирование валидации данных ===");
        try {
            lion.setAge(-5);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка валидации: " + e.getMessage());
        }

        try {
            new Enclosure("Тестовый", -100);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка валидации: " + e.getMessage());
        }

        System.out.println("\n=== Рабочий день завершен ===");
    }
}