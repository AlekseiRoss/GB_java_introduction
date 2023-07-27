import java.util.Scanner;

public class FloatInput {
    public static void main(String[] args) {
        float number = readFloatFromUser();
        System.out.println("Введенное число: " + number);
    }

    public static float readFloatFromUser() {
        Scanner scanner = new Scanner(System.in);
        float result;

        while (true) {
            try {
                System.out.print("Введите дробное число: ");
                result = Float.parseFloat(scanner.next());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Некорректный ввод. Пожалуйста, введите дробное число.");
            }
        }

        return result;
    }
}
