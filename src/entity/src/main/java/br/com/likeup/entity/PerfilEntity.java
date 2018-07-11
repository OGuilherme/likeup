package br.com.likeup.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Profile")
public class PerfilEntity {

	@Id
	@Column(name = "idPerfil")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "nmPerfil")
	private String nome;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
	@JoinTable(name = "SAVPerfilFuncionalidades", joinColumns = { @JoinColumn(name = "idPerfil") }, inverseJoinColumns = {
			@JoinColumn(name = "idFuncionalidade") })
	private List<FuncionalidadeEntity> permissoes;
	
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

	public List<FuncionalidadeEntity> getPermissoes() {
		return permissoes;
	}

	public void setPermissoes(List<FuncionalidadeEntity> permissoes) {
		this.permissoes = permissoes;
	}

}
