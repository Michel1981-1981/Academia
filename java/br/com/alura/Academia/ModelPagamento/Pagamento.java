package br.com.alura.Academia.ModelPagamento;
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

@Entity (name = "pagamentos")
public class Pagamento implements PropertyEditor {
	
	
	@Id	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_pagamento;
	
	private String matricula;
	
	private String plano;
	
	private String valor;	
	
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")		
	private String datapagamento;	
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")	
	private String proximopagamento;


public Pagamento() {	
	
}
	
		
	public Pagamento(String matricula, String plano, String valor, String datapagamento, String proximopagamento) { 
		super();
		this.matricula = matricula;
		this.plano = plano;
		this.valor = valor;
		this.datapagamento = datapagamento;
		this.proximopagamento = proximopagamento;


		
	}



	public Long getId() {
		return id_pagamento;
	}


	public void setId(Long id) {
		this.id_pagamento = id;
	}


	public String getMatricula() {
		return matricula;
	}


	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}


	public String getPlano() {
		return plano;
	}


	public void setPlano(String plano) {
		this.plano = plano;
	}


	
	public String getValor() {
		return valor;
	}


	public void setValor(String valor) {
		this.valor = valor;
	}


	public String getDatapagamento() {
		return datapagamento;
	}


	public void setDatapagamento(String datapagamento) {
		this.datapagamento = datapagamento;
	}


	public String getProximopagamento() {
		return proximopagamento;
	}


	public void setProximopagamento(String proximopagamento) {
		this.proximopagamento = proximopagamento;
	}


	public void setIdPagamento(Long idPagamento) {
		// TODO Auto-generated method stub
		
	}


	public void setId(String idPagamento) {
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





	

	

	

	


