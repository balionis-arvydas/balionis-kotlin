dependencies {
    implementation(kotlin("stdlib-jdk8"))

    implementation(Libs.MOSHI)
    implementation(Libs.JACKSON_DATABIND)

    testImplementation(Libs.KOTEST_RONNER_JUNIT5)
    testImplementation(Libs.KOTEST_ASSERTIONS_CORE)
    testImplementation(kotlin("test-junit"))

    kapt(Libs.MOSHI_KOTLIN_CODEGEN)
}
