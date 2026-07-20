package Homework12;

/**
 * Критическая ошибка, блокирующая работу стойки при поломке конвейера.
 * Ошибки типа Error обычно не ловятся в обычных catch‑блоках.
 */
public class ConveyorBeltMalfunctionError extends Error {
    public ConveyorBeltMalfunctionError() {
        super("Критическая поломка конвейерной ленты. Остановка обслуживания.");
    }
}