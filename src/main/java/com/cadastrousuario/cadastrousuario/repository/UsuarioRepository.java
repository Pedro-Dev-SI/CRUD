package com.cadastrousuario.cadastrousuario.repository;

import org.springframework.data.repository.CrudRepository;

import com.cadastrousuario.cadastrousuario.models.Cargo;
import com.cadastrousuario.cadastrousuario.models.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, String>{
	Iterable<Usuario> findByCargo(Cargo cargo);
}
