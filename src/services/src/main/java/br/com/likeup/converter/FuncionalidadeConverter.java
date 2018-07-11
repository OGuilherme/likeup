package br.com.likeup.converter;

import org.springframework.stereotype.Component;

import br.com.likeup.bean.FuncionalidadeBean;
import br.com.likeup.entity.FuncionalidadeEntity;

@Component
public class FuncionalidadeConverter implements Converter<FuncionalidadeEntity, FuncionalidadeBean> {

	@Override
	public FuncionalidadeEntity convertBeanToEntity(FuncionalidadeBean bean) {
		if (bean == null) {
			return null;
		}
		FuncionalidadeEntity entity = new FuncionalidadeEntity();

		entity.setId(bean.getId());
		entity.setNomeFuncionalidade(bean.getNome());

		return entity;
	}

	@Override
	public FuncionalidadeBean convertEntityToBean(FuncionalidadeEntity entity) {
		if (entity == null) {
			return null;
		}
		FuncionalidadeBean bean = new FuncionalidadeBean();

		bean.setId(entity.getId());
		bean.setNome(entity.getNomeFuncionalidade());

		return bean;
	}
}