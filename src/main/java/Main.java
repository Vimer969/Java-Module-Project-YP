import java.util.Scanner;

// Класс Автомобиль
class Car {
    private String name;
    private int speed;

    public Car(String name, int speed) {
        this.name = name;
        this.speed = speed;
    }

    public int getDistance() {
        return speed * 24;
    }

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }
}

// Класс Гонка
class Race {
    private Car winner;

    public void determineWinner(Car[] cars) {
        winner = cars[0];
        for (int i = 1; i < cars.length; i++) {
            if (cars[i].getDistance() > winner.getDistance()) {
                winner = cars[i];
            }
        }
    }

    public Car getWinner() {
        return winner;
    }
}

// Главный класс
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfCars = 3; // легко поменять
        Car[] cars = new Car[numberOfCars];

        for (int i = 0; i < numberOfCars; i++) {
            cars[i] = createCar(i + 1, scanner);
        }

        Race race = new Race();
        race.determineWinner(cars);

        Car winner = race.getWinner();
        System.out.println("\n🏁 Победитель гонки: " + winner.getName());
        System.out.println("Скорость: " + winner.getSpeed() + " км/ч");
        System.out.println("Проехал за 24 часа: " + winner.getDistance() + " км");
    }

    // Метод создания машины с вводом и валидацией
    private static Car createCar(int number, Scanner scanner) {
        String name;
        int speed;

        System.out.println("Введите название машины №" + number + ":");
        while (true) {
            name = scanner.nextLine().trim();
            if (!name.isEmpty()) break;
            System.out.println("Название не может быть пустым. Введите ещё раз:");
        }

        System.out.println("Введите скорость машины №" + number + ":");
        while (true) {
            String input = scanner.nextLine().trim();
            if (isValidSpeed(input)) {
                speed = Integer.parseInt(input);
                if (speed > 0 && speed <= 250) {
                    break;
                } else {
                    System.out.println("Неправильная скорость. Введите число от 1 до 250:");
                }
            } else {
                System.out.println("Неправильная скорость. Введите целое число:");
            }
        }

        return new Car(name, speed);
    }

    // Метод для проверки, является ли строка числом
    private static boolean isValidSpeed(String input) {
        if (input.isEmpty()) return false;
        for (int i = 0; i < input.length(); i++) {
            if (!Character.isDigit(input.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
