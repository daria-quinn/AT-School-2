package Homework13;

import java.util.*;

public class SquadManager {

    /** Демонстрация создания разных видов списков и попыток их модификации */
    public void demonstrateListCreations() {
        // 1️⃣ Основной отряд – обычный ArrayList (можно изменять)
        List<String> mainSquad = new ArrayList<>();
        mainSquad.addAll(List.of("Алексей", "Борис", "Виктор", "Григорий"));
        System.out.println("\n--- Основной отряд (ArrayList) ---");
        modifyList(mainSquad, "Дмитрий");

        // 2️⃣ Отряд поддержки – фиксированный список, полученный через Arrays.asList
        List<String> supportSquad = Arrays.asList("Елена", "Жанна", "Зинаида");
        System.out.println("\n--- Отряд поддержки (Arrays.asList) ---");
        modifyList(supportSquad, "Ирина");

        // 3️⃣ Элитарный отряд – неизменяемый список, полученный через List.of
        List<String> eliteSquad = List.of("Кирилл", "Лариса");
        System.out.println("\n--- Элитарный отряд (List.of) ---");
        modifyList(eliteSquad, "Михаил");
    }

    /** Попытка добавить и удалить один элемент из переданного списка */
    private void modifyList(List<String> list, String newMember) {
        // Добавление
        try {
            list.add(newMember);
            System.out.println("Добавление '" + newMember + "' – успешно");
        } catch (Exception e) {
            System.out.println("Добавление '" + newMember + "' – исключение: " + e.getClass().getSimpleName());
        }

        // Удаление первого элемента (если он есть)
        try {
            String removed = list.remove(0);
            System.out.println("Удаление '" + removed + "' – успешно");
        } catch (Exception e) {
            System.out.println("Удаление – исключение: " + e.getClass().getSimpleName());
        }
    }

    /** Фильтрация «трусишек» из отряда */
    public void filterOutCowards(List<String> squad) {
        System.out.println("\nОтряд до фильтрации: " + squad);

        // 1️⃣ Удаление через Iterator
        Iterator<String> it = squad.iterator();
        while (it.hasNext()) {
            String name = it.next();
            if (name.startsWith("Трус")) {
                it.remove();
            }
        }
        System.out.println("Отряд после фильтрации (Iterator): " + squad);

        // 2️⃣ Альтернативный способ – removeIf (закомментировано, но оставлено для справки)
        // squad.removeIf(name -> name.startsWith("Трус"));
        // System.out.println("Отряд после фильтрации (removeIf): " + squad);
    }
}
