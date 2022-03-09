package com.generation.MinhaPrimeiraAplicacao.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/atividade1")
public class Mentalidades {
	@GetMapping
	public String ola() {
		return "<h1>Mentalidades que usei para realizar essa tarefa: </h1>"
				+ "<h2>Persistência</h2><h2>Orientação aos detalhes</h2>";
	}
}
