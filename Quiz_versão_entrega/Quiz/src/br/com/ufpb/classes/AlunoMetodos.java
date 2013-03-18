package br.com.ufpb.classes;

import java.util.ArrayList;


public class AlunoMetodos {
	
	ArrayList<Aluno> alunos;
	
	public AlunoMetodos() {
		alunos = new ArrayList();
	}
	
	/*
	 * Método cadastrarAluno recebe parâmetros para cadastrar um objeto 
	 * aluno no ArrayList<Aluno>
	 */
	public void cadastrarAluno(String nome, String matricula, int pontuacao){
		alunos.add(new Aluno(nome, matricula, pontuacao));
		//JOptionPane.showMessageDialog(null, "Pontuação: " + pontuacao);
	}
	
	/*
	 * Métodos listarAluno lista todos os Alunos no ArrayList<Aluno>
	 */
	public void listarAluno(){
		if(alunos.size() > 0){
			//JOptionPane.showMessageDialog(null,alunos.size() + " alunos cadastrados!");
			for (Aluno aluno : alunos) {
				//JOptionPane.showMessageDialog(null, "Nome: " + aluno.getNome() + "\nMatrícula: " + aluno.getMatricula());
			}
		}else{
			//JOptionPane.showMessageDialog(null, "Nenhum aluno cadastrado!");
		}
	}
	
	/*
	 * Método excluirAluno lista todos os alunos do ArrayList<Aluno>
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
				//JOptionPane.showMessageDialog(null, "Aluno excluído com sucesso!");
			}else if(delete == 0){
				//JOptionPane.showMessageDialog(null, "Nenhum aluno excluído!");
			}else{
				//JOptionPane.showMessageDialog(null, "Opção inválida!");
				excluirAluno();
			}
		}else{
			//JOptionPane.showMessageDialog(null, "Nenhum aluno cadastrado!");
		}
	}

	/*
	 * Método getter da classe
	 */
	public ArrayList<Aluno> getAlunos() {
		return alunos;
	}

}
