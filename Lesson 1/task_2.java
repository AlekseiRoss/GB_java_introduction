/*Вывести все простые числа от 1 до 1000 */

public class task_2 {
    public static void main(String[] args) {
        System.out.println("Простые числа от 1 до 1000:");
        printPrimeNumbers(1, 1000);
    }

    // Функция для проверки, является ли число простым
    public static boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    // Функция для вывода простых чисел в заданном диапазоне
    public static void printPrimeNumbers(int start, int end) {
        for (int i = start; i <= end; i++) {
            if (isPrime(i)) {
                System.out.println(i);
            }
        }
    }
}
