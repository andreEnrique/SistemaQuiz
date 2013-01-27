import java.io.Serializable;

public class Pergunta implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private String pergunta;
	private String opcao_01;
	private String opcao_02;
	private String opcao_03;
	private String opcao_04;
	private String correta;
	
	public Pergunta(String pergunta, String op01, String op02, 
			String op03, String op04, String correta) {
		setPergunta(pergunta);
		setOpcao_01(op01);
		setOpcao_02(op02);
		setOpcao_03(op03);
		setOpcao_04(op04);
		setCorreta(correta);
	}
	
	public String getPergunta() {
		return pergunta;
	}
	public void setPergunta(String pergunta) {
		this.pergunta = pergunta;
	}
	public String getOpcao_01() {
		return opcao_01;
	}
	public void setOpcao_01(String opcao_01) {
		this.opcao_01 = opcao_01;
	}
	public String getOpcao_02() {
		return opcao_02;
	}
	public void setOpcao_02(String opcao_02) {
		this.opcao_02 = opcao_02;
	}
	public String getOpcao_03() {
		return opcao_03;
	}
	public void setOpcao_03(String opcao_03) {
		this.opcao_03 = opcao_03;
	}
	public String getOpcao_04() {
		return opcao_04;
	}
	public void setOpcao_04(String opcao_04) {
		this.opcao_04 = opcao_04;
	}
	public String getCorreta() {
		return correta;
	}
	public void setCorreta(String correta) {
		this.correta = correta;
	}
	
	
}
