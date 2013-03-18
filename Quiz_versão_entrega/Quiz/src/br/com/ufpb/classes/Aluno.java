package br.com.ufpb.classes;

import java.io.Serializable;

/*
 * Classe Aluno 
 * Implementa as Interfaces Serializable e Comparable<>
 */
@SuppressWarnings("serial")
public class Aluno implements Serializable, Comparable<Aluno>{
	
	/*
	 * Atributos da classe.
	 */
	private int id;
	private String nome;
	private String matricula;
	private int pontuacao;
	
	/*
	 * Construtor da classe(vazio).
	 */
	public Aluno() {
	}
	
	/*
	 * Contrutor da classe(recebe paramêtros para ser atribuidos aos atributos da classe).
	 */
	public Aluno(String nome, String matricula, int pontuacao) {
		setNome(nome);
		setMatricula(matricula);
		setPontuacao(pontuacao);
	}
	
	public Aluno(int id, String nome, String matricula, int pontuacao) {
		setId(id);
		setNome(nome);
		setMatricula(matricula);
		setPontuacao(pontuacao);
	}

	/*
	 * Métodos getters e setters dos atributos da classe.
	 */
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public int getPontuacao() {
		return pontuacao;
	}

	public void setPontuacao(int pontuacao) {
		this.pontuacao = pontuacao;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int compareTo(Aluno o) {
		if(this.pontuacao > o.getPontuacao()){
			return -1;
		}else if (this.pontuacao < o.getPontuacao()) {
			return 1;
		}else {
			return 0;
		}
		
	}



}
