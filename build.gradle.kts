plugins {
    id("java")

    id("org.springframework.boot") version ("3.3.3")
}

group = "eu.svorada.alex"
version = "06.09.2024"

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.discord4j:discord4j-core:3.3.0-RC1")
    implementation("ch.qos.logback:logback-classic:1.4.12")
    implementation("org.springframework.boot:spring-boot-starter-web:3.3.3")
}
