package br.com.likeup.bean;

import org.springframework.stereotype.Component;

/**
 * @author guilherme.oliveira
 *
 */
/**
 * @author guilherme.oliveira
 *
 */
@Component
public class FuncionalidadeBean {
	private Integer id;
	private String nome;

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

}