package br.com.alura.Academia.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity (name = "alunos")
public class Aluno {

	
	@Id	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_aluno;
	
	private String matricula;
	
	private String nome;
	
	private String rg;
	
	private String cpf;
	
	private String endereco;
	
	private String plano;
	
	
	

public Aluno() {	
	
}
	
		
	public Aluno(String matricula, String nome, String rg, String cpf, String endereco, String plano)
			{ 
		super();
		this.matricula = matricula;
		this.nome = nome;
		this.rg = rg;
		this.cpf = cpf;
		this.endereco = endereco;
		this.plano = plano;
	

		
	}


	public Long getId() {
		return id_aluno;
	}

	public void setId(Long id) {
		this.id_aluno = id;
	}

	public String getMatricula() {
		return matricula;
	}


	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}


	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public String getPlano() {
		return plano;
	}


	public void setPlano(String plano) {
		this.plano = plano;
	}

	
	public boolean delete(Aluno aluno) {
		// TODO Auto-generated method stub
		return false;
	}

	

	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void set(int i, Aluno aluno) {
		// TODO Auto-generated method stub
		
	}
	

	public Long deleteId() {
		// TODO Auto-generated method stub
		return null;
	}


	

	

	

	
}
