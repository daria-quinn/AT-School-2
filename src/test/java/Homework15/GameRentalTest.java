package Homework15;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class GameRentalTest {
    private GameRental rental;

    @BeforeEach
    void setUp() {
        rental = new GameRental();
        rental.addGame(new BoardGame("Монополия", 8, 500));
        rental.addGame(new BoardGame("Шахматы", 6, 300));
    }

    @Test
    void testRentGameSuccess() {
        assertTrue(rental.rentGame("Монополия", 10));
        // Проверим, что игра стала арендованной (можно через findGame)
        BoardGame game = rental.findGame("Монополия");
        assertTrue(game.isRented());
    }

    @Test
    void testRentGameNotExistsThrowsException() {
        assertThrows(IllegalArgumentException.class,
                () -> rental.rentGame("Скрабл", 10));
    }

    @Test
    void testRentGameTooYoungReturnsFalse() {
        assertFalse(rental.rentGame("Шахматы", 5));
        BoardGame game = rental.findGame("Шахматы");
        assertFalse(game.isRented()); // не должна быть арендована
    }

    @Test
    void testRentGameAlreadyRentedReturnsFalse() {
        rental.rentGame("Монополия", 10);
        assertFalse(rental.rentGame("Монополия", 15));
    }

    @Test
    void testReturnGameSuccess() {
        rental.rentGame("Монополия", 10);
        assertTrue(rental.returnGame("Монополия"));
        BoardGame game = rental.findGame("Монополия");
        assertFalse(game.isRented());
    }

    @Test
    void testReturnGameNotExistsReturnsFalse() {
        assertFalse(rental.returnGame("Скрабл"));
    }

    @Test
    void testReturnGameNotRentedReturnsFalse() {
        assertFalse(rental.returnGame("Шахматы")); // не арендована
    }
}
