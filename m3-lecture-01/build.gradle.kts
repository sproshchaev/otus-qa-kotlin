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
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.10.0") // Укажите актуальную версию

    // Движок для запуска тестов JUnit 5 в среде выполнения (runtime)
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.10.0")

    // Опционально: улучшенные ассерты (assertions), например, AssertJ или Kotest
    // testImplementation("org.assertj:assertj-core:3.24.2")
}

tasks.test {
    useJUnitPlatform() // указывает Gradle использовать JUnit Platform
}

kotlin {
    jvmToolchain(21)
}