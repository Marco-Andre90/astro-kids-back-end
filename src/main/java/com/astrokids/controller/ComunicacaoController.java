package com.astrokids.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.astrokids.model.Cartao;
import com.astrokids.repository.CartaoRepository;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin(origins = "*")
public class ComunicacaoController {

	@Autowired
	CartaoRepository cartaoRepository;

	@GetMapping("/cartoes")
	public List<Cartao> listarCartoes() {
		List<Cartao> cartoes = cartaoRepository.findAll();
		return cartoes;
	}
	
	@GetMapping("/cartoes/{id}")
	public Optional<Cartao> buscarCartaoPorId(@PathVariable(value="id") Long id) {
		return cartaoRepository.findById(id);
	}
}
