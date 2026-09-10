package main;

import java.util.Scanner;

public class Calculator {
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Первое число: ");
        double result = scanner.nextDouble();

        while (true) {
            boolean error = false;

            System.out.print("+, -, *, /, C - сбросить, S - завершить работу: ");
            char operation = scanner.next().charAt(0);

            if (operation == 'C' || operation == 'c') {
                result = 0;

                System.out.print("Первое число: ");
                result = scanner.nextDouble();

                continue;
            }

            if (operation == 'S' || operation == 's') {
                System.out.print("Работа завершена");

                break;
            }

            System.out.print("Второе число: ");
            double operand2 = scanner.nextDouble();

            switch (operation) {
                case '+':
                    result = result + operand2;
                    break;

                case '-':
                    result = result - operand2;
                    break;

                case '*':
                    result = result * operand2;
                    break;

                case '/':
                    if (operand2 == 0) {
                        System.out.println(ANSI_RED + "Error: деление на ноль невозможно" + ANSI_RESET);
                        System.out.println("Первое число: " + result);
                        error = true;
                    } else {
                        result = result / operand2;
                    }
                    break;

                default:
                    System.out.println(ANSI_RED + "Error: неподдерживаемая операция" + ANSI_RESET);
                    System.out.println("Первое число: " + result);
                    error = true;
            }

            if (!error) {
                System.out.println(ANSI_GREEN + "Результат: " + result + ANSI_RESET);
                System.out.println("Первое число: " + result);
            }
        }

        scanner.close();
    }
}
