package br.com.likeup.bean;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class PerfilBean {
	private Integer id;
	private String nome;
	private List<FuncionalidadeBean> funcionalidades;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<FuncionalidadeBean> getFuncionalidades() {
		return funcionalidades;
	}

	public void setFuncionalidades(List<FuncionalidadeBean> funcionalidades) {
		this.funcionalidades = funcionalidades;
	}

}
