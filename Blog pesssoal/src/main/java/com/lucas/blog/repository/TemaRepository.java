package com.leodsc.blog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.leodsc.blog.model.Tema;

@Repository
public interface TemaRepository 
	extends JpaRepository<Tema, Long>{
	public List<Tema> findAllByNomeContainingIgnoreCase(String nome);
}
