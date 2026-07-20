package Homework11;

// CoffeeMachine.java
public class CoffeeMachine {

    /** Приготовление кофе */
    public void makeCoffee(int waterMl) {
        if (waterMl <= 200) {
            throw new NotEnoughWaterException(
                    "Недостаточно воды: требуется более 200 мл, а получено " + waterMl + " мл");
        }
        System.out.println("Кофе приготовлен");
    }

    /** Сколько чашек можно приготовить */
    public int calculateCups(int waterMl, int cupSizeMl) {
        // Деление на ноль будет автоматически бросать ArithmeticException
        return waterMl / cupSizeMl;
    }

    /** Вывод названия кофе большими буквами */
    public void printCoffeeName(String coffeeName) {
        if (coffeeName == null) {
            throw new NullPointerException("Название кофе равно null");
        }
        System.out.println(coffeeName.toUpperCase());
    }
}
