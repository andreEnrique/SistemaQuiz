package br.com.ufpb.ui;

import java.util.LinkedList;
import java.util.List;

import br.com.ufpb.classes.Pergunta;
import br.com.ufpb.core.FController;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class CadastrarPerguntasActivity extends Activity implements OnClickListener{
	private int qtd;
	private int cont = 0;
	private TextView tvQtd;
	private Button b;
	private EditText campoPergunta,campoResposta1,campoResposta2,campoResposta3,campoResposta4,campoResposta5;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.cadastrar_perguntas);
		cont++;
		tvQtd = (TextView) findViewById(R.id.tv_qtd);
		Intent i = getIntent();
		Bundle params = i.getExtras();
		if(params!=null){
			qtd = params.getInt("qtd");
		}
		tvQtd.setText("Pergunta "+cont+"/"+qtd);
		exibirCadastroPerguntas();

	}

	
	private void exibirCadastroPerguntas() {
		LinearLayout formPerguntas = (LinearLayout)findViewById(R.id.formPerguntas);
		formPerguntas.setOrientation(LinearLayout.VERTICAL);
		ScrollView scroll = new ScrollView(this);
		LayoutParams edLayoutParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		TextView tvPergunta1 = new TextView(CadastrarPerguntasActivity.this);
		campoPergunta = new EditText(CadastrarPerguntasActivity.this);
		tvPergunta1.setText("Pergunta 1" );
		campoPergunta.setText("");
		tvPergunta1.setLayoutParams(edLayoutParams);
		TextView tvResposta1 = new TextView(CadastrarPerguntasActivity.this);
		campoResposta1 = new EditText(CadastrarPerguntasActivity.this);
		tvResposta1.setText("Resposta 1" );
		campoResposta1.setText("");
		TextView tvResposta2 = new TextView(CadastrarPerguntasActivity.this);
		campoResposta2 = new EditText(CadastrarPerguntasActivity.this);
		tvResposta2.setText("Resposta 2" );
		campoResposta2.setText("");
		tvResposta2.setLayoutParams(edLayoutParams);
		TextView tvResposta3 = new TextView(CadastrarPerguntasActivity.this);
		campoResposta3 = new EditText(CadastrarPerguntasActivity.this);
		tvResposta3.setText("Resposta 3" );
		campoResposta3.setText("");
		tvResposta3.setLayoutParams(edLayoutParams);
		TextView tvResposta4 = new TextView(CadastrarPerguntasActivity.this);
		campoResposta4 = new EditText(CadastrarPerguntasActivity.this);
		tvResposta4.setText("Resposta 4" );
		campoResposta4.setText("");
		tvResposta4.setLayoutParams(edLayoutParams);
		TextView tvResposta5 = new TextView(CadastrarPerguntasActivity.this);
		campoResposta5 = new EditText(CadastrarPerguntasActivity.this);
		tvResposta5.setText("Alternativa Correta" );
		campoResposta5.setInputType(InputType.TYPE_CLASS_NUMBER);
		b = new Button(this);
		if(cont==qtd){
			b.setText("Salvar Perguntas");
		}
		else{
			b.setText("Próxima Pergunta");
		}
		
		b.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				int op = 0;
				if(!campoResposta5.getText().toString().equals("")){
					op = Integer.parseInt(campoResposta5.getText().toString());
				}				
				if(campoPergunta.getText().toString().equals("")
						||(campoResposta1.getText().toString().equals(""))
						||(campoResposta2.getText().toString().equals(""))
						||(campoResposta3.getText().toString().equals(""))
						||(campoResposta4.getText().toString().equals(""))
						||(campoResposta5.getText().toString().equals(""))){
						
					getAlert("Preencha todos os campos");
				}
				else if(op <1 || op > 4){
					getAlert("Alternativa correta inválida");
				}
				else{
					cont++;
					String pergunta = campoPergunta.getText().toString();
					String op_01 = campoResposta1.getText().toString();
					String op_02 = campoResposta2.getText().toString();
					String op_03 = campoResposta3.getText().toString();
					String op_04 = campoResposta4.getText().toString();
					String correta = campoResposta5.getText().toString();
					tvQtd.setText("Pergunta "+cont+"/"+qtd);
					campoPergunta.setText("");
					campoResposta1.setText("");
					campoResposta2.setText("");
					campoResposta3.setText("");
					campoResposta4.setText("");
					campoResposta5.setText("");
					if(cont==qtd){
						b.setText("Salvar Perguntas");
					}
					else{
						b.setText("Próxima Pergunta");
					}
					Pergunta p = new Pergunta(pergunta, op_01, op_02, op_03, op_04, correta);
					FController.getInstance().insertPergunta(p, CadastrarPerguntasActivity.this);
					if(cont>qtd){
						finish();
					}
				}
				
			}

		
		});
		
		tvResposta5.setLayoutParams(edLayoutParams);
		formPerguntas.addView(tvPergunta1);
		formPerguntas.addView(campoPergunta);
		formPerguntas.addView(tvResposta1);
		formPerguntas.addView(campoResposta1);
		formPerguntas.addView(tvResposta2);
		formPerguntas.addView(campoResposta2);
		formPerguntas.addView(tvResposta3);
		formPerguntas.addView(campoResposta3);
		formPerguntas.addView(tvResposta4);
		formPerguntas.addView(campoResposta4);	
		formPerguntas.addView(tvResposta5);
		formPerguntas.addView(campoResposta5);
		formPerguntas.addView(b);

		
	}

	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		
	}
	
	private void getAlert(String msg) {
		final AlertDialog.Builder alert = new AlertDialog.Builder(CadastrarPerguntasActivity.this);
		alert.setTitle("Aviso");
		alert.setMessage(msg);
		alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
			
			public void onClick(DialogInterface d, int arg1) {
				d.dismiss();
				
			}
		});					
		alert.show();
	}

}

