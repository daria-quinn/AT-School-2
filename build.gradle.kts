plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.10.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.10.0")
    //testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    // генератор случайных данных
    implementation("net.datafaker:datafaker:2.5.4")
// библиотека для вывода ASCII‑текста
    implementation("com.github.lalyos:jfiglet:0.0.8")
}

tasks.test {
    useJUnitPlatform()
}