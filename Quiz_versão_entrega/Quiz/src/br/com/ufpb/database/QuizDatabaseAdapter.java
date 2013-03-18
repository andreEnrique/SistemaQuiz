package br.com.ufpb.database;

import java.util.ArrayList;
import java.util.List;

import br.com.ufpb.classes.Aluno;
import br.com.ufpb.classes.Pergunta;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class QuizDatabaseAdapter {
	private static final String PERGUNTA = "pergunta";
	private static final String ALUNO = "aluno";
	
	private SQLiteDatabase database;
	private QuizDatabaseHelper dbHelper;
	private Context context;
	
	public QuizDatabaseAdapter(Context context) {
		this.context = context;
	}

	public QuizDatabaseAdapter open() throws SQLException {
		dbHelper = new QuizDatabaseHelper(context);
		database = dbHelper.getWritableDatabase();
		return this;
	}
	
	public void close() {
		dbHelper.close();
	}
	
	public List<Pergunta> buscarListaPergunta() {
		Cursor cursor = database.query(PERGUNTA,
				new String[] { "id", "pergunta", "op1", "op2", "op3", "op4", "correta"},null,null, null, null, null);

		if (cursor.moveToFirst()) {
			List<Pergunta> perguntas = new ArrayList<Pergunta>();
			do {
				Pergunta pergunta = new Pergunta(
						cursor.getInt(0), 
						cursor.getString(1),
						cursor.getString(2),
						cursor.getString(3),
						cursor.getString(4),
						cursor.getString(5),
						cursor.getString(6));
						 
						
				perguntas.add(pergunta);
			} while (cursor.moveToNext());
			cursor.close();
			return perguntas;
		}
		if (cursor != null)
			cursor.close();
		return null;
	}
	
	public long criarPergunta(Pergunta p){
		try{
			ContentValues values = new ContentValues();
			values.put("pergunta", p.getPergunta());
			values.put("op1", p.getOp_01());
			values.put("op2", p.getOp_02());
			values.put("op3", p.getOp_03());
			values.put("op4", p.getOp_04());
			values.put("correta", p.getCorreta());
			return database.insert(PERGUNTA, null, values);

		}catch(Exception e){
			Log.e("QUIZ", e.getMessage(), e);
		}
		return -1;

	}
	
	public long updatePergunta(Pergunta p) {
		try {
			ContentValues values = new ContentValues();
			values.put("id", p.getId());
			values.put("pergunta", p.getPergunta());
			values.put("op1", p.getOp_01());
			values.put("op2", p.getOp_02());
			values.put("op3", p.getOp_03());
			values.put("op4", p.getOp_04());
			values.put("correta", p.getCorreta());
			return database.update(PERGUNTA, values, "id = " + p.getId(), null);
		} catch (SQLiteConstraintException e) {
			return -1;
		}
	}
	
	public void deletarPergunta(Pergunta p){
		database.delete(PERGUNTA, "id = " + p.getId(),null);
	}
	
	public void deletarAluno(Aluno a){
		database.delete(ALUNO, "id = " + a.getId(),null);
	}
	
	public List<Aluno> buscarRankingAlunos() {
		Cursor cursor = database.query(ALUNO,
				new String[] { "id", "nome", "matricula", "pontuacao"},null,null, null, null, "pontuacao DESC");

		if (cursor.moveToFirst()) {
			List<Aluno> alunos= new ArrayList<Aluno>();
			do {
				Aluno aluno = new Aluno(
						cursor.getInt(0), 
						cursor.getString(1),
						cursor.getString(2),
						cursor.getInt(3));
						
						 
						
				alunos.add(aluno);
			} while (cursor.moveToNext());
			cursor.close();
			return alunos;
		}
		if (cursor != null)
			cursor.close();
		return null;
	}
	
	public List<Aluno> buscarListaAlunos() {
		Cursor cursor = database.query(ALUNO,
				new String[] { "id", "nome", "matricula", "pontuacao"},null,null, null, null, null);

		if (cursor.moveToFirst()) {
			List<Aluno> alunos= new ArrayList<Aluno>();
			do {
				Aluno aluno = new Aluno(
						cursor.getInt(0), 
						cursor.getString(1),
						cursor.getString(2),
						cursor.getInt(3));
						
						 
						
				alunos.add(aluno);
			} while (cursor.moveToNext());
			cursor.close();
			return alunos;
		}
		if (cursor != null)
			cursor.close();
		return null;
	}
	
	public long criarAluno(Aluno a){
		try{
			ContentValues values = new ContentValues();
			values.put("nome", a.getNome());
			values.put("matricula", a.getMatricula());
			values.put("pontuacao", a.getPontuacao());
			return database.insert(ALUNO, null, values);

		}catch(Exception e){
			Log.e("QUIZ", e.getMessage(), e);
		}
		return -1;

	}
	
	
	public long updateAluno(Aluno a) {
		
		try {
			ContentValues values = new ContentValues();
			values.put("id", a.getId());
			values.put("nome", a.getNome());
			values.put("matricula", a.getMatricula());
			values.put("pontuacao", a.getPontuacao());
			return database.update(ALUNO, values, "id = " + a.getId(), null);
		} catch (SQLiteConstraintException e) {
			return -1;
		}
	}
	
	public Aluno buscarAlunoPorMatricula(String matricula) {
		Cursor cursor = database.query(ALUNO,
				new String[] { "id", "nome", "matricula", "pontuacao"},
				"matricula LIKE '%" + matricula+ "%'",
				null, null, null, null);

		if (cursor.moveToFirst()) {
			Aluno aluno = null;
			do {
				aluno = new Aluno(
						cursor.getInt(0), 
						cursor.getString(1),
						cursor.getString(2),
						cursor.getInt(3));
			} while (cursor.moveToNext());
			cursor.close();
			return aluno;
		}
		if (cursor != null)
			cursor.close();
		return null;
	}
	
	public Pergunta buscarPerguntaPorNome(String nome) {
		Cursor cursor = database.query(PERGUNTA,
				new String[] { "id", "pergunta", "op1", "op2", "op3", "op4", "correta"},
				"pergunta LIKE '%" +nome + "%'",
				null, null, null, null);

		if (cursor.moveToFirst()) {
			Pergunta pergunta = null;
			do {
				pergunta = new Pergunta(
						cursor.getInt(0), 
						cursor.getString(1),
						cursor.getString(2),
						cursor.getString(3),
						cursor.getString(4),
						cursor.getString(5),
						cursor.getString(6));
			} while (cursor.moveToNext());
			cursor.close();
			return pergunta;
		}
		if (cursor != null)
			cursor.close();
		return null;
	}



}
