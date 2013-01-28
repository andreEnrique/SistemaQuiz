import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Professor {
	Scanner input =  new Scanner(System.in);
	
	Menu menu;
	PerguntaMetodos perguntasM;
	AlunoMetodos alunosM;
	
	public Professor() {
		perguntasM = new PerguntaMetodos();
		alunosM = new AlunoMetodos();
	}
	
	public void menuProfessor() throws FileNotFoundException, IOException, ClassNotFoundException{
		System.out.println("\t Opções \n");
		//System.out.println("1 - Adicionar pergunta");
		System.out.println("2 - Listar pergunta");
		System.out.println("3 - Excluir pergunta");
		System.out.println("4 - Adicionar aluno(a)");
		System.out.println("5 - Listar aluno(s)");
		System.out.println("6 - Excluir aluno(a)");
		System.out.println("7 - Estatísticas");
		System.out.println("8 - Menu principal \n");
		System.out.print("Digite a sua opção: ");
		int opcao = Integer.parseInt(input.nextLine());
		System.out.println("");
		switch (opcao) {
		case 1:
			perguntasM.addPergunta();
			System.out.println(perguntasM.sucesso("Pergunta cadastrada com Sucesso! \n"));
			menuProfessor();
		case 2:
			perguntasM.listaDePerguntas();
			menuProfessor();
		case 3:
			perguntasM.listaDePerguntas();
			System.out.print("Digite o numero da questão que deseja excluir: ");
			int op_01 = Integer.parseInt(input.nextLine());
			perguntasM.excluirPergunta(op_01 - 1);
			menuProfessor();
		case 4:
			alunosM.addAluno();
			System.out.println(perguntasM.sucesso("Aluno(a) cadastrado(a) com Sucesso! \n"));
			menuProfessor();
		case 5:
			alunosM.listaDeAlunos();
			menuProfessor();
		case 6:
			alunosM.listaDeAlunos();
			System.out.print("Digite o numero do aluno(a) que deseja excluir: ");
			int op_02 = Integer.parseInt(input.nextLine());
			perguntasM.excluirPergunta(op_02 - 1);
			menuProfessor();
		case 8:
			menu = new Menu();
			menu.menu();
		}
	}
	
	

}
