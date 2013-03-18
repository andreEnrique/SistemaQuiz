package br.com.ufpb.classes;

import java.io.Serializable;

/*
 * Classe Pergunta
 * Implementa a interface Serializable
 */
@SuppressWarnings("serial")
public class Pergunta implements Serializable{
	
	/*
	 * Atributos da classe.
	 */
	private int id;
	private String pergunta;
	private String op_01;
	private String op_02;
	private String op_03;
	private String op_04;
	private String correta;
	
	/*
	 * Construtor da classe(vazio).
	 */
	public Pergunta() {
	}
	
	/*
	 * Construtor da classe(recebe parâmetros para ser atribuidos aos atributos da classe).
	 */
	public Pergunta(String pergunta, String op01, String op02, String op03, String op04, String correta) {
		setPergunta(pergunta);
		setOp_01(op01);
		setOp_02(op02);
		setOp_03(op03);
		setOp_04(op04);
		setCorreta(correta);
	}
	
	public Pergunta(int id, String pergunta, String op01, String op02, String op03, String op04, String correta) {
		setId(id);
		setPergunta(pergunta);
		setOp_01(op01);
		setOp_02(op02);
		setOp_03(op03);
		setOp_04(op04);
		setCorreta(correta);
	}

	/*
	 * Métodos getters e setters da classe.
	 */
	public String getPergunta() {
		return pergunta;
	}

	public void setPergunta(String pergunta) {
		this.pergunta = pergunta;
	}

	public String getOp_01() {
		return op_01;
	}

	public void setOp_01(String op_01) {
		this.op_01 = op_01;
	}

	public String getOp_02() {
		return op_02;
	}

	public void setOp_02(String op_02) {
		this.op_02 = op_02;
	}

	public String getOp_03() {
		return op_03;
	}

	public void setOp_03(String op_03) {
		this.op_03 = op_03;
	}

	public String getOp_04() {
		return op_04;
	}

	public void setOp_04(String op_04) {
		this.op_04 = op_04;
	}

	public String getCorreta() {
		return correta;
	}

	public void setCorreta(String correta) {
		this.correta = correta;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}
