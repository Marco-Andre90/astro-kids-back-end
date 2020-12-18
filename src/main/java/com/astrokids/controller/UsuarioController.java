package com.astrokids.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.astrokids.model.Familia;
import com.astrokids.model.Usuario;
import com.astrokids.repository.FamiliaRepository;
import com.astrokids.repository.UsuarioRepository;
import com.astrokids.vo.DominioVO;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin(origins = "*")
public class UsuarioController {
	
	Usuario usuario;
	Familia familia;
	
	@Autowired
	UsuarioRepository usuarioRepository;
	@Autowired
	FamiliaRepository familiaRepository;

	@PostMapping("/familia")
	public Familia cadastrarFamilia ( @RequestBody Familia familia ) {
		this.familia = new Familia();
		this.familia = familiaRepository.save(familia);
		return this.familia;
	}
	
	@PostMapping("/usuario")
	public Usuario cadastrarUsuario ( @RequestBody Usuario usuario ) {
		if (this.familia != null) {
			Optional<Familia> familia = familiaRepository.findById(this.familia.getIdFamilia());
			usuario.setFamilia(familia.get());
		}
		System.out.println("Na segunda vez"+this.familia);
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
	
	@PostMapping("/login")
	public Usuario validarLogin(@RequestBody DominioVO dominio) {
		System.out.println(dominio.getUsuario()+ " "+dominio.getSenha());
		Usuario usuarioEdit = usuarioRepository.buscarUsuario(dominio.getUsuario());
		if(null == usuarioEdit) {
			return null;
		} 
		if(!usuarioEdit.getSenha().equals(dominio.getSenha())) {
			return null;
		}
		return usuarioEdit;
	}
}