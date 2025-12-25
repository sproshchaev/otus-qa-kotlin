plugins {
    kotlin("jvm")
}

group = "ru.otus"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    // Основная зависимость для Kotlin-тестов (уже включает некоторые базовые аннотации)
    testImplementation(kotlin("test"))

    // ЯВНОЕ подключение JUnit 5 Jupiter API (для написания тестов, аннотаций)
    testImplementation("org.junit.jupiter:junit-jupiter-api:6.0.1") // Проверьте актуальную версию на https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter-api

    // Параметризованные тесты (добавьте эту строку!)
    testImplementation("org.junit.jupiter:junit-jupiter-params:6.0.1")

    // Движок для запуска тестов JUnit 5 в среде выполнения (runtime)
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:6.0.1")

    // Опционально: улучшенные ассерты (assertions), например, AssertJ или Kotest
    // testImplementation("org.assertj:assertj-core:3.24.2")
}

tasks.test {
    useJUnitPlatform() // указывает Gradle использовать JUnit Platform
}

kotlin {
    jvmToolchain(21)
}