import java.util.Scanner;

public class Login {
	Scanner input = new Scanner(System.in);
	private String nome = null;
	private String matricula = null;
	public void login(){
		System.out.print("Nome: ");
		setNome(input.nextLine());
		System.out.print("Matricula: ");
		setMatricula(input.nextLine());
	}
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
}
