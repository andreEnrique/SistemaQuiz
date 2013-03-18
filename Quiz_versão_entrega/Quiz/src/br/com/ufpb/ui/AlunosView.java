package br.com.ufpb.ui;

import java.util.List;

import br.com.ufpb.adapter.AlunoListAdapter;
import br.com.ufpb.adapter.PerguntaListAdapter;
import br.com.ufpb.classes.Aluno;
import br.com.ufpb.classes.Pergunta;
import br.com.ufpb.core.FController;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class AlunosView extends Activity implements OnItemClickListener {

	
	private ListView noteListView;
	private ProgressDialog pd;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.aluno_view);
		
		pd = new ProgressDialog(this);
		pd.setMessage("Carregando alunos...");
		pd.show();
		
		new LoadNotes().execute();
	}
	
	
	private class LoadNotes extends AsyncTask<Void, Void, List<Aluno>> {

		@Override
		protected List<Aluno> doInBackground(Void... params) {
			return FController.getInstance().buscarListaAluno(AlunosView.this);
		}
		
		@Override
		protected void onPostExecute(List<Aluno> result) {
			super.onPostExecute(result);
			pd.dismiss();
			
			if (result != null) {
				AlunoListAdapter adapter = new AlunoListAdapter(AlunosView.this, R.layout.aluno_list, result);
				noteListView = (ListView) findViewById(R.id.lv_aluno);
				noteListView.setAdapter(adapter);
				noteListView.setOnItemClickListener(AlunosView.this);
			} else {
				final AlertDialog.Builder alert = new AlertDialog.Builder(AlunosView.this);
				alert.setTitle("Aviso");
				alert.setMessage("Nenhum aluno cadastrado");
				alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
					
					public void onClick(DialogInterface d, int arg1) {
						d.dismiss();
						finish();
					}
				});					
				alert.show();
				
			}
		}
		
	}

	
	public void onItemClick(AdapterView<?> adapter, View view, int position, long id) {
		FController.aluno = (Aluno) adapter.getItemAtPosition(position);
		Intent i = new Intent(AlunosView.this, EditarAlunoActivity.class);
		i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		startActivity(i);
	}
	
	
}
