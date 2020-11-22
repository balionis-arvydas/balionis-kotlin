import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

allprojects {
    repositories {
        mavenCentral()
    }
}

plugins {
    kotlin("jvm") version "1.4.10"
    kotlin("kapt") version "1.4.10"
    id("com.palantir.docker") version "0.25.0"
    id("com.palantir.docker-compose") version "0.25.0"
}

val kaptProjects = setOf(
    "commons"
)

val dockerProjects = setOf(
    "engine",
    "workers"
)

subprojects {
    apply(plugin = "kotlin")

    if (kaptProjects.contains(this.project.name)) {
        apply(plugin = "kotlin-kapt")
    }

    if (dockerProjects.contains(this.project.name)) {
        apply(plugin = "com.palantir.docker")
        apply(plugin = "com.palantir.docker-compose")
    }

    tasks.withType<KotlinCompile> {
        kotlinOptions.jvmTarget = "11"
    }
}
