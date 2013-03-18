package br.com.ufpb.ui;

import java.util.List;

import br.com.ufpb.adapter.PerguntaListAdapter;
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
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;

public class PerguntasView extends Activity implements OnItemClickListener {

	public static final int MENU_EDITAR = Menu.FIRST;
	public static final int MENU_REMOVER = Menu.FIRST + 1;
	
	private ListView noteListView;
	private ProgressDialog pd;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.perguntas_view);
		
		pd = new ProgressDialog(this);
		pd.setMessage("Carregando perguntas...");
		pd.show();
		
		new LoadNotes().execute();
	}
		
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch(item.getItemId()){
            case MENU_EDITAR:
            
            return true;
        case MENU_REMOVER:

            return true;
        default:
            return super.onOptionsItemSelected(item);
        }
	}
	
	private class LoadNotes extends AsyncTask<Void, Void, List<Pergunta>> {

		@Override
		protected List<Pergunta> doInBackground(Void... params) {
			return FController.getInstance().buscarListaPerguntas(PerguntasView.this);
		}
		
		@Override
		protected void onPostExecute(List<Pergunta> result) {
			super.onPostExecute(result);
			pd.dismiss();
			
			if (result != null) {
				PerguntaListAdapter adapter = new PerguntaListAdapter(PerguntasView.this, R.layout.pergunta_list, result);
				noteListView = (ListView) findViewById(R.id.lv_perguntas);
				noteListView.setAdapter(adapter);
				noteListView.setOnItemClickListener(PerguntasView.this);
				
			} else {
				final AlertDialog.Builder alert = new AlertDialog.Builder(PerguntasView.this);
				alert.setTitle("Aviso");
				alert.setMessage("Nenhuma pergunta cadastrada");
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
		FController.pergunta = (Pergunta) adapter.getItemAtPosition(position);
		Intent i = new Intent(PerguntasView.this, EditarPerguntaActivity.class);
		i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		startActivity(i);
		
	}		
	
}
