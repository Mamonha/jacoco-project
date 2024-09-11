package automated.tests;

import automated.tests.controllers.CalculatorController;
import automated.tests.services.CalculatorService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class CalculatorControllerTest {

    @InjectMocks
    private CalculatorController calculatorController;

    @Mock
    private CalculatorService calculatorService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSum() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        int expectedSum = 15;
        when(calculatorService.soma(numbers)).thenReturn(expectedSum);
        ResponseEntity<Integer> response = calculatorController.sum(numbers);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expectedSum, response.getBody());
    }

    @Test
    public void testSumWhenExceptionThrown() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        when(calculatorService.soma(numbers)).thenThrow(new IllegalArgumentException("Invalid input"));
        ResponseEntity<Integer> response = calculatorController.sum(numbers);
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals(null, response.getBody());
    }

    @Test
    public void testAverage() {
        List<Integer> numbers = Arrays.asList(10, 20, 30, 40, 50);
        double expectedAverage = 30.0;
        when(calculatorService.media(numbers)).thenReturn(expectedAverage);
        ResponseEntity<Double> response = calculatorController.average(numbers);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expectedAverage, response.getBody());
    }

    @Test
    public void testAverageWhenExceptionThrown() {
        List<Integer> numbers = Arrays.asList(10, 20, 30, 40, 50);
        when(calculatorService.media(numbers)).thenThrow(new IllegalArgumentException("Invalid input"));
        ResponseEntity<Double> response = calculatorController.average(numbers);
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals(null, response.getBody());
    }

    @Test
    public void testMaxMin() {
        List<Integer> numbers = Arrays.asList(7, 2, 8, 3, 9);
        int expectedMax = 9;
        int expectedMin = 2;

        when(calculatorService.encontrarMaior(numbers)).thenReturn(expectedMax);
        when(calculatorService.encontrarMenor(numbers)).thenReturn(expectedMin);

        ResponseEntity<String> response = calculatorController.maxmin(numbers);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Maior: " + expectedMax + ", Menor: " + expectedMin, response.getBody());
    }

    @Test
    public void testMaxMinWhenExceptionThrown() {
        List<Integer> numbers = Arrays.asList(7, 2, 8, 3, 9);
        when(calculatorService.encontrarMaior(numbers)).thenThrow(new IllegalArgumentException("Invalid input"));
        when(calculatorService.encontrarMenor(numbers)).thenThrow(new IllegalArgumentException("Invalid input"));

        ResponseEntity<String> response = calculatorController.maxmin(numbers);
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals(null, response.getBody());
    }
}
