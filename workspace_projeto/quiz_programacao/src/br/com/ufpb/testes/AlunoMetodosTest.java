package br.com.ufpb.testes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import br.com.ufpb.classes.AlunoMetodos;

public class AlunoMetodosTest {

	AlunoMetodos alunoMetodos;
	
	@Before
	public void setUp() throws Exception {
		alunoMetodos = new AlunoMetodos();
	}

	@Test
	public void testCadastrarAluno() {
		alunoMetodos.cadastrarAluno("kelson", "81011028", 0);
		assertEquals(1, alunoMetodos.getAlunos().size());
	}

//	@Test
//	public void testListarAluno() {
//		fail("Not yet implemented");
//	}

	@Test
	public void testExcluirAluno() {
		alunoMetodos.cadastrarAluno("kelson", "81011028", 0);
		alunoMetodos.excluirAluno();
		assertEquals(0, alunoMetodos.getAlunos().size());
	}

}
