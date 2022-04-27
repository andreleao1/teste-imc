package br.com.confidencecambio.javabasico.service;

import org.springframework.stereotype.Service;

import br.com.confidencecambio.javabasico.service.iterfaces.CalculadoraService;

@Service
public class CalculadoraServiceImpl implements CalculadoraService {

	@Override
	public Double calcularImc(Double peso, Double altura) {
		try {
			return peso / Math.pow(altura, 2);
		} catch (NullPointerException e) {
			throw new NullPointerException(e.getMessage());
		}
	}
}
