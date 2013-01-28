import java.io.Serializable;


public class Pessoa implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	String nome;
	String numero;
	
	public Pessoa(String nome, String numero) {
		setNome(nome);
		setNumero(numero);
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
}
