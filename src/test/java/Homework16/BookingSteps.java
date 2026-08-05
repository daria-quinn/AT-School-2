package Homework16;


import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;
import java.util.Map;

public class BookingSteps {

    // ====== Блок 1 и 2 (Background) ======

    @Given("в ресторане есть столики:")
    public void вРесторанеЕстьСтолики(DataTable table) {
        List<Map<String, String>> rows = table.asMaps(String.class, String.class);
        System.out.println("Добавляем столики:");
        for (Map<String, String> row : rows) {
            System.out.println("  столик №" + row.get("номер") + ", вместимость " + row.get("вместимость"));
        }
        // Заглушка: реальное добавление не требуется
    }

    @Given("в ресторане есть столик вместимостью {int}")
    public void вРесторанеЕстьСтоликВместимостью(int capacity) {
        System.out.println("Добавлен столик вместимостью " + capacity);
        // Заглушка
    }

    @Given("все столики заняты")
    public void всеСтоликиЗаняты() {
        System.out.println("Все столики заняты");
        // Заглушка
    }

    @Given("гость уже забронировал столик на {int} человек")
    public void гостьУжеЗабронировалСтолик(int guests) {
        System.out.println("Гость уже забронировал столик на " + guests + " человек");
        // Заглушка
    }

    // ====== When ======

    @When("гость забронировал столик на {int} человек")
    public void гостьЗабронировалСтолик(int guests) {
        System.out.println("Гость бронирует столик на " + guests + " человек");
        // Заглушка
    }

    @When("гость пытается забронировать столик на {int} человек")
    public void гостьПытаетсяЗабронироватьСтолик(int guests) {
        System.out.println("Гость пытается забронировать столик на " + guests + " человек");
        // Заглушка
    }

    @When("гость отменяет своё бронирование")
    public void гостьОтменяетСвоёБронирование() {
        System.out.println("Гость отменяет бронирование");
        // Заглушка
    }

    @When("гость оставляет пожелание к брони:")
    public void гостьОставляетПожеланиеКБрони(String docString) {
        System.out.println("Пожелание клиента:\n" + docString);
        // Заглушка
    }

    // ====== Then ======

    @Then("бронирование подтверждено")
    public void бронированиеПодтверждено() {
        System.out.println("Бронирование подтверждено");
        // Заглушка
    }

    @Then("бронирование отклонено с сообщением {string}")
    public void бронированиеОтклоненоССообщением(String message) {
        System.out.println("Бронирование отклонено: " + message);
        // Заглушка
    }

    @Then("бронирование успешно отменено")
    public void бронированиеУспешноОтменено() {
        System.out.println("Бронирование отменено успешно");
        // Заглушка
    }

    @Then("результат бронирования — {word}")
    public void результатБронирования(String expectedResult) {
        System.out.println("Результат бронирования: " + expectedResult);
        // Заглушка
    }

    @Then("пожелание сохранено")
    public void пожеланиеСохранено() {
        System.out.println("Пожелание сохранено");
        // Заглушка
    }
}