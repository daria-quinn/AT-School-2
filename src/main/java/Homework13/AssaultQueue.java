package Homework13;

import java.util.LinkedList;

/**
 * Очередь штурмовиков.
 */
public class AssaultQueue {

    private final LinkedList<String> queue = new LinkedList<>();

    /** Добавить рекрута в конец очереди */
    public void addRecruit(String name) {
        queue.addLast(name);
    }

    /** Удалить и вернуть первого в очереди (трус) */
    public String retreatCoward() {
        if (queue.isEmpty()) {
            return null;
        }
        return queue.removeFirst();
    }

    /** Вывести текущее состояние очереди */
    public void printQueue() {
        System.out.println("Текущее состояние очереди: " + queue);
    }

    @Override
    public String toString() {
        return "AssaultQueue" + queue;
    }
}