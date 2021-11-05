plugins {
    application
    kotlin("jvm") version "1.4.10"
    kotlin("kapt") version "1.4.10"
}

repositories {
    mavenCentral()
}

apply {
    plugin("kotlin")
    plugin("kotlin-kapt")
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))

    implementation("com.squareup.moshi:moshi:1.9.3")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.11.2")

    implementation("io.github.microutils:kotlin-logging:1.11.5")
    implementation("ch.qos.logback:logback-classic:1.2.3")

    testImplementation("junit:junit:4.11")
    testImplementation(kotlin("test-junit"))

    kapt("com.squareup.moshi:moshi-kotlin-codegen:1.9.3")
}

application {
    mainClassName = "com.balionis.kotlin0.AppKt"
}
