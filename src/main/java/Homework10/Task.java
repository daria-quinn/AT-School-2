package Homework10;

public class Task {
    /** Название задачи */
    private final String title;

    /** Статус: true – выполнена, false – не выполнена */
    private boolean completed;

    /**
     * Конструктор.
     *
     * @param title название задачи (не может быть null или пустой строки)
     */
    public Task(String title) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Название задачи не может быть пустым");
        }
        this.title = title;
        this.completed = false;               // по умолчанию задача не выполнена
    }

    /** Пометить задачу как выполненную */
    public void markAsDone() {
        this.completed = true;
    }

    /** Получить статус выполнения */
    public boolean isCompleted() {
        return completed;
    }

    /** Получить название задачи */
    public String getTitle() {
        return title;
    }

    /**
     * Форматированный вывод информации о задаче.
     * Пример:  [ ] Проверить авторизацию   – если задача не выполнена
     *           [x] Проверить регистрацию    – если задача выполнена
     *
     * @return строка для вывода в консоль
     */
    public String display() {
        String checkBox = completed ? "[x]" : "[ ]";
        return String.format("%s %s", checkBox, title);
    }

    @Override
    public String toString() {
        return display();
    }
}
