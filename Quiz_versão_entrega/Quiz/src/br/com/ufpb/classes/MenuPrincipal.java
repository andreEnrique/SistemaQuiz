package br.com.ufpb.classes;

import java.io.FileNotFoundException;
import java.io.IOException;


public class MenuPrincipal {
	
	Login 	login 			= new Login()  	;
	Arquivo arquivo 		= new Arquivo()	;
	Atualizacao atualizacao = new Atualizacao();
	
	public MenuPrincipal() {
		login.rank.rankeados = atualizacao.atualizarRank();
	}
	
	public void menuPrincipal(){
		String op ="";// JOptionPane.showInputDialog("1 - Jogar.\n2 - Rank.\n3 - Instru��es.\n4 - Sair.");
		if(op.equals("1")){
			login.login();
			menuPrincipal();
		}else if(op.equals("2")){
			login.rank.mostrarRank();
			menuPrincipal();
		}else if(op.equals("3")){
			//JOptionPane.showMessageDialog(null, "                        Instru��es!				\n\n   Para  jogar  o  quiz  �  muito  f�cil,  basta\nvoc�  apertar  em  Jogar, da�  abrir�  duas\njanelas   para  voc�  colocar  seu  nome  e \nmatr�cula, respectivamente. Logo  ap�s  �\ns�  come�ar  a  responder  as  perguntas,\nescolhendo a sua op��o de 1 � 4, e depois \naperte OK para confirmar.");
			menuPrincipal();
		}else if(op.equals("4")){
//			try {
//				arquivo.escreverAluno(login.gerenciadorP.alunoM.alunos);
//				arquivo.escreverRank(login.rank.rankeados);
//				JOptionPane.showMessageDialog(null, "Obrigado por utilizar o nosso software!");
//			} catch (FileNotFoundException e) {
//				e.printStackTrace();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
		}else{
			//JOptionPane.showMessageDialog(null, "Op��o inv�lida!");
			menuPrincipal();
		}
	}
	
	public static String getInstrucoes(){
		return "Instru��es!\n\n Para  jogar  o  quiz  �  muito  f�cil,  basta\nvoc�  apertar  em  Jogar, da�  abrir�  duas\njanelas   para  voc�  colocar  seu  nome  e \nmatr�cula, respectivamente. Logo  ap�s  �\ns�  come�ar  a  responder  as  perguntas,\nescolhendo a sua op��o de 1 � 4, e depois \naperte OK para confirmar.";
	}

}
