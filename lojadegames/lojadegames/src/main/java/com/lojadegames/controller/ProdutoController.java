package com.lojadegames.controller;

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

import com.lojadegames.model.Produto;
import com.lojadegames.repository.ProdutoRepository;

@RestController
@RequestMapping("/games")
public class ProdutoController {
	
	private ProdutoRepository repository;
	
	@Autowired
	public void setRepository(ProdutoRepository repository) {
		this.repository = repository;
	}
	
	@GetMapping("/listar")
	public List<Produto> findAllProduto() {
		return repository.findAll();
	}
	
	@GetMapping("/id/{id}")
	public ResponseEntity<Produto> findByIdProduto(@PathVariable long id) {
		return repository.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/nome/{nome}")
	public ResponseEntity<Produto> findByDescricaoTitulo(@PathVariable String nome) {
		return repository.findByNomeIgnoreCase(nome)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public ResponseEntity<Produto> postProduto(@RequestBody Produto produto) {
		String nome = produto.getNome();
		return repository.findByNomeIgnoreCase(nome)
				.map(resp -> ResponseEntity.status(HttpStatus.CONFLICT).body(produto))
				.orElseGet(() -> ResponseEntity.status(HttpStatus.CREATED).body(repository.save(produto)));
	}
	
	@PutMapping
	public ResponseEntity<Produto> putProduto(@RequestBody Produto produto) {
		return repository.findById(produto.getId())
				.map(resp -> ResponseEntity.status(HttpStatus.ACCEPTED).body(repository.save(produto)))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@DeleteMapping("/{id}")
	public void deleteProduto(@PathVariable long id) {
		repository.deleteById(id);
	}
}
