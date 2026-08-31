package Homework15;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class BoardGameTest {

    @Test
    void testCreateBoardGame() {
        BoardGame game = new BoardGame("Монополия", 8, 500);
        assertEquals("Монополия", game.getName());
        assertEquals(8, game.getMinAge());
        assertEquals(500, game.getRentalCostPerDay());
        assertFalse(game.isRented()); // по умолчанию не арендована
    }
    @Test
    void testNullNameThrowsException() {
        assertThrows(IllegalArgumentException.class,
                () -> new BoardGame(null, 8, 500));
    }

    @Test
    void testEmptyNameThrowsException() {
        assertThrows(IllegalArgumentException.class,
                () -> new BoardGame("", 8, 500));
    }

    @Test
    void testNegativeMinAgeThrowsException() {
        assertThrows(IllegalArgumentException.class,
                () -> new BoardGame("Шахматы", -1, 300));
    }

    @Test
    void testZeroOrNegativeCostThrowsException() {
        assertThrows(IllegalArgumentException.class,
                () -> new BoardGame("Шахматы", 6, 0));
        assertThrows(IllegalArgumentException.class,
                () -> new BoardGame("Шахматы", 6, -10));
    }
    @ParameterizedTest
    @CsvSource({
            "8, true",
            "18, true",
            "7, false",
            "0, false"
    })
    void testCanBeRentedBy(int customerAge, boolean expected) {
        BoardGame game = new BoardGame("Монополия", 8, 500);
        assertEquals(expected, game.canBeRentedBy(customerAge));
    }
}