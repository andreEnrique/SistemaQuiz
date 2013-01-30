package Teste;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import QuizClasses.Pergunta;

public class PerguntaTeste {

	Pergunta pergunta;
	
	
	@Before
	public void setUp() throws Exception {
		
		pergunta = new Pergunta ("Teste","op1","op2","op3","op4","correta");
	}

	@Test
	public void testGetPergunta() {
		Assert.assertEquals("Teste", pergunta.getPergunta());
		
	}

	@Test
	public void testSetPergunta() {
		pergunta.setPergunta("Oi");
		Assert.assertEquals("Oi", pergunta.getPergunta());
	}

	@Test
	public void testGetOpcao_01() {
		Assert.assertEquals("op1", pergunta.getOpcao_01());
	}

	@Test
	public void testSetOpcao_01() {
		pergunta.setPergunta("op1");
		Assert.assertEquals("op1", pergunta.getOpcao_01());
	}

	@Test
	public void testGetOpcao_02() {
		Assert.assertEquals("op2", pergunta.getOpcao_02());
	}

	@Test
	public void testSetOpcao_02() {
		pergunta.setPergunta("op2");
		Assert.assertEquals("op2", pergunta.getOpcao_02());
	}

	@Test
	public void testGetOpcao_03() {
		Assert.assertEquals("op3", pergunta.getOpcao_03());
	}

	@Test
	public void testSetOpcao_03() {
		pergunta.setPergunta("op3");
		Assert.assertEquals("op3", pergunta.getOpcao_03());
	}

	@Test
	public void testGetOpcao_04() {
		Assert.assertEquals("op4", pergunta.getOpcao_04());
	}

	@Test
	public void testSetOpcao_04() {
		pergunta.setPergunta("op4");
		Assert.assertEquals("op4", pergunta.getOpcao_04());
	}


	@Test
	public void testGetCorreta() {
		Assert.assertEquals("correta", pergunta.getCorreta());
	}

	@Test
	public void testSetCorreta() {
		pergunta.setPergunta("correta");
		Assert.assertEquals("correta", pergunta.getCorreta());
	}

}
