import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;


public class Menu {
	Scanner input = new Scanner(System.in);
	
	private Login login;
	private Professor professor;
	private Sair sair;
	
	public static final String ADMNOME = "adm";
	public static final String ADMMATRICULA = "adm";
	
	public Menu() {
		login = new Login();
		professor = new Professor();
		sair = new Sair();
	}
	
	public void menu() throws FileNotFoundException, ClassNotFoundException, IOException{
		System.out.println("	QUIZ JAVA	\n\n");
		System.out.println("1 - Jogar");
		System.out.println("2 - Rank");
		System.out.println("3 - Sair \n");
		System.out.print("Digite sua alternativa: ");
		int opcao = Integer.parseInt(input.nextLine());
		System.out.println("");
		switch (opcao) {
		case 1:
			login.login();
			System.out.println("");
			if(login.getNome().equals(ADMNOME) && login.getMatricula().equals(ADMMATRICULA)){
				professor.menuProfessor();
			}
			else{
				
			}
			break;
		case 2:
			System.out.println("Opção 2");
			break;
		case 3:
			System.out.println(sair.toString());
			break;
		}
	}
}
