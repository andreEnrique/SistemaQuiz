import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class PerguntaMetodos {
	Scanner input = new Scanner(System.in);
	
	private static final String URL_PERGUNTAS = "C:/Users/Wennio/workspace/quiz/src/filesTxt/perguntas.ser";
	
	private ArrayList<Pergunta> arrayPerguntas;
	private Pergunta objPergunta;
	private Arquivo arquivo;
	
	public PerguntaMetodos() {
		arrayPerguntas = new ArrayList<>();
		arquivo = new Arquivo();
	}	
	
	public void addPergunta() throws FileNotFoundException, IOException{
		System.out.print("Pergunta: ");
		String pergunta = input.nextLine();
		System.out.print("Opção 01: ");
		String op01 = input.nextLine();
		System.out.print("Opção 02: ");
		String op02 = input.nextLine();
		System.out.print("Opção 03: ");
		String op03 = input.nextLine();
		System.out.print("Opção 04: ");
		String op04 = input.nextLine();
		System.out.print("Correta: ");
		String correta = input.nextLine();
		System.out.println("");
		
		objPergunta = new Pergunta(pergunta, op01, op02, op03, op04, correta);
		arrayPerguntas.add(objPergunta);
		arquivo.escreverPerguntas(URL_PERGUNTAS, arrayPerguntas);
	}
	
	public void listaDePerguntas() throws FileNotFoundException, ClassNotFoundException, IOException{
		int cont = 0;
		ArrayList<Pergunta> lista = arquivo.lerArquivoPerguntas(URL_PERGUNTAS);
		for(Pergunta p : lista){
			System.out.println("\t Nº da Pergunta: " + (cont + 1));
			System.out.println("Pergunta: " + p.getPergunta());
			System.out.println("Opção 01: " + p.getOpcao_01());
			System.out.println("Opção 02: " + p.getOpcao_02());
			System.out.println("Opção 03: " + p.getOpcao_02());
			System.out.println("Opção 04: " + p.getOpcao_02());
			System.out.println("Correta: " + p.getCorreta() + "\n\n");
			cont ++;
		}
	}
	
	public void excluirPergunta(int op) throws FileNotFoundException, ClassNotFoundException, IOException{
		arquivo.excluirPergunta(op, URL_PERGUNTAS);
	}
	
	public ArrayList<Pergunta> getArrayPerguntas() {
		return arrayPerguntas;
	}
	public String sucesso(String msg){
		return msg;
	}
}
