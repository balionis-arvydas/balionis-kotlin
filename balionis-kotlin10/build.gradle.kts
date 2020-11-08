import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	kotlin("jvm") version "1.3.72"
	kotlin("plugin.spring") version "1.3.72"
	id("org.springframework.boot") version "2.3.5.RELEASE"
	id("io.spring.dependency-management") version "1.0.10.RELEASE"
	id("com.palantir.docker") version "0.25.0"
	id("com.palantir.docker-compose") version "0.25.0"
}

// group = "com.balionis"
// version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

	implementation("io.github.microutils:kotlin-logging:1.11.5")
	implementation("ch.qos.logback:logback-classic:1.2.3")

	testImplementation("org.springframework.boot:spring-boot-starter-test") {
		exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
		exclude(module = "junit")
		exclude(module = "mockito-core")
	}
	testImplementation("org.junit.jupiter:junit-jupiter-api")
	testImplementation("com.ninja-squad:springmockk:1.1.3")
	testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")

	implementation("org.camunda.bpm.springboot:camunda-bpm-spring-boot-starter:7.14.0")
	implementation("org.camunda.bpm.springboot:camunda-bpm-spring-boot-starter-rest:7.14.0")
	implementation("org.camunda.bpm.springboot:camunda-bpm-spring-boot-starter-webapp:7.14.0")

	implementation("com.h2database:h2")
	implementation("com.sun.activation:javax.activation:1.2.0")
	implementation("javax.xml.bind:jaxb-api:2.3.0")
	implementation("com.sun.xml.bind:jaxb-core:2.3.0")
	implementation("com.sun.xml.bind:jaxb-impl:2.3.0")

}

tasks.withType<Test> {
	useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "11"
	}
}

docker {
	name = this.project.name
	copySpec.from("build/libs")
}
