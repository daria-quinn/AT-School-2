package com.lesson.homework;

import com.lesson.homework.models.Usuario;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ServeRestTest {

    private static final String UNIQUE_EMAIL = "spy_" + System.currentTimeMillis() + "@qa.com";

    private static String userId;
    private static String token;

    @BeforeAll
    static void setup() {
        RestAssured.baseURI = "https://serverest.dev";
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }

    @Test
    @Order(1)
    @DisplayName("Задание 2. Получаем всех пользователей")
    void shouldGetAllUsers() {
        given()
                .when()
                .get("/usuarios")
                .then()
                .statusCode(200)
                .contentType(containsString("application/json"))
                .body("quantidade", greaterThan(0))
                .body("usuarios", not(empty()));
    }

    @Test
    @Order(2)
    @DisplayName("Задание 3. Ищем пользователя по email")
    void shouldFindUserByEmail() {
        String email = given()
                .when()
                .get("/usuarios")
                .then()
                .statusCode(200)
                .extract()
                .path("usuarios[0].email");

        given()
                .queryParam("email", email)
                .when()
                .get("/usuarios")
                .then()
                .statusCode(200)
                .body("quantidade", equalTo(1))
                .body("usuarios[0].email", equalTo(email));
    }

    @Test
    @Order(3)
    @DisplayName("Задание 4. Регистрируем нового пользователя")
    void shouldCreateNewUser() {
        String body = """
                {
                  "nome": "Тайный Покупатель",
                  "email": "%s",
                  "password": "secret123",
                  "administrador": "true"
                }
                """.formatted(UNIQUE_EMAIL);

        userId = given()
                .contentType(ContentType.JSON)
                .body(body)
                .when()
                .post("/usuarios")
                .then()
                .statusCode(201)
                .body("message", equalTo("Cadastro realizado com sucesso"))
                .body("_id", not(emptyString()))
                .extract()
                .path("_id");
    }

    @Test
    @Order(4)
    @DisplayName("Задание 5. Обновляем данные пользователя")
    void shouldUpdateUser() {
        String body = """
                {
                  "nome": "Обновлённый Покупатель",
                  "email": "%s",
                  "password": "secret123",
                  "administrador": "false"
                }
                """.formatted(UNIQUE_EMAIL);

        given()
                .contentType(ContentType.JSON)
                .body(body)
                .pathParam("id", userId)
                .when()
                .put("/usuarios/{id}")
                .then()
                .statusCode(200)
                .body("message", equalTo("Registro alterado com sucesso"));
    }

    @Test
    @Order(5)
    @DisplayName("Задание 6.1. Логинимся и получаем токен")
    void shouldLogin() {
        String loginBody = """
                {
                  "email": "%s",
                  "password": "secret123"
                }
                """.formatted(UNIQUE_EMAIL);

        token = given()
                .contentType(ContentType.JSON)
                .body(loginBody)
                .when()
                .post("/login")
                .then()
                .statusCode(200)
                .body("message", equalTo("Login realizado com sucesso"))
                .body("authorization", not(emptyString()))
                .extract()
                .path("authorization");
    }

    @Test
    @Order(6)
    @DisplayName("Задание 6.2. Удаляем пользователя и проверяем, что он исчез")
    void shouldDeleteUser() {
        given()
                .header("Authorization", token)
                .pathParam("id", userId)
                .when()
                .delete("/usuarios/{id}")
                .then()
                .statusCode(200)
                .body("message", equalTo("Registro excluído com sucesso"));

        given()
                .pathParam("id", userId)
                .when()
                .get("/usuarios/{id}")
                .then()
                .statusCode(400)
                .body("message", equalTo("Usuário não encontrado"));
    }

    @Test
    @Order(7)
    @DisplayName("Задание 7. Каталог товаров")
    void shouldGetAllProducts() {
        given()
                .when()
                .get("/produtos")
                .then()
                .statusCode(200)
                .body("quantidade", greaterThan(0))
                .body("produtos.preco", everyItem(greaterThan(0)))
                .body("produtos.nome", everyItem(not(emptyString())))
                .body("produtos.nome", hasItem(not(emptyString())));
    }

    @Test
    @Order(8)
    @DisplayName("★ Создание пользователя через DTO (сериализация)")
    void shouldCreateUserFromDto() {
        String dtoEmail = "spy_" + (System.currentTimeMillis() + 1) + "@qa.com";
        Usuario novoUsuario =
                new Usuario("Тайный Покупатель", dtoEmail, "secret123", "true");

        given()
                .contentType(ContentType.JSON)
                .body(novoUsuario)
                .when()
                .post("/usuarios")
                .then()
                .statusCode(201)
                .body("message", equalTo("Cadastro realizado com sucesso"))
                .body("_id", not(emptyString()));
    }
}
