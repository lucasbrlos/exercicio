package com.farmacia.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.farmacia.model.Categoria;

public interface CategoriaRepository
	extends JpaRepository<Categoria, Long> {
	
	@Query(value="SELECT * FROM categoria WHERE tipo = ?1 AND precisa_receita = ?2",
			nativeQuery=true)
	public Optional<Categoria> findByTipoContainingIgnoreCase(String tipo, boolean receita);
	
	public List<Categoria> findByDescricaoContainingIgnoreCase(String descricao);
}
