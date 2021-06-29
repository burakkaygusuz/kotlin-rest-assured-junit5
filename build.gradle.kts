import org.gradle.api.tasks.testing.logging.TestExceptionFormat
import org.gradle.api.tasks.testing.logging.TestLogEvent
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.5.20"
    java
}

group = "kotlin-rest-assured-junit-5"
version = "1.0"

description = "REST API Test with Rest Assured and Kotlin"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.hamcrest:hamcrest:2.2")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit5:1.5.20")
    testImplementation("io.rest-assured:kotlin-extensions:4.4.0")
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_11
}

tasks.test {
    useJUnitPlatform()
    testLogging {
        events(TestLogEvent.PASSED, TestLogEvent.SKIPPED, TestLogEvent.FAILED)
        exceptionFormat = TestExceptionFormat.SHORT
        showCauses = true
        showExceptions = true
        showStackTraces = true
    }
}

tasks.withType<KotlinCompile>().configureEach {
    kotlinOptions.jvmTarget = "11"
}