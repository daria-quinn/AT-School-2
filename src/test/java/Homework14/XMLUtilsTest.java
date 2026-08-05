package Homework14;          // <-- Пакет должен совпадать с каталогом

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Тесты для XMLUtils")
class XMLUtilsTest {

    @Test
    @DisplayName("Создание валидного элемента с тегом user")
    void createEmptyElement_ValidTag_ReturnsCorrectXml() {
        // Arrange (подготовка данных)
        String tagName = "user";
        String expected = "<user></user>";

        // Act (выполнение действия)
        String actual = XMLUtils.createEmptyElement(tagName);

        // Assert (проверка результата)
        assertEquals(expected, actual,
                "Ожидалось, что для тега '" + tagName +
                        "' будет создан элемент <user></user>, но получен: " + actual);
    }

    @Test
    @DisplayName("Создание элемента с пустым тегом")
    void createEmptyElement_EmptyTag_ReturnsInvalid() {
        // Arrange
        String tagName = "";
        String expected = "<invalid/>";

        // Act
        String actual = XMLUtils.createEmptyElement(tagName);

        // Assert
        assertEquals(expected, actual,
                "Ожидалось, что при передаче пустой строки будет возвращен <invalid/>, " +
                        "но получен: " + actual);
    }

    @Test
    @DisplayName("Создание элемента с null-тегом")
    void createEmptyElement_NullTag_ReturnsInvalid() {
        // Arrange
        String tagName = null;
        String expected = "<invalid/>";

        // Act
        String actual = XMLUtils.createEmptyElement(tagName);

        // Assert
        assertEquals(expected, actual,
                "Ожидалось, что при передаче null будет возвращен <invalid/>, " +
                        "но получен: " + actual);
    }

    @Test
    @DisplayName("Создание элемента с тегом из нескольких символов")
    void createEmptyElement_MultiCharTag_ReturnsCorrectXml() {
        // Arrange
        String tagName = "employee";
        String expected = "<employee></employee>";

        // Act
        String actual = XMLUtils.createEmptyElement(tagName);

        // Assert
        assertEquals(expected, actual,
                "Ожидалось, что для тега '" + tagName +
                        "' будет создан элемент <employee></employee>, но получен: " + actual);
    }
}