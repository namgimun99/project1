package com.project.project1.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
class MainControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @WithMockUser // 인증된 사용자 정보로 테스트
    void mainTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/main"))
                .andDo(print()) // request - response 정보 출력
                .andExpect(status().isOk()) // 200 이어야함
                .andExpect(content().string("hi")) // response 내용이 'hi' 만 성공
                ;
    }
}