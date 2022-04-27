package br.com.confidencecambio.javabasico.api.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.confidencecambio.javabasico.service.iterfaces.CalculadoraService;

@RestController
@RequestMapping("/calculadora")
public class CalculadoraController {
	
	@Autowired
	private CalculadoraService calculadoraService;

	@GetMapping("/calcular-imc")
	public ResponseEntity<Double> calcularImc(@RequestParam(value = "peso", required = false) Double peso, @RequestParam Double altura) {
		Double imcCalculado = this.calculadoraService.calcularImc(peso, altura);
		return ResponseEntity.ok(imcCalculado);
	}
}
