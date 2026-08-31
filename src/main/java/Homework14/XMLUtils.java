package Homework14;

/**
 * Утилита для простого формирования XML‑элементов.
 */
public final class XMLUtils {

    private XMLUtils() {
        // закрытый конструктор – класс не предназначен для создания экземпляров
    }

    /**
     * Формирует пустой XML‑элемент.
     *
     * @param tagName имя тега; если null или пустая строка – возвращается <invalid/>
     * @return строка вида <tagName></tagName> или <invalid/>
     */
    public static String createEmptyElement(String tagName) {
        if (tagName == null || tagName.isBlank()) {
            return "<invalid/>";
        }
        return "<" + tagName + "></" + tagName + ">";
    }
}
