package com.farmacia.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.farmacia.model.Produto;

public interface ProdutoRepository 
	extends JpaRepository<Produto, Long> {

	@Query(value="SELECT * FROM produto WHERE nome = ?1",
			nativeQuery=true)
	public Optional<Produto> findByNome(String nome);

	@Query(value="SELECT * FROM produto WHERE descricao = ?1",
			nativeQuery=true)
	public Optional<Produto> findByDescricao(String descricao);

}
