package br.com.ufpb.classes;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class Arquivo {
	
	private String nomeDiretorio = "arquivos" +  File.separator;
	
	public Arquivo(){
		File diretorio = new File(this.nomeDiretorio);
		if(!diretorio.exists()){
			diretorio.mkdir();
		}
	}
	
//	public void escreverPergunta(ArrayList<Pergunta> pergunta) throws FileNotFoundException, IOException{
//		try(FileOutputStream arquivo = new FileOutputStream(this.nomeDiretorio + "pergunta.txt")){
//			try(ObjectOutputStream escrever = new ObjectOutputStream(arquivo)){
//				escrever.writeObject(pergunta);
//			}
//		}
//	}
//	
//	@SuppressWarnings("unchecked")
//	public ArrayList<Pergunta> lerPergunta() throws FileNotFoundException, IOException, ClassNotFoundException{
//		try(FileInputStream arquivo = new FileInputStream(this.nomeDiretorio + "pergunta.txt")){
//			try(ObjectInputStream ler = new ObjectInputStream(arquivo)){ 
//				return (ArrayList<Pergunta>)ler.readObject();
//			}
//		}
//		catch(FileNotFoundException e){
//			File f = new File(this.nomeDiretorio + "pergunta.txt");
//			if(!f.exists()){
//				f.createNewFile();
//			}
//			return null;
//		}
//		
//	}
//	
//	public void escreverAluno(ArrayList<Aluno> aluno) throws FileNotFoundException, IOException{
//		try(FileOutputStream arquivo = new FileOutputStream(this.nomeDiretorio+"aluno.txt")){
//			try(ObjectOutputStream escrever = new ObjectOutputStream(arquivo)){
//				escrever.writeObject(aluno);
//			}
//		}
//	}
//	
//	@SuppressWarnings("unchecked")
//	public ArrayList<Aluno> lerAluno() throws FileNotFoundException, IOException, ClassNotFoundException{
//		try(FileInputStream arquivo = new FileInputStream(this.nomeDiretorio+"aluno.txt")){
//			try(ObjectInputStream ler = new ObjectInputStream(arquivo)){
//				return (ArrayList<Aluno>)ler.readObject();
//			}
//		}
//		catch(FileNotFoundException e){
//			File f = new File(this.nomeDiretorio + "aluno.txt");
//			if(!f.exists()){
//				f.createNewFile();
//			}
//			return null;
//		}
//	}
//	
//	public void escreverRank(List<Aluno> aluno) throws FileNotFoundException, IOException{
//		try(FileOutputStream arquivo = new FileOutputStream(this.nomeDiretorio+"rank.txt")){
//			try(ObjectOutputStream escrever = new ObjectOutputStream(arquivo)){
//				escrever.writeObject(aluno);
//			}
//		}
//	}
//	
//	@SuppressWarnings("unchecked")
//	public List<Aluno> lerRank() throws FileNotFoundException, IOException, ClassNotFoundException{
//		try(FileInputStream arquivo = new FileInputStream(this.nomeDiretorio+"rank.txt")){
//			try(ObjectInputStream ler = new ObjectInputStream(arquivo)){
//				return (ArrayList<Aluno>)ler.readObject();
//			}
//		}
//		catch(FileNotFoundException e){
//			File f = new File(this.nomeDiretorio + "rank.txt");
//			if(!f.exists()){
//				f.createNewFile();
//			}
//			return null;
//		}
//	}
}
