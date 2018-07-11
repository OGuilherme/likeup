package br.com.likeup.dao;

import java.util.List;

import br.com.likeup.entity.FuncionalidadeEntity;

public interface FuncionalidadeDAO extends GenericDAO<FuncionalidadeEntity> {

	List<FuncionalidadeEntity> findBySistemaIdOrderByNomeFuncionalidadeAsc(int id);

	FuncionalidadeEntity findByNomeFuncionalidadeAndSistemaId(String nome, int id);
}
