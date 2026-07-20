package Homework13;

import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args) {

        /* ---------- Часть 1: База данных пришельцев ---------- */
        System.out.println("=== Часть 1: База данных пришельцев ===");
        List<Alien> alienList = new ArrayList<>();
        alienList.add(new Alien("Зигмунд", "Марс", 5));
        alienList.add(new Alien("Альфа", "Венера", 7));
        alienList.add(new Alien("Бета", "Юпитер", 3));
        alienList.add(new Alien("Зигмунд", "Марс", 9)); // дубликат по имени и планете
        alienList.add(new Alien("Гамма", "Сатурн", 6));

        Alien duplicate = new Alien("Зигмунд", "Марс", 1);
        boolean containsDuplicate = alienList.contains(duplicate);
        System.out.println("Список содержит дубликат (по имени и планете)? " + containsDuplicate);

        /* ---------- Часть 2: Формирование отрядов ---------- */
        System.out.println("\n=== Часть 2: Формирование отрядов ===");
        SquadManager manager = new SquadManager();
        manager.demonstrateListCreations();

        /* ---------- Часть 3: Отсеивание трусов ---------- */
        System.out.println("\n=== Часть 3: Отсеивание трусов ===");
        List<String> squad = new ArrayList<>();
        squad.add("Андрей");
        squad.add("Трус Вася");
        squad.add("Ирина");
        squad.add("Трус Пётр");
        squad.add("Ольга");
        manager.filterOutCowards(squad);

        /* ---------- Часть 4: Очередь на вход ---------- */
        System.out.println("\n=== Часть 4: Очередь на вход ===");
        AssaultQueue queue = new AssaultQueue();
        queue.addRecruit("Сергей");
        queue.addRecruit("Марина");
        queue.addRecruit("Денис");
        queue.addRecruit("Екатерина");
        queue.addRecruit("Владимир");

        System.out.println("Уходим из очереди:");
        System.out.println("  " + queue.retreatCoward());
        System.out.println("  " + queue.retreatCoward());

        queue.addRecruit("Наталья");
        queue.addRecruit("Игорь");
        queue.addRecruit("Татьяна");

        queue.printQueue();

        /* ---------- Часть 5: Отчёт командованию ---------- */
        System.out.println("\n=== Часть 5: Отчёт командованию ===");
        List<Alien> captured = List.of(
                new Alien("Зигмунд", "Марс", 5),
                new Alien("Альфа", "Венера", 7),
                new Alien("Бета", "Юпитер", 3)
        );

        MissionReport report1 = new MissionReport("Штурм Зоны 51", captured, 50);
        System.out.println("\nОтчёт 1:");
        System.out.println(report1);

        MissionReport report2 = new MissionReport("Штурм Зоны 51", captured, 50);
        System.out.println("\nОтчёт 2:");
        System.out.println(report2);

        System.out.println("\nСравнение ссылок (==): " + (report1 == report2));
        System.out.println("Сравнение содержимого (equals): " + report1.equals(report2));
    }
}