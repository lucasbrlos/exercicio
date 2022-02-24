package com.lojadegames.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lojadegames.model.Categoria;

@Repository
public interface CategoriaRepository 
	extends JpaRepository<Categoria, Long> {
	
	public Optional<Categoria> findByDescricaoIgnoreCase(String categoria);
}
