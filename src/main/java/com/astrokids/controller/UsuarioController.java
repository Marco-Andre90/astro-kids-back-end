package com.astrokids.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.astrokids.model.Usuario;
import com.astrokids.repository.UsuarioRepository;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin(origins = "*")
public class UsuarioController {
	
	@Autowired
	UsuarioRepository usuarioRepository;

	@PostMapping("/usuario")
	public Usuario cadastrarUsuario ( @RequestBody Usuario usuario ) {
		return usuarioRepository.save(usuario);
	}
	
	@PutMapping("/usuario")
	public Usuario atualizarUsuario(@RequestBody Usuario usuario) {
		if (null != usuario.getFamilia().getIdFamilia()) {
			return usuarioRepository.save(usuario);			
		} else {
			return null;
		}
	}
	
	@DeleteMapping("/usuario/{id}")
	public void apagarUsuario (@PathVariable(value = "id") Long id) {
		usuarioRepository.deleteById(id);
	}
}
