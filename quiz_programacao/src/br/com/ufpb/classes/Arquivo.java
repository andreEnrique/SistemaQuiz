package br.com.ufpb.classes;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Arquivo {
	
	public void escreverPergunta(ArrayList<Pergunta> pergunta) throws FileNotFoundException, IOException{
		try(FileOutputStream arquivo = new FileOutputStream("C:/Users/Wennio/workspace_projeto/quiz_programacao/src/br/com/ufpb/arquivos/perguntas.ser")){
			try(ObjectOutputStream escrever = new ObjectOutputStream(arquivo)){
				escrever.writeObject(pergunta);
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<Pergunta> lerPergunta() throws FileNotFoundException, IOException, ClassNotFoundException{
		try(FileInputStream arquivo = new FileInputStream("C:/Users/Wennio/workspace_projeto/quiz_programacao/src/br/com/ufpb/arquivos/perguntas.ser")){
			try(ObjectInputStream ler = new ObjectInputStream(arquivo)){
				return (ArrayList<Pergunta>)ler.readObject();
			}
		}
	}
	
	public void escreverAluno(ArrayList<Aluno> aluno) throws FileNotFoundException, IOException{
		try(FileOutputStream arquivo = new FileOutputStream("C:/Users/Wennio/workspace_projeto/quiz_programacao/src/br/com/ufpb/arquivos/alunos.ser")){
			try(ObjectOutputStream escrever = new ObjectOutputStream(arquivo)){
				escrever.writeObject(aluno);
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<Aluno> lerAluno() throws FileNotFoundException, IOException, ClassNotFoundException{
		try(FileInputStream arquivo = new FileInputStream("C:/Users/Wennio/workspace_projeto/quiz_programacao/src/br/com/ufpb/arquivos/alunos.ser")){
			try(ObjectInputStream ler = new ObjectInputStream(arquivo)){
				return (ArrayList<Aluno>)ler.readObject();
			}
		}
	}
	
	public void escreverRank(List<Aluno> aluno) throws FileNotFoundException, IOException{
		try(FileOutputStream arquivo = new FileOutputStream("C:/Users/Wennio/workspace_projeto/quiz_programacao/src/br/com/ufpb/arquivos/rank.ser")){
			try(ObjectOutputStream escrever = new ObjectOutputStream(arquivo)){
				escrever.writeObject(aluno);
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Aluno> lerRank() throws FileNotFoundException, IOException, ClassNotFoundException{
		try(FileInputStream arquivo = new FileInputStream("C:/Users/Wennio/workspace_projeto/quiz_programacao/src/br/com/ufpb/arquivos/rank.ser")){
			try(ObjectInputStream ler = new ObjectInputStream(arquivo)){
				return (ArrayList<Aluno>)ler.readObject();
			}
		}
	}
}
