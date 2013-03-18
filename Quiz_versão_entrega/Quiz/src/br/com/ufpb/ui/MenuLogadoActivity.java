package br.com.ufpb.ui;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class MenuLogadoActivity extends Activity implements android.view.View.OnClickListener{

	private Button cadastrarPergunta, listarPerguntas,listarAlunos,estatistica, menuprincipal, bt_qtd, salvarRepostas;
	private int tela;
	private EditText et_qtd;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		principal();
	}

	private void principal() {
		setContentView(R.layout.principal_logado);
		tela = 0;
		cadastrarPergunta = (Button) findViewById(R.id.bt_cadastro_perguntas);
		cadastrarPergunta.setOnClickListener(this);
		listarPerguntas = (Button) findViewById(R.id.bt_listar_perguntas); 
		listarPerguntas.setOnClickListener(this);
		listarAlunos = (Button) findViewById(R.id.bt_listar_alunos);
		listarAlunos.setOnClickListener(this);
		
	}	

	@Override
	public void onBackPressed() {

		if(tela==0){
			Intent i = new Intent(MenuLogadoActivity.this, MenuQuizActivity.class);
			i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(i);
		}
		else{
			this.principal();
		}
	}

	public void onClick(View v) {
		tela = 1;
		Intent i;
		switch(v.getId()){
		case R.id.bt_cadastro_perguntas:
			getQuantidadePerguntas();
			break;
		case R.id.bt_listar_perguntas:
			i = new Intent(MenuLogadoActivity.this, PerguntasView.class);
			startActivity(i);
			break;
		case R.id.bt_listar_alunos:
			i = new Intent(MenuLogadoActivity.this, AlunosView.class);
			startActivity(i);
			break;
		}
	}

	private void getQuantidadePerguntas() {
		final AlertDialog.Builder alert = new AlertDialog.Builder(MenuLogadoActivity.this);
		final EditText in = new EditText(this);
		in.setInputType(InputType.TYPE_CLASS_NUMBER);
		alert.setMessage("Quantas perguntas deseja cadastrar?");
		alert.setView(in);
		alert.setPositiveButton("Cadastrar", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int whichButton) {
				Editable nome = in.getText();
				if(nome.toString().equals("")){
					final AlertDialog.Builder alert = new AlertDialog.Builder(MenuLogadoActivity.this);
					alert.setTitle("Aviso");
					alert.setMessage("Número Inválido");
					alert.setPositiveButton("OK", new OnClickListener() {
						
						public void onClick(DialogInterface d, int arg1) {
								d.dismiss();
							
						}
					});
					alert.show();
				}
				else{
					Intent i = new Intent(MenuLogadoActivity.this, CadastrarPerguntasActivity.class);
					Bundle b = new Bundle();
					b.putInt("qtd", Integer.parseInt(nome.toString()));
					i.putExtras(b);
					startActivity(i);
				}
							
			}
		});

		alert.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int whichButton) {
				// Canceled.
			}
		});

		alert.show();

		
	}
}
