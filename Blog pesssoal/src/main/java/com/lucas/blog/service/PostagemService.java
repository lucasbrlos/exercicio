package com.leodsc.blog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.leodsc.blog.model.Postagem;
import com.leodsc.blog.repository.PostagemRepository;

@Service
public class PostagemService {
	
	private final PostagemRepository postagemRepository;
	
	@Autowired
	PostagemService(PostagemRepository postagemRepository) {
		this.postagemRepository = postagemRepository;
	}
	
	public ResponseEntity<List<Postagem>> getAll() {
		return ResponseEntity.ok(postagemRepository.findAll());
	}
	
	public ResponseEntity<ResponseEntity<Postagem>> findById(long id) {
		return ResponseEntity.ok(postagemRepository.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build()));
	}

//	public List<Postagem> getPostagem() {
//		return List.of(new Postagem(
//				"Minha primeira postagem",
//				"Lorem ipsum lorem ipsym lorem"
//				)); 
//	}
}
