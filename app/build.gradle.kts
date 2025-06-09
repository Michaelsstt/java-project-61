plugins {

    id("com.github.ben-manes.versions") version "0.52.0"
    application
    id("org.sonarqube") version "6.2.0.5505"

    id("java")
    checkstyle
}

application {
    mainClass.set("hexlet.code.App")
}

group = "hexlet.code"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}

tasks.getByName("run", JavaExec::class) {
    standardInput = System.`in`
}

sonar {
    properties {
        property("sonar.projectKey", "Michaelsstt_java-project-61")
        property("sonar.organization", "michaelsstt")
        property("sonar.host.url", "https://sonarcloud.io")
    }
}