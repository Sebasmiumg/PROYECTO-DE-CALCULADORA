package com.example.calculadora.controller;

import com.example.calculadora.service.CalculatorService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = CalculatorController.class)
public class CalculatorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CalculatorService calculatorService;

    @Test
    public void testSumar() throws Exception {
        when(calculatorService.sumar(2, 3)).thenReturn(5.0);

        mockMvc.perform(get("/api/calculadora/sumar")
                .param("a", "2")
                .param("b", "3"))
                .andExpect(status().isOk())
                .andExpect(content().string("5.0"));
    }

    @Test
    public void testRestar() throws Exception {
        when(calculatorService.restar(5, 2)).thenReturn(3.0);

        mockMvc.perform(get("/api/calculadora/restar")
                .param("a", "5")
                .param("b", "2"))
                .andExpect(status().isOk())
                .andExpect(content().string("3.0"));
    }

    @Test
    public void testMultiplicar() throws Exception {
        when(calculatorService.multiplicar(4, 3)).thenReturn(12.0);

        mockMvc.perform(get("/api/calculadora/multiplicar")
                .param("a", "4")
                .param("b", "3"))
                .andExpect(status().isOk())
                .andExpect(content().string("12.0"));
    }

    @Test
    public void testDividir() throws Exception {
        when(calculatorService.dividir(10, 2)).thenReturn(5.0);

        mockMvc.perform(get("/api/calculadora/dividir")
                .param("a", "10")
                .param("b", "2"))
                .andExpect(status().isOk())
                .andExpect(content().string("5.0"));
    }
}
