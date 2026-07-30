plugins {
    kotlin("jvm")
}

group = "ru.otus"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    // Kotlin-обёртка над тестовым фреймворком (для примера 12)
    testImplementation(kotlin("test"))

    // ЯВНОЕ подключение JUnit Jupiter API — то, чем пишем тесты
    testImplementation("org.junit.jupiter:junit-jupiter-api:6.1.2")

    // Источники данных для параметризованных тестов
    testImplementation("org.junit.jupiter:junit-jupiter-params:6.1.2")

    // Движок для запуска тестов в среде выполнения
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:6.1.2")
}

tasks.test {
    useJUnitPlatform { // указывает Gradle использовать JUnit Platform
        // Фильтрация по тегам (пример 7): ./gradlew test -DincludeTags=fast
        val include = System.getProperty("includeTags")
        val exclude = System.getProperty("excludeTags")
        include?.let { includeTags(it) }
        exclude?.let { excludeTags(it) }
        // По умолчанию исключаем намеренно падающий демо-тест (тег "failing"),
        // чтобы он не рушил общий ./gradlew build.
        // Запустить его отдельно: ./gradlew :m3-lecture-01:test -DincludeTags=failing
        if (include == null && exclude == null) {
            excludeTags("failing")
        }
    }
    testLogging {
        showStandardStreams = true // вывод println из демо виден в консоли
    }
}

kotlin {
    jvmToolchain(21)
}
