package com.astrokids.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

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
public class Familia {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idFamilia;
	private String nomeFamilia;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="USUARIO_CARTAO", joinColumns = @JoinColumn(name = "FAMILIA_ID"), inverseJoinColumns = @JoinColumn(name = "CARTAO_ID"))
	private Set<Cartao> cartoes;
}
