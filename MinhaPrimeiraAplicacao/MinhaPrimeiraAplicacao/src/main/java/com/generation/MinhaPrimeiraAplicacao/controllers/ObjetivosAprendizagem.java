package com.generation.MinhaPrimeiraAplicacao.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

@RequestMapping("/atividade2")
public class ObjetivosAprendizagem {
	@GetMapping
	public String objetivos() {
		return "<h1>Objetivos para a semana</h1>"
				+ "<ul>"
				+ "<li><h2>Aprender mais sobre Spring Boot</h2></li>"
				+ "<li><h2>Apronfundar conhecimentos no Java</h2></li>"
				+ "<li><h2>Criar outras aplicações com o Spring Boot</h2></li>"
				+ "<li><h2>Criar design blog pessoal</h2></li>"
				+ "</ul>";
	}
}
