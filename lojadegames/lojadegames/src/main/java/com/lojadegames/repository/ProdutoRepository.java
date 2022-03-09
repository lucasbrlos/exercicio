package com.lojadegames.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lojadegames.model.Produto;

@Repository
public interface ProdutoRepository
	extends JpaRepository<Produto, Long> {
	
	public Optional<Produto> findByNomeIgnoreCase(String nome);
}
