package br.com.likeup.converter;

import org.springframework.stereotype.Component;

import br.com.likeup.bean.UsuarioBean;
import br.com.likeup.entity.UsuarioEntity;

@Component
public class UsuarioConverter implements Converter<UsuarioEntity, UsuarioBean>{

	@Override
	public UsuarioEntity convertBeanToEntity(UsuarioBean bean) {
		if (bean == null) {
			return null;
		}
		UsuarioEntity entity = new UsuarioEntity();
		
		entity.setId(bean.getId());
		entity.setUsuario(bean.getUsuario());
		entity.setSenha(bean.getSenha());
		entity.setAtivo(bean.getAtivo());
		
		return entity;
	}

	@Override
	public UsuarioBean convertEntityToBean(UsuarioEntity entity) {
		if (entity == null) {
			return null;
		}
		UsuarioBean bean = new UsuarioBean();
		
		bean.setId(entity.getId());
		bean.setUsuario(entity.getUsuario());
		bean.setAtivo(entity.getAtivo());
		bean.setSenha(entity.getSenha());
		
		return bean;
	}

}
