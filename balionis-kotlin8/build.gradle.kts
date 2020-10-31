allprojects {
    repositories {
        mavenCentral()
    }
}

plugins {
    application
    kotlin("jvm") version "1.4.10"
    kotlin("kapt") version "1.4.10"
}

val kotlinProjects = setOf(
    "client",
    "server"
)

subprojects {
    if (kotlinProjects.contains(this.project.name)) {
        apply(plugin = "kotlin")
        apply(plugin = "kotlin-kapt")
    }    
}

