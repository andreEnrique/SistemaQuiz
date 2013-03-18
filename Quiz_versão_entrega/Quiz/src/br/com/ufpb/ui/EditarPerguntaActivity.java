package br.com.ufpb.ui;

import br.com.ufpb.classes.Pergunta;
import br.com.ufpb.core.FController;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class EditarPerguntaActivity extends Activity implements OnClickListener{

	private TextView pergunta,resposta1,resposta2,resposta3,resposta4,respostaCorreta;
	private EditText etpergunta,etresposta1,etresposta2,etresposta3,etresposta4,etrespostaCorreta;
	private Button editar, editarSecundario, remover;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ver_perguntas);
		
		pergunta =  (TextView) findViewById(R.id.pergunta_tv);
		pergunta.setText(FController.pergunta.getPergunta());
		resposta1 = (TextView) findViewById(R.id.resposta1_tv);
		resposta1.setText(FController.pergunta.getOp_01());
		resposta2 = (TextView) findViewById(R.id.resposta2_tv);
		resposta2.setText(FController.pergunta.getOp_02());
		resposta3 = (TextView) findViewById(R.id.resposta3_tv);
		resposta3.setText(FController.pergunta.getOp_03());
		resposta4 = (TextView) findViewById(R.id.resposta4_tv);
		resposta4.setText(FController.pergunta.getOp_04());
		respostaCorreta = (TextView) findViewById(R.id.alternativa_correta_tv);
		respostaCorreta.setText(FController.pergunta.getCorreta());
		
		editar = (Button) findViewById(R.id.botaoEditar);
		editar.setOnClickListener(this);
		remover= (Button) findViewById(R.id.botaoRemover);
		remover.setOnClickListener(this);
	}
	public void onClick(View v) {
		Pergunta aux;
		Intent i;
		switch(v.getId()){
		case R.id.botaoEditar:
			editar();
			break;
		case R.id.botaoRemover:
			aux = FController.getInstance().buscarPerguntaPorNome(FController.pergunta.getPergunta(), EditarPerguntaActivity.this);
			FController.getInstance().deletarPergunta(aux,EditarPerguntaActivity.this);
			i = new Intent(EditarPerguntaActivity.this, MenuLogadoActivity.class);
			i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(i);
			break;
		case R.id.botao_editar:
			aux = FController.getInstance().buscarPerguntaPorNome(FController.pergunta.getPergunta(), EditarPerguntaActivity.this);
			aux.setPergunta(etpergunta.getText().toString());
			aux.setOp_01(etresposta1.getText().toString());
			aux.setOp_02(etresposta2.getText().toString());
			aux.setOp_03(etresposta3.getText().toString());
			aux.setOp_04(etresposta4.getText().toString());
			aux.setCorreta(etrespostaCorreta.getText().toString());			
			FController.getInstance().updatePergunta(aux,EditarPerguntaActivity.this);
			i = new Intent(EditarPerguntaActivity.this, MenuLogadoActivity.class);
			i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(i);
			break;
		}
		

	}
	
	private void editar(){
		setContentView(R.layout.editar_perguntas);
		editarSecundario = (Button) findViewById(R.id.botao_editar);
		editarSecundario.setOnClickListener(this);
		etpergunta =  (EditText) findViewById(R.id.et_editar_pergunta);
		etpergunta.setText(FController.pergunta.getPergunta());
		etresposta1 = (EditText) findViewById(R.id.et_editar_resposta1);
		etresposta1.setText(FController.pergunta.getOp_01());
		etresposta2 = (EditText) findViewById(R.id.et_editar_resposta2);
		etresposta2.setText(FController.pergunta.getOp_02());
		etresposta3 = (EditText) findViewById(R.id.et_editar_resposta3);
		etresposta3.setText(FController.pergunta.getOp_03());
		etresposta4 = (EditText) findViewById(R.id.et_editar_resposta4);
		etresposta4.setText(FController.pergunta.getOp_04());
		etrespostaCorreta = (EditText) findViewById(R.id.et_editar_resposta_correta);
		etrespostaCorreta.setText(FController.pergunta.getCorreta());
	}
}
