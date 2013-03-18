package br.com.ufpb.ui;


import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import br.com.ufpb.classes.Aluno;
import br.com.ufpb.classes.Pergunta;
import br.com.ufpb.core.FController;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class JogoActivity extends Activity implements android.view.View.OnClickListener {
	private TextView pergunta;
	private List<Pergunta> listaPerguntas, listaAux;
	private Button ok;
	private RadioButton resposta1, resposta2, resposta3, resposta4;
	private RadioGroup radioGroupResposta;
	private Pergunta p, perguntaAtual,perguntaAnterior = null;
	private int pontos, tamanhoLista, cont;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.perguntas);
		cont = 0;
		ok = (Button) findViewById(R.id.botaoOk);
		ok.setOnClickListener(this);
		radioGroupResposta = (RadioGroup) findViewById(R.id.radioRespostas);
		listaPerguntas = FController.getInstance().buscarListaPerguntas(JogoActivity.this);
		listaAux = new LinkedList<Pergunta>();
		tamanhoLista = listaPerguntas.size();
		pergunta = (TextView) findViewById(R.id.pergunta);
		resposta1 = (RadioButton) findViewById(R.id.resposta1);
		resposta2 = (RadioButton) findViewById(R.id.resposta2);
		resposta3 = (RadioButton) findViewById(R.id.resposta3);
		resposta4 = (RadioButton) findViewById(R.id.resposta4);
		buscarNovaPergunta();
	}


	private void buscarNovaPergunta() {
		boolean passou = false;
		while(!passou){
			int r = 0 + (int)(Math.random() * tamanhoLista);
			p = listaPerguntas.get(r);
			if((p!=perguntaAnterior) && (!listaAux.contains(p))) {
				passou = true;
				listaAux.add(p);
				perguntaAnterior = p;
			}
		}
			
		cont++;
		mostrarPergunta(p);
		
	}
	
	private void mostrarPergunta(Pergunta p){
		pergunta.setText(p.getPergunta());
		resposta1.setText(p.getOp_01());
		resposta1.setChecked(false);
		resposta2.setText(p.getOp_02());
		resposta2.setChecked(false);
		resposta3.setText(p.getOp_03());
		resposta3.setChecked(false);
		resposta4.setText(p.getOp_04());
		resposta4.setChecked(false);
	}
	
	
	@Override
	public void onBackPressed() {
		
		
		AlertDialog.Builder d = new AlertDialog.Builder(JogoActivity.this);
		d.setTitle("Aviso");
		d.setMessage("Deseja sair do jogo?");
		d.setPositiveButton("Sim", new OnClickListener() {
			
			public void onClick(DialogInterface arg0, int arg1) {
					Intent i = new Intent(JogoActivity.this, MenuQuizActivity.class);
					i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
					startActivity(i);
			}
		});
		
		d.setNegativeButton("Não", new OnClickListener() {
			
			public void onClick(DialogInterface dialog, int arg1) {
					dialog.dismiss();
				
			}
		});
		
		d.show();
	}


	public void onClick(View v) {
		switch(v.getId()){
		case R.id.botaoOk:
			int selectedId = radioGroupResposta.getCheckedRadioButtonId();
			if(selectedId == -1){
				getAlert("Aviso", "Selecione alguma opção");
			}
			else{
				int correta = Integer.parseInt(p.getCorreta());
				
				if(selectedId == R.id.resposta1){
					
					if(correta==1){
						pontos+=5;
					}
				}
				else if(selectedId == R.id.resposta2){
					
					if(correta==2){
						pontos+=5;
					}
				}else if(selectedId == R.id.resposta3){
					
					if(correta==3){
						pontos+=5;
					}
				}else if(selectedId == R.id.resposta4){
					
					if(correta==4){
						pontos+=5;
					}
				}
				if(cont==tamanhoLista){
					getAlert("Fim de jogo", "Parabéns\n Você fez "+pontos+ " pontos");
					Aluno aux = FController.getInstance().buscarAlunoPorMatricula(FController.aluno.getMatricula(), JogoActivity.this);
					aux.setPontuacao(pontos);
					FController.getInstance().updateAluno(aux, JogoActivity.this);
				}
				else{
					buscarNovaPergunta();
				}			
					
			}		
			 
		}
		
	}
	
	private void getAlert(String title, String msg) {
		final AlertDialog.Builder alert = new AlertDialog.Builder(JogoActivity.this);
		alert.setTitle("Aviso");
		alert.setMessage(msg);
		alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
			
			public void onClick(DialogInterface d, int arg1) {
				Intent i = new Intent(JogoActivity.this, MenuQuizActivity.class);
				i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(i);
				
			}
		});					
		alert.show();
	}

}
