pluginManagement {
    repositories {
        gradlePluginPortal()  // Официальный портал плагинов
        mavenCentral()        // Maven репозиторий
        google()              // Google (для Android)
    }
}

plugins {
    // Apply the foojay-resolver plugin to allow automatic download of JDKs
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.8.0"
    // Kotlin plugin managed centrally
    kotlin("jvm") version "2.2.20" apply false
}

rootProject.name = "otus-qa-kotlin"

// Подключение модулей для многомодульного проекта
include("m1-lecture-05")
include("m2-lecture-01")
include("m3-lecture-01")
include("m3-lecture-03")
include("m4-lecture-02")
include("m4-lecture-02:producer-service")
include("m4-lecture-02:consumer-service")