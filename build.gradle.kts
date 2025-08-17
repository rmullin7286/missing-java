plugins {
    java
}

group = "me.rmullin"
version = "0.0.1"

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(21))  // Set Java version to JDK 21
    }
}

repositories {
    mavenCentral()  // Dependency repository
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.1")  // Example test dependency
}

tasks.test {
    useJUnitPlatform()  // Enable JUnit 5 for testing
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"  // Set source encoding
}
