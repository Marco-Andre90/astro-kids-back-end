package com.astrokids.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idUsuario;
	private String userLogin;
	private String senha;
	private String tipo;
	private String nome;
	private String sobrenome;
	private Date dataNascimento;
	private String endereco;
	private String celular;
	private String email;
	
	@ManyToOne
	@JoinColumn(name = "FAMILIA_ID")
	private Familia familia;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="USUARIO_CARTAO", joinColumns = @JoinColumn(name = "USUARIO_ID"), inverseJoinColumns = @JoinColumn(name = "CARTAO_ID"))
	private Set<Cartao> cartoes;
}