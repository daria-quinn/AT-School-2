package Homework15;

import java.util.HashMap;
import java.util.Map;

public class GameRental {
    private final Map<String, BoardGame> catalog = new HashMap<>();

    // ---------- Добавление игры ----------
    public void addGame(BoardGame game) {
        if (game == null) {
            throw new IllegalArgumentException("Игра не может быть null");
        }
        String name = game.getName();
        if (catalog.containsKey(name)) {
            throw new IllegalArgumentException("Игра с таким названием уже существует");
        }
        catalog.put(name, game);
    }

    // ---------- Поиск игры ----------
    public BoardGame findGame(String name) {
        return catalog.get(name); // вернёт null, если нет
    }

    // ---------- Аренда ----------
    public boolean rentGame(String name, int customerAge) {
        BoardGame game = catalog.get(name);
        if (game == null) {
            throw new IllegalArgumentException("Игра не найдена");
        }
        if (!game.canBeRentedBy(customerAge)) {
            return false;
        }
        if (game.isRented()) {
            return false;
        }
        game.setRented(true);
        return true;
    }

    // ---------- Возврат ----------
    public boolean returnGame(String name) {
        BoardGame game = catalog.get(name);
        if (game == null) {
            return false;
        }
        if (!game.isRented()) {
            return false;
        }
        game.setRented(false);
        return true;
    }

    // ---------- Расчёт стоимости ----------
    public int calculateCost(String name, int days) {
        BoardGame game = catalog.get(name);
        if (game == null) {
            throw new IllegalArgumentException("Игра не найдена");
        }
        if (days <= 0) {
            throw new IllegalArgumentException("Количество дней должно быть положительным");
        }
        return game.getRentalCostPerDay() * days;
    }

    // ---------- Сброс состояния ----------
    public void reset() {
        for (BoardGame game : catalog.values()) {
            game.setRented(false);
        }
    }
}
