package br.com.ufpb.classes;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Atualizacao {
	
	Arquivo arquivo = new Arquivo();
	ArrayList<Pergunta> perguntaAux;
	ArrayList<Aluno>    alunoAux   ;
	List<Aluno> 		rankAux	   ;
	
	public Atualizacao() {
		perguntaAux = new ArrayList<>();
		alunoAux    = new ArrayList<>();
		rankAux	    = new ArrayList<>();
	}		
	
	public ArrayList<Pergunta> atualizarPergutas(){
		try {
			perguntaAux = arquivo.lerPergunta();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return perguntaAux;
	}
	
	public ArrayList<Aluno> atualizarAlunos(){
		try {
			alunoAux = arquivo.lerAluno();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return alunoAux;
	}
	
	public List<Aluno> atualizarRank(){
		try {
			rankAux = arquivo.lerRank();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return rankAux;
	}

}
