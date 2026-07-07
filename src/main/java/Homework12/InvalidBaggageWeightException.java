package Homework12;

/** Неправильный вес багажа (≤ 0) */
public class InvalidBaggageWeightException extends RuntimeException {
    public InvalidBaggageWeightException() {
        super("Вес багажа должен быть положительным числом");
    }
}
