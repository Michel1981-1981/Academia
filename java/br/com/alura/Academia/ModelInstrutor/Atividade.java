package br.com.alura.Academia.ModelInstrutor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "atividades")
public class Atividade {
	
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_atividade;

	private String aula;

	private String horario;
	
	private String instrutor;
	

	private String diadasemana;
	
	private String sala;
	
	private String tipoaula;

	public Atividade(){
		
	}

	public Atividade(String aula, String horario, String instrutor, String diadasemana, String sala, String tipoaula) {
		super();
		this.aula = aula;
		this.horario = horario;	
		this.setInstrutor(instrutor);
		this.diadasemana = diadasemana;
		this.sala=sala;		
		this.tipoaula=tipoaula;	
	}

	public Long getId() {
		return id_atividade;
	}

	public void setId(Long id) {
		this.id_atividade = id;
	}

	public String getAula() {
		return aula;
	}

	public void setAula(String aula) {
		this.aula = aula;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public String getDia() {
		return diadasemana;
	}

	public void setDia(String dia) {
		this.diadasemana = dia;
	}

	public String getSala() {
		return sala;
	}

	public void setSala(String sala) {
		this.sala = sala;
	}

	public String getTipoaula() {
		return tipoaula;
	}

	public void setTipoaula(String tipoaula) {
		this.tipoaula = tipoaula;
	}

	public String getInstrutor() {
		return instrutor;
	}

	public void setInstrutor(String instrutor) {
		this.instrutor = instrutor;
	}




}

