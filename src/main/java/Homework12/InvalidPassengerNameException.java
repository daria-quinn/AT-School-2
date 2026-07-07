package Homework12;

/** Неправильное имя пассажира (null или пустая строка) */
public class InvalidPassengerNameException extends RuntimeException {
    public InvalidPassengerNameException() {
        super("Имя пассажира не может быть null или пустым");
    }
}
