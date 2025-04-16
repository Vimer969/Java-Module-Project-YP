import java.util.Scanner;

// Класс Автомобиль
class Car {
    String name;
    int speed;

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
}

// Класс Гонка
class Race {
    Car winner;

    public void determineWinner(Car car1, Car car2, Car car3) {
        winner = car1;
        if (car2.getDistance() > winner.getDistance()) {
            winner = car2;
        }
        if (car3.getDistance() > winner.getDistance()) {
            winner = car3;
        }
    }

    public Car getWinner() {
        return winner;
    }
}

// Класс Main
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Car[] cars = new Car[3];

        for (int i = 0; i < 3; i++) {
            String name;
            int speed;  // убрали начальную инициализацию переменной

            System.out.println("Введите название машины №" + (i + 1) + ":");
            while (true) {
                name = scanner.nextLine().trim();
                if (!name.isEmpty()) break;
                System.out.println("Название не может быть пустым. Введите ещё раз:");
            }

            System.out.println("Введите скорость машины №" + (i + 1) + ":");
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

            cars[i] = new Car(name, speed);
        }

        Race race = new Race();
        race.determineWinner(cars[0], cars[1], cars[2]);
        System.out.println("Самая быстрая машина: " + race.getWinner().getName());
    }

    // Метод для проверки, является ли строка числом
    private static boolean isValidSpeed(String input) {
        // Проверка, что строка состоит только из цифр
        for (int i = 0; i < input.length(); i++) {
            if (!Character.isDigit(input.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
