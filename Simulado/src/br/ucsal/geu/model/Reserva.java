package br.ucsal.geu.model;

import java.sql.Date;
import java.sql.Time;

public class Reserva {
	
	private Integer id;
	private String titulo;
	private String descricao;
	private String justificativa;
	private String solicitante;
	private String telefone;
	private Date data;
	private Time hora_inicio;
	private Time hora_fim;
	//private Espaco espaco;
	
	
	public Reserva(String titulo, String descricao, String justificativa, String solicitante,
			String telefone, Date data, Time hora_inicio, Time hora_fim) {
		super();
		this.titulo = titulo;
		this.descricao = descricao;
		this.justificativa = justificativa;
		this.solicitante = solicitante;
		this.telefone = telefone;
		this.data = data;
		this.hora_inicio = hora_inicio;
		this.hora_fim = hora_fim;
		//this.espaco = espaco;
	}
	

	public Reserva() {
	}
	
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getJustificativa() {
		return justificativa;
	}

	public void setJustificativa(String justificativa) {
		this.justificativa = justificativa;
	}

	public String getSolicitante() {
		return solicitante;
	}

	public void setSolicitante(String solicitante) {
		this.solicitante = solicitante;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Time getHora_inicio() {
		return hora_inicio;
	}

	public void setHora_inicio(Time hora_inicio) {
		this.hora_inicio = hora_inicio;
	}

	public Time getHora_fim() {
		return hora_fim;
	}

	public void setHora_fim(Time hora_fim) {
		this.hora_fim = hora_fim;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}

	//public Espaco getEspaco() {
	//	return espaco;
	//}

	//public void setEspaco(Espaco espaco) {
	//	this.espaco = espaco;
	//}

	
}


