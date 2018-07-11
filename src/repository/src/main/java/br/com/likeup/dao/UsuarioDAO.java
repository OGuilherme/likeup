package br.com.likeup.dao;

import java.util.Optional;

import br.com.likeup.entity.UsuarioEntity;

public interface UsuarioDAO extends GenericDAO<UsuarioEntity> {

	Optional<UsuarioEntity> findByUsuario(String usuario);

	UsuarioEntity findByFuncionarioId(int id);
}