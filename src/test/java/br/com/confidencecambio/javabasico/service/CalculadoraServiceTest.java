package br.com.confidencecambio.javabasico.service;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.com.confidencecambio.javabasico.service.iterfaces.CalculadoraService;

public class CalculadoraServiceTest {

	private CalculadoraService calculadoraService;
	
	@BeforeEach
	public void setup() {
		calculadoraService = new CalculadoraServiceImpl();
	}
	
	@Test
	@DisplayName("Calcular IMC")
	public void deveRetornarOImcCalculadoQuandoOsParametrosCorretosForamPassados() {
		Double peso = 80.0;
		Double altura = 1.73;
		Double imc = (peso / Math.pow(altura, 2));

		Double resultado = this.calculadoraService.calcularImc(peso, altura);

		assertEquals(imc, resultado);
	}
	
	@Test 
	@DisplayName("Passando peso nulo")
	public void deveLancarExcecaoQaundoPassarPesoNull() {
		Double peso = null;
		Double altura = 1.73;
		
		Assertions.assertThrows(NullPointerException.class, () -> {
			this.calculadoraService.calcularImc(peso, altura);
		});
	}
	
	@Test 
	@DisplayName("Passando altura nula")
	public void deveLancarExcecaoQaundoPassarAlturaNull() {
		Double peso = 80.0;
		Double altura = null;
		
		Assertions.assertThrows(NullPointerException.class, () -> {
			this.calculadoraService.calcularImc(peso, altura);
		});
	}
}
