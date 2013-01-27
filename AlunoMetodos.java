import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class AlunoMetodos {
	Scanner input = new Scanner(System.in);
	
	private static final String URL_ALUNOS = "C:/Users/Wennio/workspace/quiz/src/filesTxt/alunos.ser";
	
	ArrayList<Aluno> arrayAlunos;
	Aluno objAluno;
	Arquivo arquivo;
	
	public AlunoMetodos() {
		arrayAlunos = new ArrayList<>();
		arquivo = new Arquivo();
	}
	
	public void addAluno() throws FileNotFoundException, IOException{
		System.out.print("Digite o nome do aluno: ");
		String nome = input.nextLine();
		System.out.print("Digite a idade do aluno: ");
		String idade = input.nextLine();
		System.out.print("Digite a matricula do aluno: ");
		String matricula = input.nextLine();
		System.out.println("");
		
		objAluno = new Aluno(nome, idade, matricula);
		arrayAlunos.add(objAluno);
		arquivo.escreverAlunos(URL_ALUNOS, arrayAlunos);
	}
	
	public void listaDeAlunos() throws FileNotFoundException, ClassNotFoundException, IOException{
		int cont = 0;
		ArrayList<Aluno> lista = arquivo.lerArquivoAlunos(URL_ALUNOS);
		for(Aluno a : lista){
			System.out.println("\t Nº do Aluno: " + (cont + 1));
			System.out.println("Nome: " + a.getNome());
			System.out.println("Idade: " + a.getIdade());
			System.out.println("Matricula: " + a.getMatricula() + "\n\n");
			cont ++;
		}
	}
	
	public void excluirAluno(int op) throws FileNotFoundException, ClassNotFoundException, IOException{
		arquivo.excluirPergunta(op, URL_ALUNOS);
	}

}
