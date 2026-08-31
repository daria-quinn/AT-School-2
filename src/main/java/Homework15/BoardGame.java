package Homework15;

public class BoardGame {
    private final String name;
    private final int minAge;
    private final int rentalCostPerDay;
    private boolean rented; // по умолчанию false

    // Конструктор с проверками
    public BoardGame(String name, int minAge, int rentalCostPerDay) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Название не может быть null или пустым");
        }
        if (minAge < 0) {
            throw new IllegalArgumentException("Минимальный возраст не может быть отрицательным");
        }
        if (rentalCostPerDay <= 0) {
            throw new IllegalArgumentException("Стоимость аренды должна быть положительной");
        }
        this.name = name;
        this.minAge = minAge;
        this.rentalCostPerDay = rentalCostPerDay;
        this.rented = false;
    }

    // Геттеры
    public String getName() {
        return name;
    }

    public int getMinAge() {
        return minAge;
    }

    public int getRentalCostPerDay() {
        return rentalCostPerDay;
    }

    public boolean isRented() {
        return rented;
    }

    // Метод для изменения состояния аренды (используется GameRental)
    public void setRented(boolean rented) {
        this.rented = rented;
    }

    // Проверка возраста клиента
    public boolean canBeRentedBy(int age) {
        return age >= minAge;
    }
}
