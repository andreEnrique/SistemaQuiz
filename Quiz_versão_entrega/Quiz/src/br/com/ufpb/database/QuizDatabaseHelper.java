package br.com.ufpb.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class QuizDatabaseHelper extends SQLiteOpenHelper{
	
	private static final String DATABASE_NAME = "quiz";
	private static final int DATABASE_VERSION = 4;
	
	
	private static final String PERGUNTA_CREATE = 
			"CREATE TABLE pergunta(" +
				"id INTEGER PRIMARY KEY," +	
				"pergunta TEXT," +
				"op1 TEXT," +
				"op2 TEXT," +
				"op3 TEXT," +
				"op4 TEXT," +
				"correta TEXT" +
				");";
	private static final String ALUNO_CREATE = 
			"CREATE TABLE aluno(" +
				"id INTEGER PRIMARY KEY," +	
				"nome TEXT," +
				"matricula TEXT," +
				"pontuacao INTEGER" +
				");";
	
	
	
	public QuizDatabaseHelper(Context context){
		super(context, DATABASE_NAME, null, DATABASE_VERSION);

	}

	@Override
	public void onCreate(SQLiteDatabase database) {
		database.execSQL(PERGUNTA_CREATE);
		database.execSQL(ALUNO_CREATE);
		
	}
	@Override
	public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion) {
		database.execSQL("DROP TABLE IF EXISTS pergunta;");
		database.execSQL("DROP TABLE IF EXISTS aluno;");
		onCreate(database);
		
	}

}
