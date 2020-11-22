package com.balionis.kotlin13.bundle

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*

@WebMvcTest
class MyControllerTest(@Autowired val mockMvc: MockMvc) {
    @Test
    fun `has engine`() {
        mockMvc.perform(get("/bundle/echo").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk)
                .andExpect(content().string("Hello, Engine!"))
    }
}
