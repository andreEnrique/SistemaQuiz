package br.com.ufpb.ui;

import br.com.ufpb.classes.Aluno;
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

public class EditarAlunoActivity extends Activity implements OnClickListener{

	private TextView nome,matricula;
	private EditText etNome,etMatricula;
	private Button editar, editarSecundario, remover;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ver_alunos);
		
		nome =  (TextView) findViewById(R.id.nome_tv);
		nome.setText(FController.aluno.getNome());
		matricula = (TextView) findViewById(R.id.matricula_tv);
		matricula.setText(FController.aluno.getMatricula());
		
		editar = (Button) findViewById(R.id.botaoEditar);
		editar.setOnClickListener(this);
		remover= (Button) findViewById(R.id.botaoRemover);
		remover.setOnClickListener(this);
	}
	public void onClick(View v) {
		Aluno aux;
		Intent i;
		switch(v.getId()){
		case R.id.botaoEditar:
			editar();
			break;
		case R.id.botaoRemover:
			aux = FController.getInstance().buscarAlunoPorMatricula(FController.aluno.getMatricula(), EditarAlunoActivity.this);
			FController.getInstance().deletarAluno(aux,EditarAlunoActivity.this);
			i = new Intent(EditarAlunoActivity.this, MenuLogadoActivity.class);
			i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(i);
			break;
		case R.id.botao_editar:
			aux = FController.getInstance().buscarAlunoPorMatricula(FController.aluno.getMatricula(), EditarAlunoActivity.this);
			aux.setNome(etNome.getText().toString());
			aux.setMatricula(etMatricula.getText().toString());
			FController.getInstance().updateAluno(aux,EditarAlunoActivity.this);
			i = new Intent(EditarAlunoActivity.this, MenuLogadoActivity.class);
			i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(i);
			break;
		}
		

	}
	
	private void editar(){
		setContentView(R.layout.editar_alunos);
		editarSecundario = (Button) findViewById(R.id.botao_editar);
		editarSecundario.setOnClickListener(this);
		etNome =  (EditText) findViewById(R.id.et_editar_nome);
		etNome.setText(FController.aluno.getNome());
		etMatricula = (EditText) findViewById(R.id.et_editar_matricula);
		etMatricula.setText(FController.aluno.getMatricula());
		
	}
}
