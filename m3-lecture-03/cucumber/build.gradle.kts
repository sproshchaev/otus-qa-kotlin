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

    // Serenity + Cucumber integration
    testImplementation("net.serenity-bdd:serenity-core:3.9.0")
    testImplementation("net.serenity-bdd:serenity-cucumber:3.9.0")

    // Cucumber
    testImplementation("io.cucumber:cucumber-java8:7.15.0")
    testImplementation("io.cucumber:cucumber-junit-platform-engine:7.15.0")

    // JUnit Platform Suite (для CucumberTestRunner)
    testImplementation("org.junit.platform:junit-platform-suite:1.10.1")
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