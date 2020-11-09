package com.balionis.kotlin11

import org.activiti.spring.boot.SecurityAutoConfiguration
import org.hamcrest.Matchers.hasSize
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.MediaType
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*

@WebMvcTest
@EnableAutoConfiguration(exclude = [SecurityAutoConfiguration::class])
class MyControllerTest(@Autowired val mockMvc: MockMvc) {

    @Test
    fun `find all`() {
        mockMvc.perform(
                get("/api/records")
                        .with(user("admin").password("1234").roles("USER", "ADMIN"))
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk)
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("\$.*", hasSize<List<String>>(0)))
    }

    @Test
    fun `find 123`() {
        mockMvc.perform(
                get("/api/records/123")
                        .with(user("admin").password("1234").roles("USER", "ADMIN"))
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk)
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("\$.payload").value("123"))
    }
}
