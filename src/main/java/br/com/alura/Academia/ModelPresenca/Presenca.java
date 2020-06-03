package br.com.alura.Academia.ModelPresenca;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity (name = "presenca")
public class Presenca {
	

		
	@Id	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_presenca;
	
	private String id_atividade;
	
	private String matricula;
	
	private String diaaula;
	
	
	
public Presenca() {	
	
}
	
		
	public Presenca(String matricula, String diaaula) { 
		super();
		this.matricula = matricula;
		this.diaaula = diaaula;		
		
				
	}


	public Long getId() {
		return id_presenca;
	}


	public void setId(Long id) {
		this.id_presenca = id;
	}


	public String getId_atividade() {
		return id_atividade;
	}


	public void setId_atividade(String id_atividade) {
		this.id_atividade = id_atividade;
	}


	public String getMatricula() {
		return matricula;
	}


	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}


	public String getDiaaula() {
		return diaaula;
	}


	public void setDiaaula(String diaaula) {
		this.diaaula = diaaula;
	}



}