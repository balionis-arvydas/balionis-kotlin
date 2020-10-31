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
    "client"
)

subprojects {
    apply(plugin = "kotlin")

    if (kotlinProjects.contains(this.project.name)) {
        apply(plugin = "kotlin-kapt")
    }    
}

