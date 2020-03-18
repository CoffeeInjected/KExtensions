plugins {
    kotlin("jvm") version "1.3.70"
    maven
}

group = "coffee.injected"
version = "0.4.0-SNAPSHOT"

repositories {
    jcenter()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    compileOnly("org.slf4j", "slf4j-api", "1.7.30")
}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
    compileJava {
        options.encoding = "UTF-8"
    }
}