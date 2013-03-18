package br.com.ufpb	.core;

import java.util.List;

import android.content.Context;
import br.com.ufpb.classes.Aluno;
import br.com.ufpb.classes.Pergunta;
import br.com.ufpb.database.QuizDatabaseAdapter;

public class FController {
	private static FController instance = null;
	public static Aluno aluno;
	public static Pergunta pergunta;
	

	private FController(){

	}

	public static FController getInstance(){
		if(instance == null)
			instance = new FController();
		return instance;

	}
	
	public List<Pergunta> buscarListaPerguntas(Context context){
		QuizDatabaseAdapter dbHelper = new QuizDatabaseAdapter(context);
		dbHelper.open();
		List<Pergunta> perguntas = dbHelper.buscarListaPergunta();
		dbHelper.close();
		return perguntas;
	}
	
	public synchronized void insertPergunta(Pergunta p, Context context) {
		QuizDatabaseAdapter dbHelper = new QuizDatabaseAdapter(context);
		dbHelper.open();
		dbHelper.criarPergunta(p);
		dbHelper.close();
	}
	
	public List<Aluno> buscarListaAluno(Context context){
		QuizDatabaseAdapter dbHelper = new QuizDatabaseAdapter(context);
		dbHelper.open();
		List<Aluno> alunos = dbHelper.buscarListaAlunos();
		dbHelper.close();
		return alunos;
	}
	
	public List<Aluno> buscarRankingAluno(Context context){
		QuizDatabaseAdapter dbHelper = new QuizDatabaseAdapter(context);
		dbHelper.open();
		List<Aluno> alunos = dbHelper.buscarRankingAlunos();
		dbHelper.close();
		return alunos;
	}
	
	public synchronized void insertAluno(Aluno a, Context context) {
		QuizDatabaseAdapter dbHelper = new QuizDatabaseAdapter(context);
		dbHelper.open();
		dbHelper.criarAluno(a);
		dbHelper.close();
	}
	
	public synchronized void updateAluno(Aluno a, Context context) {
		QuizDatabaseAdapter dbHelper = new QuizDatabaseAdapter(context);
		dbHelper.open();
		dbHelper.updateAluno(a);
		dbHelper.close();
	}
	
	public synchronized void updatePergunta(Pergunta p, Context context) {
		QuizDatabaseAdapter dbHelper = new QuizDatabaseAdapter(context);
		dbHelper.open();
		dbHelper.updatePergunta(p);
		dbHelper.close();
	}
	
	public synchronized void deletarPergunta(Pergunta p, Context context) {
		QuizDatabaseAdapter dbHelper = new QuizDatabaseAdapter(context);
		dbHelper.open();
		dbHelper.deletarPergunta(p);
		dbHelper.close();
	}
	
	public synchronized void deletarAluno(Aluno a, Context context) {
		QuizDatabaseAdapter dbHelper = new QuizDatabaseAdapter(context);
		dbHelper.open();
		dbHelper.deletarAluno(a);
		dbHelper.close();
	}

	public Aluno buscarAlunoPorMatricula(String matricula, Context context) {
		QuizDatabaseAdapter dbHelper = new QuizDatabaseAdapter(context);
		dbHelper.open();
		Aluno aluno = dbHelper.buscarAlunoPorMatricula(matricula);
		dbHelper.close();
		return aluno;
	}
	
	public Pergunta buscarPerguntaPorNome(String nome, Context context) {
		QuizDatabaseAdapter dbHelper = new QuizDatabaseAdapter(context);
		dbHelper.open();
		Pergunta pergunta = dbHelper.buscarPerguntaPorNome(nome);
		dbHelper.close();
		return pergunta;
	}
}

