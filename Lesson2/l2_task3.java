/*Дана строка в файле(читать из файла)
[{"фамилия":"Иванов","оценка":"5","предмет":"Математика"},{"фамилия":"Петрова","оценка":"4","предмет":"Информатика"},{"фамилия":"Краснов","оценка":"5","предмет":"Физика"}]
Написать метод(ы), который распарсит строчку и, используя StringBuilder, создаст строки вида: Студент [фамилия] получил [оценка] по предмету [предмет].
Пример вывода:
Студент Иванов получил 5 по предмету Математика.
Студент Петрова получил 4 по предмету Информатика.
Студент Краснов получил 5 по предмету Физика. */

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class l2_task3 {
    public static void main(String[] args) {
        String fileName = "./Lesson2/students.txt";
        parseAndPrintStudents(fileName);
    }

    public static void parseAndPrintStudents(String fileName) {
        StringBuilder output = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), "UTF-8"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] students = line.split("\\},\\{");

                for (String student : students) {
                    // Удаление лишних символов { и }
                    student = student.replaceAll("[\\{\\}\\[\\]]", "");
                    String[] attributes = student.split(",");
                    String surname = null;
                    String grade = null;
                    String subject = null;

                    for (String attribute : attributes) {
                        String[] keyValue = attribute.split(":");
                        String key = keyValue[0].replaceAll("\"", "");
                        String value = keyValue[1].replaceAll("\"", "");
                        switch (key) {
                            case "фамилия":
                                surname = value;
                                break;
                            case "оценка":
                                grade = value;
                                break;
                            case "предмет":
                                subject = value;
                                break;
                        }
                    }

                    if (surname != null && grade != null && subject != null) {
                        output.append("Студент ").append(surname)
                                .append(" получил ").append(grade)
                                .append(" по предмету ").append(subject)
                                .append(".\n");
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(output.toString());
    }
}
