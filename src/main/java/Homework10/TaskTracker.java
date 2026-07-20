package Homework10;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TaskTracker {
    /** Список всех задач */
    private final List<Task> tasks = new ArrayList<>();

    /** Добавить новую задачу */
    public void addTask(String title) {
        // Предотвращаем дублирование по названию
        if (findTask(title).isPresent()) {
            System.out.println("Задача с таким названием уже существует: " + title);
            return;
        }
        tasks.add(new Task(title));
    }

    /** Вывести все задачи */
    public void printAll() {
        if (tasks.isEmpty()) {
            System.out.println("Список задач пуст.");
            return;
        }
        System.out.println("Список задач:");
        tasks.forEach(task -> System.out.println("  " + task.display()));
    }

    /** Найти задачу по названию */
    public Optional<Task> findTask(String title) {
        return tasks.stream()
                .filter(t -> t.getTitle().equalsIgnoreCase(title))
                .findFirst();
    }

    /** Вывести информацию о задаче или сообщение об ошибке */
    public void printTaskInfo(String title) {
        Optional<Task> opt = findTask(title);
        if (opt.isPresent()) {
            System.out.println(opt.get().display());
        } else {
            System.out.println("Задача не найдена");
        }
    }

    /** Пометить задачу как выполненную (по названию) */
    public void markTaskAsDone(String title) {
        Optional<Task> opt = findTask(title);
        if (opt.isPresent()) {
            opt.get().markAsDone();
            System.out.println("Задача отмечена как выполненная: " + title);
        } else {
            System.out.println("Задача не найдена");
        }
    }

    /** Вывести статистику по задачам */
    public void printStatistics() {
        long total = tasks.size();
        long done = tasks.stream().filter(Task::isCompleted).count();
        long open = total - done;

        System.out.println("Всего задач: " + total);
        System.out.println("Выполнено: " + done);
        System.out.println("Открыто: " + open);
    }
}
