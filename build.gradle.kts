import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
  kotlin("jvm") version "1.4.20"
}

group = "io.plagov"
version = "1.0-SNAPSHOT"

repositories {
  mavenCentral()
}

dependencies {
  testImplementation("io.kotest:kotest-runner-junit5:4.4.0")
}

tasks.test {
  useJUnitPlatform()
}

tasks.withType<KotlinCompile>() {
  kotlinOptions.jvmTarget = "11"
}
