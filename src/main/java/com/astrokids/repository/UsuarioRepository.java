package com.astrokids.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.astrokids.model.Usuario;

@RepositoryRestResource
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
