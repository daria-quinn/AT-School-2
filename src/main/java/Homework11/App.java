package Homework11;

import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        CoffeeMachine machine = new CoffeeMachine();
        Scanner scanner = new Scanner(System.in);

        /* 3.1. Проверка InputMismatchException */
        System.out.print("Введите количество воды (мл): ");
        try {
            int water = scanner.nextInt();               // может бросить InputMismatchException
            System.out.println("Введено: " + water + " мл");
        } catch (InputMismatchException e) {
            System.out.println("Ошибка: нужно было ввести число");
            scanner.nextLine(); // очистить ввод
        }

        /* 3.2. Проверка собственного исключения */
        try {
            machine.makeCoffee(100);                      // воды недостаточно
        } catch (NotEnoughWaterException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Проверка кофемашины завершена");
        }

        /* 3.3. Проверка ArithmeticException */
        try {
            int cups = machine.calculateCups(1000, 0);    // деление на 0
            System.out.println("Можно приготовить чашек: " + cups);
        } catch (ArithmeticException e) {
            System.out.println("Ошибка: размер чашки не может быть 0");
        }

        /* 3.4. Проверка NullPointerException */
        try {
            String coffeeName = null;
            machine.printCoffeeName(coffeeName);
        } catch (NullPointerException e) {
            System.out.println("Ошибка: название кофе отсутствует");
        }

        scanner.close();
    }
}
