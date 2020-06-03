package br.com.alura.Academia.ModelAvaliacao;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.beans.PropertyChangeListener;
import java.beans.PropertyEditor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

@Entity (name = "avaliacao")
public class Avaliacao implements PropertyEditor {

	
	@Id	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_avaliacao;
	
	private String id_aluno;
	
	private String matricula;
	
	private String exame;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")	
	private String dataavaliacao;

	public Avaliacao() {	
	
}
	
		
	public Avaliacao(String matricula, String exame, String dataavaliacao) { 
		super();
		
		this.matricula = matricula;
		this.exame = exame;
		this.dataavaliacao = dataavaliacao;
		
	}	


	public Long getId() {
		return id_avaliacao;
	}

	public void setId(Long idAvaliacao) {
		this.id_avaliacao = idAvaliacao;
	}


	public String getId_aluno() {
		return id_aluno;
	}


	public void setId_aluno(String id_aluno) {
		this.id_aluno = id_aluno;
	}


	public String getMatricula() {
		return matricula;
	}


	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}


	public String getExame() {
		return exame;
	}


	public void setExame(String exame) {
		this.exame = exame;
	}


	public String getDataavaliacao() {
		return dataavaliacao;
	}


	public void setDataavaliacao(String dataavaliacao) {
		this.dataavaliacao = dataavaliacao;
	}


	

	public void setIdavaliacao(Long valueOf) {
		// TODO Auto-generated method stub
		
	}
	
	public boolean delete(Avaliacao avaliacao) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public Long deleteId() {
		// TODO Auto-generated method stub
		return null;
	}


	public void setidavaliacao(Long valueOf) {
		// TODO Auto-generated method stub
		
	}


	public void setIdAtividade(Long valueOf) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void setValue(Object value) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public Object getValue() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public boolean isPaintable() {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public void paintValue(Graphics gfx, Rectangle box) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public String getJavaInitializationString() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String getAsText() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		
	}


	@Override
	public String[] getTags() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Component getCustomEditor() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public boolean supportsCustomEditor() {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public void addPropertyChangeListener(PropertyChangeListener listener) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void removePropertyChangeListener(PropertyChangeListener listener) {
		// TODO Auto-generated method stub
		
	}
	
	    } 
		
	


