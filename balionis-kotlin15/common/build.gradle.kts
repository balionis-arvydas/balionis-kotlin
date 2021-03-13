dependencies {
    implementation(kotlin("stdlib-jdk8"))

    implementation(Libs.MOSHI)
    implementation(Libs.JACKSON_DATABIND)

    testImplementation(Libs.JUNIT)
    testImplementation(kotlin("test-junit"))

    kapt(Libs.MOSHI_KOTLIN_CODEGEN)
}
