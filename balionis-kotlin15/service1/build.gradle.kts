import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

plugins {
    id("application")
    id("com.github.johnrengelman.shadow") version "6.1.0"
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))

    implementation(Libs.KOTLIN_LOGGING)
    implementation(Libs.LOGBACK_CLASSIC)

    implementation(project(":common"))

    implementation(Libs.MOSHI)
    implementation(Libs.JACKSON_DATABIND)

    testImplementation(Libs.JUNIT)
    testImplementation(kotlin("test-junit"))
}

application {
    mainClassName = "com.balionis.kotlin15.service1.AppKt"

    // FIXME: this does not work!
    applicationDistribution.exclude("**/logback*.xml")
}

tasks.withType<ShadowJar> {
    mergeServiceFiles {
        // FIXME: this does not work!
        exclude("**/logback*.xml")
    }
}
