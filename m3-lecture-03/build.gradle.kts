plugins {
    kotlin("jvm")   // версия задаётся централизованно в settings.gradle.kts
    // Serenity BDD (слайд 21) — плагин не управляется централизованно, версия указывается здесь
    id("net.serenity-bdd.serenity-gradle-plugin") version "3.0.0"
}

group = "ru.otus"
version = "1.0-SNAPSHOT"

repositories { mavenCentral() }

dependencies {
    implementation(kotlin("stdlib"))

    // --- Spek (слайд 18) ---
    testImplementation("org.spekframework.spek2:spek-dsl-jvm:2.0.19")
    testRuntimeOnly("org.spekframework.spek2:spek-runner-junit5:2.0.19")
    testRuntimeOnly(kotlin("reflect"))

    // --- Serenity BDD (слайд 21), работает на JUnit 4 ---
    testImplementation("net.serenity-bdd:serenity-core:3.0.0")
    testImplementation("net.serenity-bdd:serenity-junit:3.0.0")
    testImplementation("junit:junit:4.13.2")
    testRuntimeOnly("org.junit.vintage:junit-vintage-engine:5.8.1")

    // --- Cucumber (слайд 25) ---
    testImplementation("org.junit.jupiter:junit-jupiter:5.8.1")
    testImplementation("org.junit.platform:junit-platform-suite:1.8.1")
    testImplementation("io.cucumber:cucumber-java8:7.0.0")
    testImplementation("io.cucumber:cucumber-junit-platform-engine:7.0.0")

    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
    testLogging { showStandardStreams = true }   // нужно для примеров 3 и 4
}

kotlin {
    jvmToolchain(21)
}
