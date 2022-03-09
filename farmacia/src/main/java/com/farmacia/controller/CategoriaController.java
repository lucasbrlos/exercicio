package com.farmacia.controller;

import java.util.List;

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

import com.farmacia.model.Categoria;
import com.farmacia.repository.CategoriaRepository;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {
	
	private CategoriaRepository repository;
	
	@Autowired
	public void setCategoria(CategoriaRepository repository) {
		this.repository = repository;
	}
	
	@GetMapping
	public List<Categoria> findAllCategoria() {
		return repository.findAll();
	}
	
	@GetMapping("/id/{id}")
	public List<Categoria> findByIdCategoria(@PathVariable long id) {
		return repository.findById(id)
				.map(resp -> List.of(resp))
				.orElse(null);
	}
	
	@GetMapping("/descricao/{descricao}")
	public List<Categoria> findByDescricaoCategoria(@PathVariable String descricao) {
		return repository.findByDescricaoContainingIgnoreCase(descricao);
	}
	
	@PostMapping
	public ResponseEntity<Categoria> post(@RequestBody Categoria categoria) {
		return repository.findByTipoContainingIgnoreCase(categoria.getTipo(), categoria.getPrecisaReceita())
				.map(resp -> ResponseEntity.status(HttpStatus.CONFLICT).body(categoria))
				.orElseGet(() -> ResponseEntity.status(HttpStatus.CREATED).body(repository.save(categoria)));
	}
	
	@PutMapping ResponseEntity<Categoria> update(@RequestBody Categoria categoria) {
		return repository.findById(categoria.getId())
				.map(resp -> ResponseEntity.status(HttpStatus.ACCEPTED).body(repository.save(categoria)))
				.orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
	}

	@DeleteMapping
	public HttpStatus delete(@RequestBody Categoria categoria) { 
		long categoriaId = categoria.getId();
		repository.deleteById(categoriaId);
		return HttpStatus.ACCEPTED;
	}
}
