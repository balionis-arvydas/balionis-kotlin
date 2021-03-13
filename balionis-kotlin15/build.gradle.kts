import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

allprojects {
    repositories {
        jcenter()
    }
}

plugins {
    kotlin("jvm") version "1.4.10"
    kotlin("kapt") version "1.4.10"

    id("org.jlleitschuh.gradle.ktlint") version "9.4.1"
}

val kotlinProjects = setOf(
    "common",
    "service1"
)

subprojects {
    val projectName = "${this.rootProject.name}-${this.project.name}"
    extra["dockerImage"] = projectName

    if (kotlinProjects.contains(this.project.name)) {
        apply {
            plugin("kotlin")
            plugin("kotlin-kapt")
            plugin("org.jlleitschuh.gradle.ktlint")
        }

        ktlint {
            enableExperimentalRules.set(true)
        }
    }

    tasks.withType<KotlinCompile> {
        kotlinOptions.jvmTarget = "11"
    }
}
