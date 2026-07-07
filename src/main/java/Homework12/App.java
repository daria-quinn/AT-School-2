package Homework12;

public class App {
    public static void main(String[] args) {
        // Список рейсов, обслуживаемых стойкой
        String[] flights = {"SU-123", "TK-777", "KC-909", "AE-404"};
        BaggageDropDesk desk = new BaggageDropDesk(flights);

        // 1. Успешная сдача багажа
        try {
            BaggageTicket t1 = desk.dropBaggage("Ivan Petrov", "SU-123", 18);
            System.out.println("Успешно: " + t1);
        } catch (Exception e) {
            System.out.println("Неожиданная ошибка: " + e.getMessage());
        }

        // 2. Рейс не существует
        try {
            desk.dropBaggage("Anna Smirnova", "XX-999", 15);
        } catch (FlightNotFoundException e) {
            System.out.println("Ошибка рейса: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Другой тип ошибки: " + e.getMessage());
        }

        // 3. Перевес багажа
        try {
            desk.dropBaggage("Sergey Ivanov", "TK-777", 30);
        } catch (OverweightBaggageException e) {
            System.out.println("Перевес: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Другой тип ошибки: " + e.getMessage());
        }

        // 4. Проблема с печатью бирки
        try {
            desk.dropBaggage("Olga Petrova", "AE-404", 20);
        } catch (BaggageTagPrintException e) {
            System.out.println("Проблема печати: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Другой тип ошибки: " + e.getMessage());
        }

        // 5. Некорректное имя (null)
        try {
            desk.dropBaggage(null, "KC-909", 12);
        } catch (InvalidPassengerNameException e) {
            System.out.println("Неправильное имя: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Другой тип ошибки: " + e.getMessage());
        }

        // 6. Некорректный вес (отрицательный)
        try {
            desk.dropBaggage("Dmitry Kozlov", "KC-909", -5);
        } catch (InvalidBaggageWeightException e) {
            System.out.println("Неправильный вес: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Другой тип ошибки: " + e.getMessage());
        }

        // Пример критической ошибки (необязательно, но демонстрирует её)
        try {
            // Предположим, что в какой‑то момент конвейер ломается
            throw new ConveyorBeltMalfunctionError();
        } catch (ConveyorBeltMalfunctionError e) {
            // Обычно такие ошибки не ловятся, но для демонстрации выводим сообщение
            System.err.println("Критическая ошибка: " + e.getMessage());
        }
    }
}
