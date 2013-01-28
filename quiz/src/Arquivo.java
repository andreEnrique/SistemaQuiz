import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Arquivo {
	public void escreverPerguntas(String url,ArrayList<Pergunta> array) throws FileNotFoundException, IOException{
		try(FileOutputStream fOut = new FileOutputStream(url)){
			try(ObjectOutputStream out = new ObjectOutputStream(fOut)){
				out.writeObject(array);
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<Pergunta> lerArquivoPerguntas(String url) throws FileNotFoundException, IOException, ClassNotFoundException{
		try(FileInputStream fIn = new FileInputStream(url)){
			try(ObjectInputStream  in = new ObjectInputStream(fIn)){
				return (ArrayList<Pergunta>) in.readObject();
			} 
		}
	}
	
	public void excluirPergunta(int op, String url) throws FileNotFoundException, ClassNotFoundException, IOException{
		ArrayList<Pergunta> pergunta = this.lerArquivoPerguntas(url);
		pergunta.remove(pergunta.remove(op));
		this.escreverPerguntas(url, pergunta);
		System.out.println("\nPergunta excluída com sucesso! \n\n");
	}
	
	public void escreverAlunos(String url,ArrayList<Aluno> array) throws FileNotFoundException, IOException{
		try(FileOutputStream fOut = new FileOutputStream(url)){
			try(ObjectOutputStream out = new ObjectOutputStream(fOut)){
				out.writeObject(array);
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<Aluno> lerArquivoAlunos(String url) throws FileNotFoundException, IOException, ClassNotFoundException{
		try(FileInputStream fIn = new FileInputStream(url)){
			try(ObjectInputStream  in = new ObjectInputStream(fIn)){
				return (ArrayList<Aluno>) in.readObject();
			} 
		}
	}
	
	public void excluirAluno(int op, String url) throws FileNotFoundException, ClassNotFoundException, IOException{
		ArrayList<Aluno> aluno = this.lerArquivoAlunos(url);
		aluno.remove(aluno.remove(op));
		this.escreverAlunos(url, aluno);
		System.out.println("\nAluno(a) excluído(a) com sucesso! \n\n");
	}
}
