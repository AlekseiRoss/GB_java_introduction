import java.util.List;
import java.util.Scanner;

public class InputValidator {
    private Scanner scanner;

    public InputValidator(Scanner scanner) {
        this.scanner = scanner;
    }

    public <T> T getValidInput(String message, Class<T> type) {
        T value = null;
        while (value == null) {
            System.out.print(message);
            try {
                if (type == Integer.class) {
                    value = type.cast(scanner.nextInt());
                } else if (type == Double.class) {
                    value = type.cast(scanner.nextDouble());
                } else if (type == String.class) {
                    scanner.nextLine(); // Добавляем эту строку для "проглатывания" символа новой строки
                    value = type.cast(scanner.nextLine());
                } else {
                    throw new IllegalArgumentException("Unsupported data type.");
                }
            } catch (Exception e) {
                System.out.println("Пожалуйста, введите корректное значение.");
                scanner.nextLine(); // Очищаем буфер после некорректного ввода
            }
        }
        return value;
    }

    public int idValidator(int id, List<Toy> toys) {
        InputValidator inputValidator = new InputValidator(new Scanner(System.in));
        boolean invalid = true;

        while (invalid) {
            if (id < 0) {
                System.out.println("ID не может быть меньше 0!");
                id = inputValidator.getValidInput("Введите ID игрушки (целое число): ", Integer.class);
                continue;
            }

            boolean found = false;
            for (Toy toy : toys) {
                if (toy.getId() == id) {
                    System.out.println("Игрушка с таким ID уже существует. Введите другой ID!");
                    id = inputValidator.getValidInput("Введите ID игрушки (целое число): ", Integer.class);
                    found = true;
                    break; // Если найдена совпадающая игрушка, выходим из цикла
                }
            }

            if (!found) {
                invalid = false; // Если не найдено совпадающих игрушек, завершаем цикл
            }
        }
        return id;
    }

    public double dropFrequencyValidator (double dropFrequency){
        InputValidator inputValidator = new InputValidator(new Scanner(System.in));
        boolean invalid = true;
        while (invalid){
            if (dropFrequency<=0 || dropFrequency>=1) {
                System.out.println("Неверный ввод вероятности выпадения игрушки!");
                dropFrequency = inputValidator.getValidInput("Введите вероятность выпадания игрушки (от 0 до 1): ", Double.class);
            }
            else {invalid = false;}
        }
        return dropFrequency;
    }

    public int quantityValidator (int quantity){
        InputValidator inputValidator = new InputValidator(new Scanner(System.in));
        boolean invalid = true;
        while (invalid){
            if (quantity<0) {
                System.out.println("Неверный ввод количества игрушек!");
                quantity = inputValidator.getValidInput("Введите количество игрушек (целое число): ", Integer.class);
            }
            else {invalid = false;}
        }
        return quantity;
    }
}
