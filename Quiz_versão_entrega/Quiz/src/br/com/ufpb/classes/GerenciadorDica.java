package br.com.ufpb.classes;

import java.util.ArrayList;



public class GerenciadorDica {

	ArrayList<Dica> dicas;
	
	public GerenciadorDica(){
		dicas = new ArrayList<Dica>();
	}
	
	public void cadastrarDica(int id, String descricaoDaDica){
		dicas.add(new Dica(id, descricaoDaDica));
	}
	
	public ArrayList<Dica> getDica() {
		return dicas;
	}
	
	public void excluirDica(){
		String dicaAux = "";
		int i = 0;
		if(dicas.size() > 0){
			for (Dica dica : dicas) {
				i++;
				dicaAux += ((String.valueOf(i)) + " - " + dica.getId() + "\n");
			}
			int delete = 1;//Integer.parseInt(JOptionPane.showInputDialog("Qual dica quer excluir? \n" + dicaAux + "0 - Nenhum"));
			if(delete > 0 && delete <= i){
				dicas.remove(delete - 1);
				//JOptionPane.showMessageDialog(null, "Dica excluída com sucesso!");
			}else if(delete == 0){
				//JOptionPane.showMessageDialog(null, "Nenhuma dica excluída!");
			}else{
				//JOptionPane.showMessageDialog(null, "Opção inválida!");
				excluirDica();
			}
		}else{
			//JOptionPane.showMessageDialog(null, "Nenhuma dica cadastrada!");
		}
	}
	
	public void listarDicas(){
		//TODO		
	}
}
