package br.com.ufpb.classes;

import java.util.ArrayList;


public class AlunoMetodos {
	
	ArrayList<Aluno> alunos;
	
	public AlunoMetodos() {
		alunos = new ArrayList();
	}
	
	/*
	 * M�todo cadastrarAluno recebe par�metros para cadastrar um objeto 
	 * aluno no ArrayList<Aluno>
	 */
	public void cadastrarAluno(String nome, String matricula, int pontuacao){
		alunos.add(new Aluno(nome, matricula, pontuacao));
		//JOptionPane.showMessageDialog(null, "Pontua��o: " + pontuacao);
	}
	
	/*
	 * M�todos listarAluno lista todos os Alunos no ArrayList<Aluno>
	 */
	public void listarAluno(){
		if(alunos.size() > 0){
			//JOptionPane.showMessageDialog(null,alunos.size() + " alunos cadastrados!");
			for (Aluno aluno : alunos) {
				//JOptionPane.showMessageDialog(null, "Nome: " + aluno.getNome() + "\nMatr�cula: " + aluno.getMatricula());
			}
		}else{
			//JOptionPane.showMessageDialog(null, "Nenhum aluno cadastrado!");
		}
	}
	
	/*
	 * M�todo excluirAluno lista todos os alunos do ArrayList<Aluno>
	 * para depois excluir um Aluno desejado.
	 */
	public void excluirAluno(){
		String alunoAux = "";
		int i = 0;
		if(alunos.size() > 0){
			for (Aluno aluno : alunos) {
				i++;
				alunoAux += ((String.valueOf(i)) + " - " + aluno.getNome() + "\n");
			}
			int delete = 1;//Integer.parseInt(JOptionPane.showInputDialog("Qual aluno deseja excluir? \n" + alunoAux + "0 - Nenhum"));
			if(delete > 0 && delete <= i){
				alunos.remove(delete - 1);
				//JOptionPane.showMessageDialog(null, "Aluno exclu�do com sucesso!");
			}else if(delete == 0){
				//JOptionPane.showMessageDialog(null, "Nenhum aluno exclu�do!");
			}else{
				//JOptionPane.showMessageDialog(null, "Op��o inv�lida!");
				excluirAluno();
			}
		}else{
			//JOptionPane.showMessageDialog(null, "Nenhum aluno cadastrado!");
		}
	}

	/*
	 * M�todo getter da classe
	 */
	public ArrayList<Aluno> getAlunos() {
		return alunos;
	}

}
