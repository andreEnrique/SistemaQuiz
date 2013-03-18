package br.com.ufpb.ui;


import br.com.ufpb.classes.Aluno;
import br.com.ufpb.classes.Login;
import br.com.ufpb.classes.MenuPrincipal;
import br.com.ufpb.core.FController;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MenuQuizActivity extends Activity implements OnClickListener{
	/** Called when the activity is first created. */
	private Button jogar,instrucoes,ranking,sair;
	private Login login;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		login = new Login();
		jogar = (Button) findViewById(R.id.bt_jogar);
		jogar.setOnClickListener(this);
		instrucoes = (Button) findViewById(R.id.bt_instrucoes);
		instrucoes.setOnClickListener(this);
		sair = (Button) findViewById(R.id.bt_sair);
		sair.setOnClickListener(this);
		ranking = (Button) findViewById(R.id.bt_ranking);
		ranking.setOnClickListener(this);

	}
	public void onClick(View v) {
		switch(v.getId()){
		case R.id.bt_jogar:
			this.login();
			break;
		case R.id.bt_instrucoes:
			this.getInstrucoes();
			break;
		case R.id.bt_sair:
			finish();
			break;
		case R.id.bt_ranking:
			this.ranking();
			break;

		}

	}

	private void ranking() {
		Intent i = new Intent(MenuQuizActivity.this, RankingView.class);
		startActivity(i);
		
	}
	private void getInstrucoes(){
		this.getAlert(getString(R.string.intrucoes), getString(R.string.msg_instrucoes));
	
	}

	private String getMsgInstrucoes(){
		return "Instruções!\n\n Para jogar o quiz é muito fácil, basta você apertar em Jogar, daí abrirá duas janelas para você colocar seu nome e matrícula, respectivamente. Logo após é só começar a responder as perguntas,escolhendo a sua opção de 1 à 4, e depois aperte OK para confirmar.";
	}


	private void login(){
		
		Display display = ((WindowManager) getSystemService(this.WINDOW_SERVICE)).getDefaultDisplay();
		final Dialog dialog = new Dialog(MenuQuizActivity.this);

		dialog.setContentView(R.layout.login);
			
		dialog.getWindow().setLayout(display.getWidth(), display.getHeight()-50);
		dialog.setTitle("Login");

		final Button ok = (Button) dialog.findViewById(R.id.bt_login);
		final EditText et_nome = (EditText) dialog.findViewById(R.id.et_nome);
		final EditText et_matricula = (EditText) dialog.findViewById(R.id.et_mat);
		


		ok.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
					String nome = et_nome.getText().toString();
					String matricula = et_matricula.getText().toString();
					boolean sucess = login.login(nome, matricula);
					
					if(nome.equals("") || matricula.equals("")){
						getAlert("Login ou senha inválidos" ,"Digite o nome ou matrícula");
					}
								
					else if(sucess){
						Intent i = new Intent(MenuQuizActivity.this, MenuLogadoActivity.class);
						i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
						dialog.dismiss();
						startActivity(i);
					}
					else{
						FController.aluno = new Aluno(nome, matricula, 0);
						FController.getInstance().insertAluno(FController.aluno, MenuQuizActivity.this);
						Intent i = new Intent(MenuQuizActivity.this, JogoActivity.class);
						i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
						dialog.dismiss();
						startActivity(i);
					}
					
			}
		});

		dialog.show();//m
	}
	
	private void getAlert(String title, String msg){
		AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MenuQuizActivity.this);
		alertDialogBuilder.setTitle(title);
		alertDialogBuilder
		.setMessage(msg)
		.setCancelable(false)
		.setPositiveButton("OK",new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog,int id) {
				dialog.dismiss();
			}
		});
		AlertDialog alertDialog = alertDialogBuilder.create();
		alertDialog.show();
		
	}
		
}

