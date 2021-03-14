package com.balionis.kotlin15.service1

import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.ints.shouldBeExactly

class ConfigurationTest : AnnotationSpec() {
    @Test
    fun testLoad() {
        val expected = 8080
        val subject = Configuration.load()
        subject.application.port shouldBeExactly expected
    }
}
