import at.phatbl.shellexec.ShellExec
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

    implementation(Libs.CONFIG4K)

    testImplementation(Libs.JUNIT)
    testImplementation(kotlin("test-junit"))

    implementation(Libs.HTTP4K_CORE)
    implementation(Libs.HTTP4K_CLOUDNATIVE)
    implementation(Libs.HTTP4K_SERVER_JETTY)
}

application {
    mainClassName = "com.balionis.kotlin15.service1.AppKt"

    // FIXME: this does not work!
    applicationDistribution.exclude("**/logback*.xml")
}

tasks {
    val dockerImage = extra["dockerImage"]

    create<ShellExec>("dockerBuild") {
        dependsOn("build")

        description = "Build a service docker image"
        group = "Docker"
        command = "docker build -t $dockerImage:latest ."
    }

    create<ShellExec>("dockerComposeUp") {
        dependsOn("dockerBuild")

        description = "Start a service on local docker"
        group = "Docker"
        command = "docker-compose -f docker-compose.yml build && docker-compose -f docker-compose.yml up -d"
    }

    create<ShellExec>("dockerComposeDown") {
        description = "Stop a service on local docker"
        group = "Docker"
        command = "docker-compose -f docker-compose.yml down"
    }

    withType<ShadowJar> {
        mergeServiceFiles {
            // FIXME: this does not work!
            exclude("**/logback*.xml")
        }
    }
}
