plugins {
    kotlin("jvm")   // Kotlin плагин (версия задаётся централизованно в settings.gradle.kts)
    application      // Для запуска приложения
}

group = "ru.otus"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))    // Стандартная библиотека Kotlin
    testImplementation(kotlin("test"))  // Всё необходимое для тестирования в одной зависимости
}

tasks.test {
    useJUnitPlatform()
    testLogging {
        events("passed", "failed", "skipped")
        showStandardStreams = true
    }
}

application {
    mainClass.set("ru.otus.m3.MainKt")
}

kotlin {
    jvmToolchain(21)
}
