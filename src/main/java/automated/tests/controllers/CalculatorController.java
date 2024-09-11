package automated.tests.controllers;

import automated.tests.services.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/calculator")
public class CalculatorController {
    @Autowired
    private CalculatorService calculaService;

    @PostMapping("/sum")
    public ResponseEntity<Integer> sum(@RequestBody List<Integer> numeros) {
        try {
            int soma = calculaService.soma(numeros);
            return new ResponseEntity<>(soma, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/average")
    public ResponseEntity<Double> average(@RequestBody List<Integer> numeros) {
        try {
            double media = calculaService.media(numeros);
            return new ResponseEntity<>(media, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/max-min")
    public ResponseEntity<String> maxmin(@RequestBody List<Integer> numeros) {
        try {
            int maior = calculaService.encontrarMaior(numeros);
            int menor = calculaService.encontrarMenor(numeros);
            return ResponseEntity.ok("Maior: " + maior + ", Menor: " + menor);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}
