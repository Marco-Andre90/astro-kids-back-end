package com.astrokids.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.astrokids.model.Cartao;

@RepositoryRestResource
public interface CartaoRepository extends JpaRepository<Cartao, Long> {

}