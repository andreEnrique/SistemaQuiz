package br.com.ufpb.classes;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Jogar {

	Arquivo arquivo = new Arquivo();
	
	List<Pergunta> perguntasAux;
	
	public Jogar() {
		perguntasAux = new ArrayList<>();
	}
	
	public int exibirPerguntas(){
		int pontuacao = 0;
		String op = "";
		try {
			perguntasAux = arquivo.lerPergunta();
			for (Pergunta pergunta : perguntasAux) {
				op = JOptionPane.showInputDialog(pergunta.getPergunta() + "\n\n1 - " + pergunta.getOp_01() + "\n2 - " + pergunta.getOp_02() + "\n3 - " + pergunta.getOp_03() + "\n4 - " + pergunta.getOp_04());
				if(Integer.parseInt(op) > 0 && Integer.parseInt(op) <= 4){
					if(op.equals(pergunta.getCorreta())){
						pontuacao += 5;
					}
				}else{
					while(!(Integer.parseInt(op) > 0 && Integer.parseInt(op) <= 4)){
						JOptionPane.showMessageDialog(null, "Opção inválida!");
						op = JOptionPane.showInputDialog(pergunta.getPergunta() + "\n\n1 - " + pergunta.getOp_01() + "\n2 - " + pergunta.getOp_02() + "\n3 - " + pergunta.getOp_03() + "\n4 - " + pergunta.getOp_04());
					}
					if(op.equals(pergunta.getCorreta())){
						pontuacao += 5;
					}
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return pontuacao;
	}
}
