package com.leodsc.blog.service;

import java.nio.charset.Charset;
import java.util.Optional;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.leodsc.blog.model.Usuario;
import com.leodsc.blog.model.UsuarioLogin;
import com.leodsc.blog.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	public Optional<Usuario> cadastrarUsuario(Usuario usuario){
		if (usuarioRepository.findByUsername(usuario.getUsername()).isPresent())
			return Optional.empty();
		
		usuario.setPassword(criptografarSenha(usuario.getPassword()));

		return Optional.of(usuarioRepository.save(usuario));
	}
	
	
	public Optional<UsuarioLogin> autenticarUsuario(Optional<UsuarioLogin> usuarioLogin){
		
		Optional<Usuario> usuario = usuarioRepository.findByUsername(usuarioLogin.get().getUsername());
		
		if(usuario.isPresent()) {
			
			usuarioLogin.get().setId(usuario.get().getId());
			usuarioLogin.get().setToken(gerarBasicToken(usuarioLogin.get().getUsername(), usuario.get().getPassword()));
			usuarioLogin.get().setPassword(usuario.get().getPassword());
			
			return usuarioLogin;
		}
		
		return Optional.empty();
		
	}
	
	
	
	private String criptografarSenha(String senha) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder.encode(senha);
	}
	
	private boolean compararSenhas(String senhaDigitada, String senhaBanco) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder.matches(senhaDigitada, senhaBanco);
	}
	
	private String gerarBasicToken(String usuario, String senha) {

		String token = usuario + ":" + senha;
		byte[] tokenBase64 = Base64.encodeBase64(token.getBytes(Charset.forName("US-ASCII")));
		return "Basic " + new String(tokenBase64);

	}
	
}