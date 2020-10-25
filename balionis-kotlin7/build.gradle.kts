plugins {
    application
    kotlin("jvm") version "1.4.10"
    kotlin("kapt") version "1.4.10"
    id("com.github.johnrengelman.shadow") version "6.1.0"
    id("com.palantir.docker") version "0.25.0"
    id("com.palantir.docker-compose") version "0.25.0"
}

repositories {
    mavenCentral()
}

apply {
    plugin("kotlin")
    plugin("kotlin-kapt")
    plugin("com.palantir.docker")
    plugin("com.palantir.docker-compose")
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
    mainClassName = "com.balionis.kotlin7.AppKt"
}

docker {
    dependsOn(tasks["shadowJar"])

    name = project.name
    files(tasks["shadowJar"].outputs)
}
