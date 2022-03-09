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

import com.farmacia.model.Produto;
import com.farmacia.repository.ProdutoRepository;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
	
	private ProdutoRepository repository;
	
	@Autowired
	public void setRepository(ProdutoRepository repository) {
		this.repository = repository;
	}
	
	@GetMapping
	public List<Produto> findAllProduto() {
		return repository.findAll();
	}
	
	@GetMapping("id/{id}")
	public Produto findByIdProduto(@PathVariable long id) {
		return repository.findById(id)
				.map(resp -> resp)
				.orElse(null);
	}
	
	@GetMapping("/descricao/{descricao}")
	public ResponseEntity<Produto> findByDescricaoProduto(@PathVariable String descricao) {
		return repository.findByDescricao(descricao)
				.map(resp -> ResponseEntity.status(HttpStatus.ACCEPTED).body(resp))
				.orElse(null);
	}
	
	@PutMapping
	public ResponseEntity<Produto> putProduto(@RequestBody Produto produto) {
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(repository.save(produto));
	}
		
	@PostMapping
	public ResponseEntity<Produto> postProduto (@RequestBody Produto produto) {
		String nome = produto.getNome();
		return repository.findByNome(nome)
				.map(resp -> ResponseEntity.status(HttpStatus.CONFLICT).body(produto))
				.orElseGet(() -> ResponseEntity.status(HttpStatus.CREATED).body(repository.save(produto)));
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteProduto (@PathVariable long id) {
		repository.deleteById(id);
	}
}
