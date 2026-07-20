package Homework10;

public class Main {
    public static void main(String[] args) {
        TaskTracker tracker = new TaskTracker();

        // Добавляем несколько задач
        tracker.addTask("Проверить авторизацию");
        tracker.addTask("Проверить регистрацию");
        tracker.addTask("Подготовить отчет");

        // Выводим весь список
        tracker.printAll();
        System.out.println();

        // Ищем задачу и выводим её информацию
        tracker.printTaskInfo("Проверить регистрацию");
        System.out.println();

        // Помечаем одну задачу как выполненную
        tracker.markTaskAsDone("Проверить регистрацию");
        System.out.println();

        // Снова выводим список, чтобы увидеть изменение статуса
        tracker.printAll();
        System.out.println();

        // Статистика
        tracker.printStatistics();
    }
}
