package automated.tests;

import automated.tests.services.CalculatorService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class CalculatorServiceTest {

    private CalculatorService calculatorService;

    @BeforeEach
    public void setUp() {
        calculatorService = new CalculatorService();
    }

    @Test
    public void testSoma() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        int expectedSum = 15;
        int result = calculatorService.soma(numbers);
        assertEquals(expectedSum, result);
    }

    @Test
    public void testSomaWhenListIsEmpty() {
        List<Integer> numbers = Collections.emptyList();
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            calculatorService.soma(numbers);
        });
        assertEquals("A lista de números não pode ser nula ou vazia.", thrown.getMessage());
    }

    @Test
    public void testSomaWhenListIsNull() {
        List<Integer> numbers = null;
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            calculatorService.soma(numbers);
        });
        assertEquals("A lista de números não pode ser nula ou vazia.", thrown.getMessage());
    }

    @Test
    public void testMedia() {
        List<Integer> numbers = Arrays.asList(10, 20, 30, 40, 50);
        double expectedAverage = 30.0;
        double result = calculatorService.media(numbers);
        assertEquals(expectedAverage, result);
    }

    @Test
    public void testMediaWhenListIsEmpty() {
        List<Integer> numbers = Collections.emptyList();
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            calculatorService.media(numbers);
        });
        assertEquals("A lista de números não pode ser nula ou vazia.", thrown.getMessage());
    }

    @Test
    public void testMediaWhenListIsNull() {
        List<Integer> numbers = null;
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            calculatorService.media(numbers);
        });
        assertEquals("A lista de números não pode ser nula ou vazia.", thrown.getMessage());
    }

    @Test
    public void testEncontrarMaior() {
        List<Integer> numbers = Arrays.asList(7, 2, 8, 3, 9);
        int expectedMax = 9;
        int result = calculatorService.encontrarMaior(numbers);
        assertEquals(expectedMax, result);
    }

    @Test
    public void testEncontrarMaiorWhenListIsEmpty() {
        List<Integer> numbers = Collections.emptyList();
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            calculatorService.encontrarMaior(numbers);
        });
        assertEquals("A lista de números não pode ser nula ou vazia.", thrown.getMessage());
    }

    @Test
    public void testEncontrarMaiorWhenListIsNull() {
        List<Integer> numbers = null;
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            calculatorService.encontrarMaior(numbers);
        });
        assertEquals("A lista de números não pode ser nula ou vazia.", thrown.getMessage());
    }

    @Test
    public void testEncontrarMenor() {
        List<Integer> numbers = Arrays.asList(7, 2, 8, 3, 9);
        int expectedMin = 2;
        int result = calculatorService.encontrarMenor(numbers);
        assertEquals(expectedMin, result);
    }

    @Test
    public void testEncontrarMenorWhenListIsEmpty() {
        List<Integer> numbers = Collections.emptyList();
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            calculatorService.encontrarMenor(numbers);
        });
        assertEquals("A lista de números não pode ser nula ou vazia.", thrown.getMessage());
    }

    @Test
    public void testEncontrarMenorWhenListIsNull() {
        List<Integer> numbers = null;
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            calculatorService.encontrarMenor(numbers);
        });
        assertEquals("A lista de números não pode ser nula ou vazia.", thrown.getMessage());
    }
}
