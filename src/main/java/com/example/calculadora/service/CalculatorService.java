package com.example.calculadora.service;

import com.example.calculadora.model.Operacion;
import com.example.calculadora.repository.OperacionRepository;
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalculatorService {

    @Autowired
    private OperacionRepository operacionRepository;

    public double sumar(double a, double b) {
        Operacion operacion = new Operacion("suma", a, b, a + b);
        operacionRepository.save(operacion);
        return a + b;
    }

    public double restar(double a, double b) {
        Operacion operacion = new Operacion("resta", a, b, a - b);
        operacionRepository.save(operacion);
        return a - b;
    }

    public double multiplicar(double a, double b) {
        Operacion operacion = new Operacion("multiplicacion", a, b, a * b);
        operacionRepository.save(operacion);
        return a * b;
    }

    public double dividir(double a, double b) {
        if (b == 0) throw new IllegalArgumentException("No se puede dividir por cero");
        Operacion operacion = new Operacion("division", a, b, a / b);
        operacionRepository.save(operacion);
        return a / b;
    }

    public List<Operacion> obtenerHistorial() {
        return operacionRepository.findAll();
    }

    // Evaluar expresión usando exp4j y loguear lo que está ocurriendo
    public double evaluarExpression(String input) {
        try {
            System.out.println("Expresión recibida: " + input);  // Log para ver qué recibe el backend
            Expression e = new ExpressionBuilder(input).build();
            return e.evaluate();
        } catch (Exception e) {
            System.out.println("Error al evaluar la expresión: " + e.getMessage());  // Log del error
            throw new IllegalArgumentException("Error al evaluar la expresión: " + input + ". Detalles: " + e.getMessage());
        }
    }
}
