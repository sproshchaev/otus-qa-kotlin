plugins {
    kotlin("jvm")
    id("net.serenity-bdd.serenity-gradle-plugin") version "3.6.22"  // для Serenity отчётов
}

group = "ru.otus"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    // Kotlin
    implementation(kotlin("stdlib"))
    testImplementation(kotlin("test"))

    // Serenity BDD
    testImplementation("net.serenity-bdd:serenity-core:3.6.0")
    testImplementation("net.serenity-bdd:serenity-junit:3.6.0")
    testImplementation("net.serenity-bdd:serenity-cucumber:3.6.0")  // для интеграции с Cucumber

    // Cucumber
    testImplementation("io.cucumber:cucumber-java8:7.11.0")
    testImplementation("io.cucumber:cucumber-junit-platform-engine:7.11.0")

    // JUnit 5 (нужен и для Serenity, и для Cucumber)
    testImplementation("org.junit.jupiter:junit-jupiter:5.9.2")
    testImplementation("org.junit.platform:junit-platform-suite:1.9.2")
}

kotlin {
    jvmToolchain(21)
}

tasks.test {
    useJUnitPlatform()
    testLogging {
        events("passed", "skipped", "failed")
    }
}

// Задача для генерации отчётов Serenity
tasks.register<JavaExec>("serenityReport") {
    dependsOn("test")

    mainClass.set("net.thucydides.core.reports.html.ReportGenerator")
    args = listOf(
        "-p", "target/site/serenity",
        "-d", "target/site/serenity"
    )
    classpath = sourceSets.test.get().runtimeClasspath
}