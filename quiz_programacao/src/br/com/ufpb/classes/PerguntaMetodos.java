package br.com.ufpb.classes;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class PerguntaMetodos {

	ArrayList<Pergunta> perguntas;
	
	public PerguntaMetodos() {
		perguntas = new ArrayList<>();
	}
	
	/*
	 * M�todo cadastrarPergunta cadastra uma Pergunta no ArrayList<Pergunta>
	 */
	public void cadastrarPergunta(){
		String pergunta = JOptionPane.showInputDialog("Digite a pergunta: ");
		String op01 = JOptionPane.showInputDialog("Digite a op��o 01: ");
		String op02 = JOptionPane.showInputDialog("Digite a op��o 02: ");
		String op03 = JOptionPane.showInputDialog("Digite a op��o 03: ");
		String op04 = JOptionPane.showInputDialog("Digite a op��o 04: ");
		String correta = JOptionPane.showInputDialog("Digite a alternativa correta: \n\n1 - " + op01 + "\n2 - " + op02 + "\n3 - " + op03 + "\n4 - " + op04);
		if(Integer.parseInt(correta) > 0 && Integer.parseInt(correta) <= 4){
			perguntas.add(new Pergunta(pergunta, op01, op02, op03, op04, correta));
			JOptionPane.showMessageDialog(null, "Pergunta cadastrada com sucesso!");
		}else{
			while(!(Integer.parseInt(correta) > 0 && Integer.parseInt(correta) <= 4)){
				JOptionPane.showMessageDialog(null, "Op��o inv�lida!");
				correta = JOptionPane.showInputDialog("Digite a alternativa correta: \n\n1 - " + op01 + "\n2 - " + op02 + "\n3 - " + op03 + "\n4 - " + op04);	
			}
			perguntas.add(new Pergunta(pergunta, op01, op02, op03, op04, correta));
			JOptionPane.showMessageDialog(null, "Pergunta cadastrada com sucesso!");
		}
		
	}
	
	/*
	 * M�todo listarPergunta lista todas as Pergunta no ArrayList<Pergunta>
	 */
	public void listarPergunta(){
		if(perguntas.size() > 0){
			JOptionPane.showMessageDialog(null,perguntas.size() + " perguntas cadastradas!");
			for (Pergunta pergunta : perguntas) {
				JOptionPane.showMessageDialog(null, "Pergunta: " + pergunta.getPergunta() + "\n\nOp��o 01: " + pergunta.getOp_01() + "\nOp��o 02: " + pergunta.getOp_02() + "\nOp��o 03: " + pergunta.getOp_03() + "\nOp��o 04: " + pergunta.getOp_04() + "\n\nOp��o correta: 0" + pergunta.getCorreta());
			}
		}else{
			JOptionPane.showMessageDialog(null, "Nenhuma pergunta cadastrada!");
		}
	}
	
	/*
	 * M�todo excluirPergunta lista todas as perguntas do ArrayList<Pergunta>
	 * para depois excluir uma Pergunta desejada.
	 */
	public void excluirPergunta(){
		String perguntaAux = "";
		int i = 0;
		if(perguntas.size() > 0){
			for (Pergunta pergunta : perguntas) {
				i++;
				perguntaAux += ((String.valueOf(i)) + " - " + pergunta.getPergunta() + "\n");
			}
			int delete = Integer.parseInt(JOptionPane.showInputDialog("Qual pergunta deseja excluir? \n" + perguntaAux + "0 - Nenhuma"));
			if(delete > 0 && delete <= i){
				perguntas.remove(delete - 1);
				JOptionPane.showMessageDialog(null, "Pergunta exclu�da com sucesso!");
			}else if(delete == 0){
				JOptionPane.showMessageDialog(null, "Nenhuma pergunta exclu�da!");
			}else{
				JOptionPane.showMessageDialog(null, "Op��o inv�lida!");
				excluirPergunta();
			}
			
		}else{
			JOptionPane.showMessageDialog(null, "Nenhuma pergunta cadastrada!");
		}
	}
	
	/*
	 * M�todo getter da classe
	 */
	public ArrayList<Pergunta> getPerguntas() {
		return perguntas;
	}

}
