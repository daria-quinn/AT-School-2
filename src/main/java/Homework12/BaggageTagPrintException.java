package Homework12;

/** Ошибка печати бирки */
public class BaggageTagPrintException extends AirportServiceException {
    public BaggageTagPrintException(String flightNumber) {
        super("Не удалось напечатать бирку для рейса " + flightNumber);
    }
}
