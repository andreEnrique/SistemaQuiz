package br.com.ufpb.classes;

import java.io.Serializable;

public class Dica implements Serializable{

	private int id;
	private String descricaoDaDica;

	
	public Dica(int id, String olhaDica){
		this.id=id;
		this.descricaoDaDica=descricaoDaDica;	
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getdescricaoDaDica() {
		return descricaoDaDica;
	}

	public void setdescricaoDaDica(String descricaoDaDica) {
		this.descricaoDaDica = descricaoDaDica;
	}
	
	
}