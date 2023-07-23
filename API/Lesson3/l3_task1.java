package Lesson3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/* Пусть дан произвольный список целых чисел.
1) Нужно удалить из него чётные числа
2) Найти минимальное значение
3) Найти максимальное значение
4) Найти среднее ариф. значение
*/

public class l3_task1 {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        // Добавьте произвольные целые числа в список
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        
        // show array
        System.out.println("Изначальный список: " + numbers);

        // 1
        System.out.println("Удалить чётные числа:" + removeEvenNumbers(numbers));

        // 2
        System.out.println("Минимальное значение: " + Collections.min(numbers));

        // 3
        System.out.println("Максимальное значение: " + Collections.max(numbers));

        // 4
        System.out.println("Среднее значение: " + calculateAverage(numbers));
    }
    
    public static ArrayList<Integer> removeEvenNumbers(ArrayList<Integer> numbers) {
        ArrayList<Integer> numb_array = numbers;
        Iterator<Integer> iterator = numb_array.iterator();
        while (iterator.hasNext()) {
            int number = iterator.next();
            if (number % 2 == 0) {
                iterator.remove();
            }
        }
        return numb_array;
    }

    public static double calculateAverage(ArrayList<Integer> numbers) {
        double sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return sum / numbers.size();
    }
}
