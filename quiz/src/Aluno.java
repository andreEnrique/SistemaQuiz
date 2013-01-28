import java.io.Serializable;


@SuppressWarnings("serial")
public class Aluno implements Serializable{
	
	private String nome;
	private String idade;
	private String matricula;
	
	public Aluno(String nome, String idade, String matricula) {
		setNome(nome);
		setIdade(idade);
		setMatricula(matricula);
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getIdade() {
		return idade;
	}
	public void setIdade(String idade) {
		this.idade = idade;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	
	
}
