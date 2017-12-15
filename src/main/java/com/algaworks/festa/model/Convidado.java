package com.algaworks.festa.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Convidado {
	
	@Id
	@GeneratedValue
	private Long id;
	private String nome;
	private Integer quantidadeAcompanhantes;
	@ManyToOne
	@JoinColumn(name = "id_festa")
	private Festa festa;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getQuantidadeAcompanhantes() {
		return quantidadeAcompanhantes;
	}
	public void setQuantidadeAcompanhantes(Integer quantidadeAcompanhantes) {
		this.quantidadeAcompanhantes = quantidadeAcompanhantes;
	}
	public Festa getFesta() {
		return festa;
	}
	public void setFesta(Festa festa) {
		this.festa = festa;
	}
	

}
