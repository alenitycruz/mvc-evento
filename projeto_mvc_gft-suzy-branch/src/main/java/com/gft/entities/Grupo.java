package com.gft.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_grupo")
public class Grupo implements Serializable {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_grupo;
	
	private String nome;
	
	@OneToMany(mappedBy = "grupo")
	private List<Participante> participantes;
	
	@ManyToMany
	@JoinTable(
            name = "tb_grupos_eventos",
              joinColumns = {@JoinColumn(name = "id_evento")}
            , inverseJoinColumns = {@JoinColumn(name = "id_grupo")}
        )
	private List<Evento> evento;

	
	public Integer quantidadeParticipante() {
		return participantes.size();
	}


	public Long getId_grupo() {
		return id_grupo;
	}


	public void setId_grupo(Long id_grupo) {
		this.id_grupo = id_grupo;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public List<Participante> getParticipantes() {
		return participantes;
	}


	public void setParticipantes(List<Participante> participantes) {
		this.participantes = participantes;
	}


	public List<Evento> getEvento() {
		return evento;
	}


	public void setEvento(List<Evento> evento) {
		this.evento = evento;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

	
}
