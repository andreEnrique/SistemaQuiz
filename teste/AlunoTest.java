package teste;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import quizClasses.Aluno;

public class AlunoTest {

	Aluno aluno;
	
	@Before
	public void setUp() throws Exception {
		aluno = new Aluno();
		aluno.setNome("kelson");
		aluno.setIdade("21");
		aluno.setMatricula("81011028");
	}

	@Test
	public void testGetNome() {
		Assert.assertEquals("kelson",aluno.getNome());
	}

	@Test
	public void testSetNome() {
		aluno.setNome("Zé Ninguém");
		Assert.assertEquals("Zé Ninguém",aluno.getNome());
	}

	@Test
	public void testGetIdade() {
		Assert.assertEquals("21",aluno.getIdade());
	}

	@Test
	public void testSetIdade() {
		aluno.setIdade("00");
		Assert.assertEquals("00",aluno.getIdade());
	}

	@Test
	public void testGetMatricula() {
		Assert.assertEquals("81011028",aluno.getMatricula());
	}

	@Test
	public void testSetMatricula() {
		aluno.setMatricula("00000000");
		Assert.assertEquals("00000000",aluno.getMatricula());
	}

}
