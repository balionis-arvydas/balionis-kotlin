import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

allprojects {
    repositories {
        mavenCentral()
    }
}

plugins {
    kotlin("jvm") version "1.4.10"
    kotlin("kapt") version "1.4.10"
}

val kotlinProjects = setOf(
    "common"
)

subprojects {
    apply(plugin = "kotlin")

    if (kotlinProjects.contains(this.project.name)) {
        apply(plugin = "kotlin-kapt")
    }

    tasks.withType<KotlinCompile> {
        kotlinOptions.jvmTarget = "11"
    }
}

