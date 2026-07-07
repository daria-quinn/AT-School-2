package Homework12;

/**
 * Багажная бирка, выдаваемая пассажиру после успешной сдачи багажа.
 */
public class BaggageTicket {

    /** ФИО пассажира */
    private final String passengerName;

    /** Номер рейса (может содержать буквы и цифры) */
    private final String flightNumber;

    /** Вес багажа в килограммах */
    private final int weightKg;

    /**
     * Конструктор.
     *
     * @param passengerName ФИО пассажира
     * @param flightNumber  Номер рейса
     * @param weightKg      Вес багажа (целое число)
     */
    public BaggageTicket(String passengerName, String flightNumber, int weightKg) {
        this.passengerName = passengerName;
        this.flightNumber = flightNumber;
        this.weightKg = weightKg;
    }

    /** Геттер имени пассажира */
    public String getPassengerName() {
        return passengerName;
    }

    /** Геттер номера рейса */
    public String getFlightNumber() {
        return flightNumber;
    }

    /** Геттер веса багажа */
    public int getWeightKg() {
        return weightKg;
    }

    @Override
    public String toString() {
        return "BaggageTicket{" +
                "passengerName='" + passengerName + '\'' +
                ", flightNumber='" + flightNumber + '\'' +
                ", weightKg=" + weightKg +
                '}';
    }
}
