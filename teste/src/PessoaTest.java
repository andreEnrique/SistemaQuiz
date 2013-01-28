import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;


public class PessoaTest {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		ArrayList<Pessoa> pessoas = new ArrayList<>();
		
		Pessoa p1 = new Pessoa("Kelson", "88858450");
		pessoas.add(p1);
		Pessoa p2 = new Pessoa("Kelvyn", "88888888");
		pessoas.add(p2);
		
		Arquivo arquivo = new Arquivo();
		arquivo.escreverArquivo(pessoas);
		
		ArrayList<Pessoa> retorno = arquivo.lerArquivo();		
		for (Pessoa pessoa : retorno) {
			System.out.println("Nome: " + pessoa.getNome());
			System.out.println("Número: " + pessoa.getNumero() + "\n");
		}
		
		arquivo.excluirArquivo(0);
		ArrayList<Pessoa> retorno_01 = arquivo.lerArquivo();		
		for (Pessoa pessoa : retorno_01) {
			System.out.println("Nome: " + pessoa.getNome());
			System.out.println("Número: " + pessoa.getNumero() + "\n");
		}
		
	}

}
