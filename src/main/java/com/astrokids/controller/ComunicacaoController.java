package com.astrokids.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.astrokids.model.Cartao;
import com.astrokids.model.Familia;
import com.astrokids.model.Usuario;
import com.astrokids.repository.CartaoRepository;
import com.astrokids.repository.FamiliaRepository;
import com.astrokids.repository.UsuarioRepository;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin(origins = "*")
public class ComunicacaoController {

	Usuario usuario;
	Familia familia;
	Cartao cartao;
	
	@Autowired
	CartaoRepository cartaoRepository;
	@Autowired
	UsuarioRepository usuarioRepository;
	@Autowired
	FamiliaRepository familiaRepository;

	@GetMapping("/cartoes")
	public List<Cartao> listarCartoes() {
		List<Cartao> cartoes = cartaoRepository.findAll();
		return cartoes;
	}
	
	@GetMapping("/cartoes/{id}")
	public Optional<Cartao> buscarCartaoPorId(@PathVariable(value="id") Long id) {
		return cartaoRepository.findById(id);
	}
	
//	@PostMapping("/remetente")
//	public void registraRemetente ( @RequestBody Cartao cartao ) {
//		usuarioRepository.save(entity);
//	}
	
	@PostMapping("/enviar")
	public Cartao enviarCartao(@RequestBody Usuario usuario) {
		System.out.println("aaaaaa"+usuario);
		this.usuario = new Usuario();
		this.familia = new Familia();
		usuarioRepository.save(usuario);
		this.usuario = usuarioRepository.findById(usuario.getIdUsuario()).get();
		this.familia = this.usuario.getFamilia();
		this.familia.setCartoes(usuario.getCartoes());
		this.familia = familiaRepository.save(this.familia);
		
		
		return null;
	}
}
