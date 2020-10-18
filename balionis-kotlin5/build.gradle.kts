plugins {
    application
    kotlin("jvm") version "1.3.72"
}

repositories {
    mavenCentral()
}

apply {
    plugin("kotlin")
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))

    implementation("io.github.microutils:kotlin-logging:1.11.5")
    implementation("ch.qos.logback:logback-classic:1.2.3")

    testImplementation("junit:junit:4.11")
    testImplementation(kotlin("test-junit"))

    implementation("org.activiti:activiti-engine:5.23.0")
    implementation("com.h2database:h2:1.4.200")

}

application {
    mainClassName = "com.balionis.kotlin5.AppKt"
}
