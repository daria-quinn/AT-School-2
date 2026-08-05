package Homework15;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GameCatalogTest {
    private GameRental rental;

    @BeforeEach
    void setUp() {
        rental = new GameRental();
        // Можно добавить игры для некоторых тестов, но лучше делать это в каждом тесте явно,
        // чтобы тесты были независимы. Но для поиска можно подготовить каталог.
    }

    @Test
    public void testAddGameSuccess() {
        BoardGame game = new BoardGame("Монополия", 8, 500);
        assertDoesNotThrow(() -> rental.addGame(game));
        assertNotNull(rental.findGame("Монополия"));
    }

    @Test
    void testAddNullGameThrowsException() {
        assertThrows(IllegalArgumentException.class,
                () -> rental.addGame(null));
    }

    @Test
    void testAddDuplicateGameThrowsException() {
        BoardGame game = new BoardGame("Монополия", 8, 500);
        rental.addGame(game);
        BoardGame duplicate = new BoardGame("Монополия", 10, 600);
        assertThrows(IllegalArgumentException.class,
                () -> rental.addGame(duplicate));
    }

    @Test
    void testFindGameReturnsNullIfNotFound() {
        assertNull(rental.findGame("Неизвестная игра"));
    }

    @Test
    void testFindGameReturnsGameIfExists() {
        BoardGame game = new BoardGame("Монополия", 8, 500);
        rental.addGame(game);
        BoardGame found = rental.findGame("Монополия");
        assertNotNull(found);
        assertEquals("Монополия", found.getName());
    }
}
