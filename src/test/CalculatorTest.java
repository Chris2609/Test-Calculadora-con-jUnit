package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeout;

import java.time.Duration;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import clases.Calculator;

class CalculatorTest {

	private static Calculator calc;
	
	@BeforeEach
	public void setUp() {
		calc = new Calculator();
	}
	
	/*Fase 1*/
	@Test
	void testAdd() {
		int resultado = calc.add(2, 2);
		assertEquals(4, resultado);
	}

	@Test
	void testSubtract() {
		int resultado = calc.subtract(5, 2);
		assertEquals(3, resultado);
	}

	@Test
	void testMultiply() {
		int resultado = calc.multiply(3, 2);
		assertEquals(6, resultado);
	}

	@Test
	void testDivide() {
		double resultado = calc.divide(6, 2);
		assertEquals(3, resultado);
	}
	
	/*Fase 2*/
	@ParameterizedTest
	@DisplayName("Suma parametrizada")
	@CsvSource({"2, 3, 5", "-1, 5, 4", "0, 0, 0"})
	void testAddParametizedCsvsource(int valor1, int valor2, int esperado) {
		int resultado = calc.add(valor1, valor2);
		assertEquals(resultado, esperado);
	}
	
	@ParameterizedTest
	@DisplayName("Resta parametrizada")
	@CsvSource({"10, 5, 5", "8, 6, 2", "9, 5, 4"})
	void testSubtractParametizedCsvsource(int valor1, int valor2, int esperado) {
		int resultado = calc.subtract(valor1, valor2);
		assertEquals(resultado, esperado);
	}
	
	@ParameterizedTest
	@DisplayName("Multiplicacion parametrizada")
	@CsvSource({"8, 3, 24", "6, 5, 30", "4, 3, 12"})
	void testMultiplyParametizedCsvsource(int valor1, int valor2, int esperado) {
		int resultado = calc.multiply(valor1, valor2);
		assertEquals(resultado, esperado);
	}
	
	@ParameterizedTest
	@DisplayName("Division parametrizada")
	@CsvSource({"6, 2, 3", "10, 2, 5", "33, 11, 3"})
	void testDivideParametizedCsvsource(int valor1, int valor2, int esperado) {
		double resultado = calc.divide(valor1, valor2);
		assertEquals(resultado, esperado);
	}
	
	/*Fase 3*/
	@ParameterizedTest
	@DisplayName("Suma parametrizada csv file")
	@CsvFileSource(resources = "datos.csv")
	void testAddParametizedCsvFileSource(int valor1, int valor2, int esperado) {
		double resultado = calc.add(valor1, valor2);
		assertEquals(resultado, esperado);
	}
	
	@ParameterizedTest
	@DisplayName("Resta parametrizada csv file")
	@CsvFileSource(resources = "datosR.csv")
	void testSubtractParametizedCsvFileSource(int valor1, int valor2, int esperado) {
		double resultado = calc.subtract(valor1, valor2);
		assertEquals(resultado, esperado);
	}
	
	@ParameterizedTest
	@DisplayName("Multiplicacion parametrizada csv file")
	@CsvFileSource(resources = "datosM.csv")
	void testMultiplyParametizedCsvFileSource(int valor1, int valor2, int esperado) {
		double resultado = calc.multiply(valor1, valor2);
		assertEquals(resultado, esperado);
	}
	
	@ParameterizedTest
	@DisplayName("Division parametrizada csv file")
	@CsvFileSource(resources = "datosD.csv")
	void testDivideParametizedCsvFileSource(int valor1, int valor2, int esperado) {
		double resultado = calc.divide(valor1, valor2);
		assertEquals(resultado, esperado);
	}
	
	/*Fase 4*/
	@Test
	@DisplayName("Divisor cero ERROR")
	void testDivisorCero() {
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> {
			calc.divide(5, 0);
		});
	}
	
	/*Fase 5*/
	@Test
	@DisplayName("AssertTimeout")
	public void testTiempoEjecuccion() {
        assertTimeout(Duration.ofSeconds(4), () -> {
            Thread.sleep(3000); //Si el tiempo de ejecuccion es menor a 4 segundos, funcionara correctamente
        });
	}
	
}
