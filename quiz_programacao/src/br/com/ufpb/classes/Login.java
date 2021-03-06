package br.com.ufpb.classes;

import javax.swing.JOptionPane;

public class Login {
	
	private static final String ADM_NOME      = "adm";
	private static final String ADM_MATRICULA = "adm";
	
	GerenciadorProfessor gerenciadorP = new GerenciadorProfessor();
	Rank rank = new Rank();
	Jogar jogar = new Jogar();
	
	public Login() {
	}
	
	public void login(){
		String nome = JOptionPane.showInputDialog("Digite seu nome:");
		String matricula = JOptionPane.showInputDialog("Digite sua matricula:");
		if(nome.equals(ADM_NOME) && matricula.equals(ADM_MATRICULA)){
			gerenciadorP.menu();
		}else{
			int pontuacao = jogar.exibirPerguntas();
			this.rank.adicionarRank(nome, matricula, pontuacao);
			this.gerenciadorP.alunoM.cadastrarAluno(nome, matricula, pontuacao);
		}
	}

}
