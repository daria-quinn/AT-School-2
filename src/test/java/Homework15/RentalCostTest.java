package Homework15;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;


class RentalCostTest {
    private GameRental rental;

    @BeforeEach
    void setUp() {
        rental = new GameRental();
        rental.addGame(new BoardGame("Монополия", 8, 500));
    }

    @ParameterizedTest
    @MethodSource("provideDaysAndCost")
    void testCalculateCost(int days, int expectedCost) {
        assertEquals(expectedCost, rental.calculateCost("Монополия", days));
    }

    static Stream<Arguments> provideDaysAndCost() {
        return Stream.of(
                Arguments.of(1, 500),
                Arguments.of(3, 1500),
                Arguments.of(7, 3500)
        );
    }

    @Test
    void testCalculateCostGameNotExistsThrowsException() {
        assertThrows(IllegalArgumentException.class,
                () -> rental.calculateCost("Скрабл", 2));
    }

    @Test
    void testCalculateCostZeroOrNegativeDaysThrowsException() {
        assertThrows(IllegalArgumentException.class,
                () -> rental.calculateCost("Монополия", 0));
        assertThrows(IllegalArgumentException.class,
                () -> rental.calculateCost("Монополия", -5));
    }

    @Test
    void testResetMakesAllGamesAvailable() {
        rental.rentGame("Монополия", 10);
        rental.reset();
        BoardGame game = rental.findGame("Монополия");
        assertFalse(game.isRented());
    }
}
