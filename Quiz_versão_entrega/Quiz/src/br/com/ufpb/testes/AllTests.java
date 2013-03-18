package br.com.ufpb.testes;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ AlunoMetodosTest.class, ArquivoTest.class,
		AtualizacaoTest.class, JogarTest.class, PerguntaMetodosTest.class,
		RankTest.class })
public class AllTests {

}
