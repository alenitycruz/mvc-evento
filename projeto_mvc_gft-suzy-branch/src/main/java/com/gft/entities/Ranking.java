package com.gft.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "raking_tb")
public class Ranking implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_raking;
	
	@OneToMany
	@JoinColumn(name = "id_pontuacao")
	private List<Pontuacao> pontuacoes;

	public Long getId_raking() {
		return id_raking;
	}

	public void setId_raking(Long id_raking) {
		this.id_raking = id_raking;
	}

	public List<Pontuacao> getPontuacoes() {
		return pontuacoes;
	}

	public void setPontuacoes(List<Pontuacao> pontuacoes) {
		this.pontuacoes = pontuacoes;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	
	
	

}
