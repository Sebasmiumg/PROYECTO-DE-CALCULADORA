package com.example.calculadora.service;

import com.example.calculadora.repository.OperacionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorServiceTest {

    @Mock
    private OperacionRepository operacionRepository;  // Simulamos el repositorio

    @InjectMocks
    private CalculatorService calculatorService;  // Inyectamos el mock en el servicio

    @BeforeEach
    public void setUp() {
        // Usar openMocks en lugar de initMocks
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSumar() {
        double resultado = calculatorService.sumar(2, 3);
        assertEquals(5, resultado, "La suma de 2 + 3 debe ser 5");
    }

    @Test
    public void testRestar() {
        double resultado = calculatorService.restar(5, 2);
        assertEquals(3, resultado, "La resta de 5 - 2 debe ser 3");
    }

    @Test
    public void testMultiplicar() {
        double resultado = calculatorService.multiplicar(4, 3);
        assertEquals(12, resultado, "La multiplicación de 4 * 3 debe ser 12");
    }

    @Test
    public void testDividir() {
        double resultado = calculatorService.dividir(10, 2);
        assertEquals(5, resultado, "La división de 10 / 2 debe ser 5");
    }

    @Test
    public void testDividirPorCero() {
        try {
            calculatorService.dividir(10, 0);
        } catch (IllegalArgumentException e) {
            assertEquals("No se puede dividir por cero", e.getMessage());
        }
    }
}
