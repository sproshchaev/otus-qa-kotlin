plugins {
    kotlin("jvm")
    application
}

group = "ru.otus"
version = "1.0-SNAPSHOT"

application {
    mainClass.set("ru.otus.kafka.consumer.MainKt")
}

repositories {
    mavenCentral()
}

dependencies {
    // Kafka
    implementation("org.apache.kafka:kafka-clients:3.4.0")

    // Logging
    implementation("org.slf4j:slf4j-api:2.0.13")
    implementation("ch.qos.logback:logback-classic:1.5.6")

    // Kotlin
    implementation(kotlin("stdlib"))

    // Testing
    testImplementation(kotlin("test"))
}

kotlin {
    jvmToolchain(21)
}

tasks.test {
    useJUnitPlatform()
}