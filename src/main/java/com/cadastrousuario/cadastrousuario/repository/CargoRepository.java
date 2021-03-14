package com.cadastrousuario.cadastrousuario.repository;

import org.springframework.data.repository.CrudRepository;

import com.cadastrousuario.cadastrousuario.models.Cargo;

public interface CargoRepository extends CrudRepository<Cargo, String>{
	Cargo findByCodigo(long codigo);
}
