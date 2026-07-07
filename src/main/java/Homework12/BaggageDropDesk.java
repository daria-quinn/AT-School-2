package Homework12;

/**
 * Стойка приёма багажа.
 * Содержит список доступных рейсов и метод сдачи багажа.
 */
public class BaggageDropDesk {

    /** Список доступных рейсов */
    private final String[] availableFlights;

    /**
     * Конструктор.
     *
     * @param availableFlights массив номеров рейсов, которые обслуживает стойка
     */
    public BaggageDropDesk(String[] availableFlights) {
        this.availableFlights = availableFlights.clone(); // защита от внешних изменений
    }

    /**
     * Сдача багажа.
     *
     * @param passengerName имя пассажира
     * @param flightNumber  номер рейса
     * @param weightKg       вес багажа в килограммах
     * @return объект BaggageTicket при успешной сдаче
     * @throws InvalidPassengerNameException   если имя null или пустое
     * @throws InvalidBaggageWeightException   если вес ≤ 0
     * @throws FlightNotFoundException         если рейса нет в базе
     * @throws OverweightBaggageException      если вес > 23 кг
     * @throws BaggageTagPrintException       если произошёл сбой печати
     */
    public BaggageTicket dropBaggage(String passengerName,
                                     String flightNumber,
                                     int weightKg)
            throws FlightNotFoundException,
            OverweightBaggageException,
            BaggageTagPrintException {

        // 1. Проверка имени пассажира
        if (passengerName == null || passengerName.isBlank()) {
            throw new InvalidPassengerNameException();
        }

        // 2. Проверка веса багажа (некорректный ввод)
        if (weightKg <= 0) {
            throw new InvalidBaggageWeightException();
        }

        // 3. Проверка наличия рейса
        boolean flightExists = false;
        for (String f : availableFlights) {
            if (f.equalsIgnoreCase(flightNumber)) {
                flightExists = true;
                break;
            }
        }
        if (!flightExists) {
            throw new FlightNotFoundException(flightNumber);
        }

        // 4. Проверка ограничения по весу
        if (weightKg > 23) {
            throw new OverweightBaggageException(weightKg);
        }

        // 5. Имитируем сбой печати бирки (специальный рейс)
        if ("AE-404".equalsIgnoreCase(flightNumber)) {
            throw new BaggageTagPrintException(flightNumber);
        }

        // Всё прошло успешно – формируем билет
        BaggageTicket ticket = new BaggageTicket(passengerName, flightNumber, weightKg);
        System.out.println("Багаж принят. Пожалуйста, оплатите налог за безупречно введённые данные.");
        return ticket;
    }
}
