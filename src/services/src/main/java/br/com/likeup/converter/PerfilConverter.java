package br.com.likeup.converter;

import org.springframework.stereotype.Component;

import br.com.likeup.bean.PerfilBean;
import br.com.likeup.entity.PerfilEntity;

@Component
public class PerfilConverter implements Converter<PerfilEntity, PerfilBean>{

	@Override
	public PerfilEntity convertBeanToEntity(PerfilBean bean) {
		if (bean == null) {
			return null;
		}
		PerfilEntity entity = new PerfilEntity();
		
		entity.setId(bean.getId());
		entity.setNome(bean.getNome());
		
		return entity;
	}

	@Override
	public PerfilBean convertEntityToBean(PerfilEntity entity) {
		if (entity == null) {
			return null;
		}
		PerfilBean bean = new PerfilBean();
		
		bean.setId(entity.getId());
		bean.setNome(entity.getNome());
		
		return bean;
	}

}
