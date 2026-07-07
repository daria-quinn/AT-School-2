package Homework12;

/** Рейс не найден в базе */
public class FlightNotFoundException extends AirportServiceException {
    public FlightNotFoundException(String flightNumber) {
        super("Рейс не найден: " + flightNumber);
    }
}
