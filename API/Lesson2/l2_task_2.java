/*Реализуйте алгоритм сортировки пузырьком числового массива, результат после каждой итерации запишите в лог-файл.
1 3 4 2
1 3 2 4
1 2 3 4 */

import java.io.FileWriter;
import java.io.IOException;

public class l2_task_2 {
    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 2};
        sortAndLog(arr, "./Lesson2/log.txt");
    }

    public static void sortAndLog(int[] arr, String logFileName) {
        try (FileWriter writer = new FileWriter(logFileName)) {
            boolean swapped;
            int n = arr.length;

            for (int i = 0; i < n - 1; i++) {
                swapped = false;

                for (int j = 0; j < n - i - 1; j++) {
                    if (arr[j] > arr[j + 1]) {
                        // Обмен элементов
                        int temp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = temp;
                        swapped = true;
                    }
                }

                // Запись текущего состояния массива в лог-файл
                writer.write(arrayToString(arr) + "\n");

                // Если во время прохода по массиву не было обменов, то массив уже отсортирован
                if (!swapped) {
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String arrayToString(int[] arr) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);

            if (i < arr.length - 1) {
                sb.append(" ");
            }
        }

        return sb.toString();
    }
}
