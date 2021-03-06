package br.com.ufpb.testes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import br.com.ufpb.classes.PerguntaMetodos;

public class PerguntaMetodosTest {

	PerguntaMetodos perguntaMetodos;
	
	@Before
	public void setUp() throws Exception {
		perguntaMetodos = new PerguntaMetodos();
	}

	@Test
	public void testCadastrarPergunta() {
		perguntaMetodos.cadastrarPergunta();
		assertEquals(1, perguntaMetodos.getPerguntas().size());
	}

//	@Test
//	public void testListarPergunta() {
//		fail("Not yet implemented");
//	}

	@Test
	public void testExcluirPergunta() {
		perguntaMetodos.cadastrarPergunta();
		perguntaMetodos.excluirPergunta();
		assertEquals(0, perguntaMetodos.getPerguntas().size());
	}

}
