package br.com.likeup.dao;

import java.util.List;

import br.com.likeup.entity.PerfilEntity;

public interface PerfilDAO extends GenericDAO<PerfilEntity> {

	List<PerfilEntity> findBySistemaIdOrderByNomeAsc(int id);

}