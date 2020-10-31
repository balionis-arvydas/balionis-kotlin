plugins {
    application
}
dependencies {
    implementation(kotlin("stdlib-jdk8"))

    implementation("io.github.microutils:kotlin-logging:1.11.5")
    implementation("ch.qos.logback:logback-classic:1.2.3")

    implementation(project(":client"))

    implementation("com.squareup.moshi:moshi:1.9.3")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.11.2")

    testImplementation("junit:junit:4.11")
    testImplementation(kotlin("test-junit"))
}

application {
    mainClassName = "com.balionis.kotlin8.server.AppKt"
}