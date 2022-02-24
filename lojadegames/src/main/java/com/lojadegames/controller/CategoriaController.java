package com.lojadegames.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lojadegames.model.Categoria;
import com.lojadegames.repository.CategoriaRepository;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {
	
	private CategoriaRepository repository;
	
	@Autowired
	public void setRepository(CategoriaRepository repository) {
		this.repository = repository;
	}

	@GetMapping("/listar")
	public List<Categoria> findAllCategoria() {
		return repository.findAll();
	}
	
	@GetMapping("/procurar/id/{id}")
	public ResponseEntity<Categoria> findByIdCategoria(@PathVariable long id) {
		return repository.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/procurar/descricao/{descricao}")
	public ResponseEntity<Categoria> findByDescricaoCategoria(@PathVariable String descricao) {
		return repository.findByDescricaoIgnoreCase(descricao)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public ResponseEntity<Categoria> postCategoria(@RequestBody Categoria categoria) {
		String descricao = categoria.getDescricao();
		return repository.findByDescricaoIgnoreCase(descricao)
				.map(resp -> ResponseEntity.status(HttpStatus.CONFLICT).body(resp))
				.orElseGet(() -> ResponseEntity.status(HttpStatus.CREATED).body(repository.save(categoria)));
	}
	
	@PutMapping
	public ResponseEntity<Categoria> putCategoria(@RequestBody Categoria categoria) {
		return ResponseEntity.ok(repository.save(categoria));
	}
	
	@DeleteMapping("/{id}")
	public void deleteCategoria(@PathVariable long id) {
		repository.deleteById(id);
	}
}
