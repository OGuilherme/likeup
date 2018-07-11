package br.com.likeup.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.likeup.bean.CustomUserDetails;
import br.com.likeup.bean.PerfilBean;
import br.com.likeup.bean.UsuarioBean;
import br.com.likeup.converter.FuncionalidadeConverter;
import br.com.likeup.converter.PerfilConverter;
import br.com.likeup.converter.UsuarioConverter;
import br.com.likeup.dao.UsuarioDAO;
import br.com.likeup.entity.PerfilEntity;
import br.com.likeup.entity.UsuarioEntity;

@Service
public class CustomUserDetailsServices implements UserDetailsService {

	@Autowired
	private UsuarioDAO usuarioDAO;

	@Autowired
	private UsuarioConverter usuarioConverter;

	@Autowired
	private PerfilConverter perfilConverter;

	@Autowired
	private FuncionalidadeConverter permissaoConverter;

	@Transactional
	@Override
	public UserDetails loadUserByUsername(String usuario) throws UsernameNotFoundException {
		Optional<UsuarioEntity> optionalUsuarios = usuarioDAO.findByUsuario(usuario);
		List<PerfilBean> perfilBeans = new ArrayList<PerfilBean>();
		List<PerfilEntity> perfilEntities = new ArrayList<PerfilEntity>();

		optionalUsuarios.orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado"));

		UsuarioBean usuarioBean = new UsuarioBean();

		usuarioBean = usuarioConverter.convertEntityToBean(optionalUsuarios.get());

		perfilEntities = optionalUsuarios.get().getPerfis();
		for (int i = 0; i < perfilEntities.size(); i++) {
			PerfilBean perfilBean = new PerfilBean();
			perfilBean = perfilConverter.convertEntityToBean(perfilEntities.get(i));
			perfilBean
					.setFuncionalidades(permissaoConverter.convertEntityToBean(perfilEntities.get(i).getPermissoes()));
			perfilBeans.add(perfilBean);
		}

		usuarioBean.setPerfis(perfilBeans);

		return new CustomUserDetails(usuarioBean);
	}

	public UsuarioBean usuarioLogado() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UsuarioBean usuarioLogado = (UsuarioBean) auth.getPrincipal();
		return usuarioLogado;
	}
}
