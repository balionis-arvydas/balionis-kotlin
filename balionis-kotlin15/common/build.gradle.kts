dependencies {
    implementation(kotlin("stdlib-jdk8"))

    implementation("com.squareup.moshi:moshi:1.9.3")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.11.2")

    testImplementation("junit:junit:4.11")
    testImplementation(kotlin("test-junit"))

    kapt("com.squareup.moshi:moshi-kotlin-codegen:1.9.3")
}
