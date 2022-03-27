package com.leodsc.blog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.leodsc.blog.model.Postagem;

// responsavel por acessar a base de dados
@Repository
public interface PostagemRepository 
// precisa receber qual a tabela que desejamos interagir e o id
	extends JpaRepository<Postagem, Long> {
	public List<Postagem> findAllByTituloContainingIgnoreCase(String titulo);
}
