/*Вычислить n-ое треугольного число (сумма чисел от 1 до n), n! (произведение чисел от 1 до n) */

public class task_1{
    public static void main(String[] args) {
        int n = 5;
        System.out.println("Число n: " + n);

        // Вычисление n-го треугольного числа
        int triangleNumber = calculateTriangleNumber(n);
        System.out.println("n-ое треугольное число: " + triangleNumber);

        // Вычисление факториала числа n
        int factorial = calculateFactorial(n);
        System.out.println("n! = " + factorial);
    }

    // Функция для вычисления n-го треугольного числа
    public static int calculateTriangleNumber(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        return sum;
    }

    // Функция для вычисления факториала числа n
    public static int calculateFactorial(int n) {
        int factorial = 1;
        for (int i = 1; i <= n; i++) {
            factorial *= i;
        }
        return factorial;
    }
}