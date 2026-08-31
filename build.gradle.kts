plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven { url = uri("https://jitpack.io") }
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.10.0")
    testImplementation("io.cucumber:cucumber-java:7.18.0")
    testImplementation("io.cucumber:cucumber-junit-platform-engine:7.18.0")
    testImplementation("org.junit.platform:junit-platform-suite:1.10.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.10.0")
    //testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    // генератор случайных данных
    implementation("net.datafaker:datafaker:2.5.4")
// библиотека для вывода ASCII‑текста
    implementation("com.github.lalyos:jfiglet:0.0.8")

    // Домашка 17 — тайный покупатель (ServeRest)
    testImplementation("io.rest-assured:rest-assured:5.5.0")
    testImplementation("com.fasterxml.jackson.core:jackson-databind:2.17.2")
}

tasks.test {
    useJUnitPlatform()

    // Игнорируем фильтр по конкретному классу, который передаёт IDEA,
    // чтобы всегда запускался весь набор тестов :test
    filter {
        isFailOnNoMatchingTests = false
    }
}
