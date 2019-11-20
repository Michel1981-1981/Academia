package br.com.alura.Academia.ModelFerias;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import org.springframework.format.annotation.DateTimeFormat;

@Entity (name = "ferias")
public class Ferias {
	

		
	@Id	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_ferias;
	
	private String matricula;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")	
	private String dataini;
	
	private String numdias;
	
	
	
public Ferias() {	
	
}
	
		
	public Ferias(String matricula, String dataini, String numdias) { 
		super();
		this.matricula = matricula;
		this.dataini = dataini;
		this.numdias = numdias;
		
	}


	public Long getId() {
		return id_ferias;
	}


	public void setId(Long idFerias) {
		this.id_ferias = idFerias;
	}


	public String getMatricula() {
		return matricula;
	}


	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}


	public String getDataini() {
		return dataini;
	}


	public void setDataini(String dataini) {
		this.dataini = dataini;
	}


	public String getNumdias() {
		return numdias;
	}


	public void setNumdias(String numdias) {
		this.numdias = numdias;
	}



	
}


