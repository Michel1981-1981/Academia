package br.com.alura.Academia.ModelInstrutor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "instrutores")
public class Instrutor {
	
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_instrutor;

	private String nome;

	private String rg;

	private String cpf;

	private String endereco;
	


	public Instrutor() {}

	public Instrutor(String nome, String rg, String cpf, String endereco) {
	
		this.nome = nome;
		this.rg = rg;
		this.cpf = cpf;
		this.endereco = endereco;
		
		
	}

	public Long getId() {
		return id_instrutor;
	}

	public void setId(Long id) {
		this.id_instrutor = id;
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


	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	public Instrutor get(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	public void set(int i, Instrutor instrutor) {
		// TODO Auto-generated method stub
		
	}
		public Long deleteId() {
			// TODO Auto-generated method stub
			return null;
		}

	}

