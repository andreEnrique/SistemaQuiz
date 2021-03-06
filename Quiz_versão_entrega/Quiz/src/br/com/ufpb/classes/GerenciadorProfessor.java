package br.com.ufpb.classes;

import java.io.FileNotFoundException;
import java.io.IOException;



public class GerenciadorProfessor {
	
	Arquivo 		arquivo	    = new Arquivo();
	Atualizacao		atualizacao = new Atualizacao();
	AlunoMetodos    alunoM      = new AlunoMetodos();
	PerguntaMetodos perguntaM   = new PerguntaMetodos();
	
	public GerenciadorProfessor() {
		alunoM.alunos		= atualizacao.atualizarAlunos();
		perguntaM.perguntas = atualizacao.atualizarPergutas();
	}
	
	public void menu(){
		String op = "1";//JOptionPane.showInputDialog("1 - Cadastrar Pergunta\n2 - Listar Pergunta\n3 - Excluir Pergunta\n4 - Listar Aluno\n5 - Excluir Aluno\n6 - Estat�sticas\n7 - Menu Principal");
		if(op.equals("1")){
			perguntaM.cadastrarPergunta();
			menu();
		}else if(op.equals("2")){
			perguntaM.listarPergunta();
			menu();
		}else if(op.equals("3")){
			perguntaM.excluirPergunta();
			menu();
		}else if(op.equals("4")){
			alunoM.listarAluno();
			menu();
		}else if(op.equals("5")){
			alunoM.excluirAluno();
			menu();
		}else if(op.equals("6")){
			//JOptionPane.showMessageDialog(null, "Estat�sticas!");
			menu();
		}else if(op.equals("7")){
//			try {
////				arquivo.escreverAluno(alunoM.alunos);
//				//arquivo.escreverPergunta(perguntaM.perguntas);
//			} catch (FileNotFoundException e) {
//				e.printStackTrace();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
		}else{
			//JOptionPane.showMessageDialog(null, "Op��o inv�lida!");
			menu();
		}
	}

}
