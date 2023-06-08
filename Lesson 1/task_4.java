/*
Задано уравнение вида q + w = e, q, w, e >= 0. Некоторые цифры могут быть заменены знаком вопроса, например, 2? + ?5 = 69.
Требуется восстановить выражение до верного равенства. Предложить хотя бы одно решение или сообщить, что его нет.
Под знаком вопроса - всегда одинаковая ЦИФРА.
Введите уравнение: ?? + ?? = 44
Решение: 22 + 22 = 44
*/

import java.util.Scanner;

public class task_4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите уравнение: ");
        String equation = scanner.nextLine();

        solveEquation(equation);

        scanner.close();
    }

    public static void solveEquation(String equation) {
        boolean solutionFound = false;

        for (int i = 0; i <= 9; i++) {
            String filledEquation = fillQuestionMarks(equation, i);
            if (evaluateEquation(filledEquation)) {
                System.out.println("Решение: " + filledEquation);
                solutionFound = true;
            }
        }

        if (!solutionFound) {
            System.out.println("Решение не найдено");
        }
    }

    public static String fillQuestionMarks(String equation, int digit) {
        StringBuilder filledEquation = new StringBuilder(equation);

        for (int i = 0; i < filledEquation.length(); i++) {
            if (filledEquation.charAt(i) == '?') {
                filledEquation.setCharAt(i, (char) (digit + '0'));
            }
        }
        return filledEquation.toString();
    }

    public static boolean evaluateEquation(String equation) {
        String[] parts = equation.split("=");
    
        if (parts.length != 2) {
            return false;
        }
    
        String leftPart = parts[0].trim();
        String rightPart = parts[1].trim();
    
        String[] operandParts = leftPart.split("\\s*[+\\-*/]\\s*");

        int leftOperand = Integer.parseInt(operandParts[0].trim());
        int rightOperand = Integer.parseInt(operandParts[1].trim());

    
        if (leftOperand == -1 || rightOperand == -1) {
            return false;
        }
    
        String operator = extractOperator(leftPart);
        if (operator.isEmpty()) {
            operator = extractOperator(rightPart);
        }
    
        switch (operator) {
            case "+":
                return leftOperand + rightOperand == extractOperand(rightPart);
            case "-":
                return leftOperand - rightOperand == extractOperand(rightPart);
            case "*":
                return leftOperand * rightOperand == extractOperand(rightPart);
            case "/":
                return leftOperand / rightOperand == extractOperand(rightPart);
            default:
                return false;
        }
    }
    
    public static String extractOperator(String expression) {
        String operator = "";
        if (expression.contains("+")) {
            operator = "+";
        } else if (expression.contains("-")) {
            operator = "-";
        } else if (expression.contains("*")) {
            operator = "*";
        } else if (expression.contains("/")) {
            operator = "/";
        }
        return operator;
    }

    public static int extractOperand(String operand) {
        try {
            return Integer.parseInt(operand.trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}