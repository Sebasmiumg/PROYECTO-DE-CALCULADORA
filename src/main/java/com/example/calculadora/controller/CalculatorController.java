package com.example.calculadora.controller;

import com.example.calculadora.service.CalculatorService;
import com.example.calculadora.model.Operacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/calculadora")
public class CalculatorController {

    @Autowired
    private CalculatorService calculatorService;

    @GetMapping("/sumar")
    public ResponseEntity<Double> sumar(@RequestParam("a") double a, @RequestParam("b") double b) {
        return ResponseEntity.ok(calculatorService.sumar(a, b));
    }

    @GetMapping("/restar")
    public ResponseEntity<Double> restar(@RequestParam("a") double a, @RequestParam("b") double b) {
        return ResponseEntity.ok(calculatorService.restar(a, b));
    }

    @GetMapping("/multiplicar")
    public ResponseEntity<Double> multiplicar(@RequestParam("a") double a, @RequestParam("b") double b) {
        return ResponseEntity.ok(calculatorService.multiplicar(a, b));
    }

    @GetMapping("/dividir")
    public ResponseEntity<Double> dividir(@RequestParam("a") double a, @RequestParam("b") double b) {
        return ResponseEntity.ok(calculatorService.dividir(a, b));
    }

    @GetMapping("/historial")
    public ResponseEntity<List<Operacion>> obtenerHistorial() {
        return ResponseEntity.ok(calculatorService.obtenerHistorial());
    }

    @GetMapping("/calcular")
    public ResponseEntity<String> calcular(@RequestParam("input") String input) {
        try {
            double resultado = calculatorService.evaluarExpression(input);
            return ResponseEntity.ok(String.valueOf(resultado));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error en la expresión: " + e.getMessage());
        }
    }
}
