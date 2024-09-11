package automated.tests.services;

import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CalculatorService {

    public int soma(List<Integer> numeros) {
        if (numeros == null || numeros.isEmpty()) {
            throw new IllegalArgumentException("A lista de números não pode ser nula ou vazia.");
        }
        return numeros.stream().mapToInt(Integer::intValue).sum();
    }

    public double media(List<Integer> numeros) {
        if (numeros == null || numeros.isEmpty()) {
            throw new IllegalArgumentException("A lista de números não pode ser nula ou vazia.");
        }
        return numeros.stream().mapToInt(Integer::intValue).average().orElse(0.0);
    }
    public int encontrarMaior(List<Integer> numeros) {
        if (numeros == null || numeros.isEmpty()) {
            throw new IllegalArgumentException("A lista de números não pode ser nula ou vazia.");
        }
        return numeros.stream().mapToInt(Integer::intValue).max().orElseThrow();
    }

    public int encontrarMenor(List<Integer> numeros) {
        if (numeros == null || numeros.isEmpty()) {
            throw new IllegalArgumentException("A lista de números não pode ser nula ou vazia.");
        }
        return numeros.stream().mapToInt(Integer::intValue).min().orElseThrow();
    }
}
