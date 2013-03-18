package br.com.ufpb.classes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;



public class Rank {

	List<Aluno> rankeados;
	
	public Rank() {
		rankeados = new ArrayList();
	}
	
	public void mostrarRank(){
		String aux = "";
		Collections.sort(this.rankeados);
		List<Aluno> listAux = this.rankeados;
		for (Aluno aluno : listAux) {
			aux += (aluno.getNome() + "          " + aluno.getPontuacao() + "\n");
		}
		//JOptionPane.showMessageDialog(null,"               RANK\n\n" + aux);
	}
	
	public void adicionarRank(String nome, String matricula,int pontuacao){
		this.rankeados.add(new Aluno(nome, matricula, pontuacao));
	}
}
