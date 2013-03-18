package br.com.ufpb.classes;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class FacadeQUIZ {
	
		private AlunoMetodos gerAlunos;		
		private PerguntaMetodos gerPergunta;
		private Rank gerRank;
		private GerenciadorProfessor gerProfessor;
		private GerenciadorDica gerDica;
		private Jogar gerJogar;
		
	
	public FacadeQUIZ(){
		this.gerPergunta = new PerguntaMetodos();
		this.gerAlunos = new AlunoMetodos();
		this.gerRank= new Rank();
		this.gerProfessor = new GerenciadorProfessor();
		this.gerDica = new GerenciadorDica();
		this.gerJogar = new Jogar();
		
	}
	
	//ALUNO METODOS
	public void cadastrarAluno(String nome, String matricula, int pontuacao){
		this.gerAlunos.cadastrarAluno(nome, matricula, pontuacao);
	}
	
	
	public void excluirAluno(){		
		this.gerAlunos.excluirAluno();
	}
	
	public void listarAluno(){
		this.gerAlunos.listarAluno();
	}
	
	//PERGUNTA METODOS
	public void cadastrarPergunta(){
		this.gerPergunta.cadastrarPergunta();
		
	}
	
	public void listarPergunta(){
		this.gerPergunta.listarPergunta();
	}
	
	public void excluirPergunta(){
		this.gerPergunta.excluirPergunta();
	}
	
	public ArrayList<Pergunta> getPerguntas() {
		return this.gerPergunta.getPerguntas();
	}
	
	//JOGAR
	public void exibirPerguntas(){
		this.gerJogar.exibirPerguntas();
	}
	
	//RANK
	public void mostrarRank(){
		this.gerRank.mostrarRank();
	}
	
	public void adicionarRank(String nome, String matricula,int pontuacao){
		this.gerRank.adicionarRank(nome, matricula, pontuacao);
	}
	
	
	//PROFESSOR  
	public void menu(){
		this.gerProfessor.menu();
	}
	
	//DICA
	public void cadastrarDica(int id, String descricaoDaDica){
		this.gerDica.cadastrarDica(id, descricaoDaDica);
	}
	
	public void excluirDica(){
		this.gerDica.excluirDica();
	}
	
	public void listarDicas(){
		this.gerDica.listarDicas();
	}
	
}
