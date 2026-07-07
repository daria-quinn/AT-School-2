package Homework12;

public class OverweightBaggageException extends AirportServiceException {
    public OverweightBaggageException(int weightKg) {
        super("Багаж слишком тяжёлый: " + weightKg + " кг (максимум 23 кг)");
    }
}
