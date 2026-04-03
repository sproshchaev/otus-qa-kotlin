plugins {
    kotlin("jvm")
    id("net.serenity-bdd.serenity-gradle-plugin") version "3.9.0"
}

group = "ru.otus"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))

    // Serenity BDD
    testImplementation("net.serenity-bdd:serenity-core:3.9.0")
    testImplementation("net.serenity-bdd:serenity-junit5:3.9.0")

    // JUnit 5
    testImplementation("org.junit.jupiter:junit-jupiter:5.10.1")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher:1.10.1")
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