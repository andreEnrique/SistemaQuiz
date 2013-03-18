package br.com.ufpb.ui;

import java.util.List;

import br.com.ufpb.adapter.PerguntaListAdapter;
import br.com.ufpb.adapter.RankingListAdapter;
import br.com.ufpb.classes.Aluno;
import br.com.ufpb.classes.Pergunta;
import br.com.ufpb.core.FController;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class RankingView extends Activity implements OnItemClickListener {

	
	private ListView noteListView;
	private ProgressDialog pd;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ranking_view);
		
		pd = new ProgressDialog(this);
		pd.setMessage("Carregando Ranking...");
		pd.show();
		
		new LoadNotes().execute();
	}
	
	

//	@Override
//	public boolean onCreateOptionsMenu(Menu menu) {
//		MenuInflater inflater = getMenuInflater();
//	    inflater.inflate(R.menu.dbview, menu);
//		return super.onCreateOptionsMenu(menu);
//	}
//	
//	@Override
//	public boolean onOptionsItemSelected(MenuItem item) {
//	    switch (item.getItemId()) {
//	    case R.id.mn_update_screens:
//	    	List<Multa> multas = FController.getInstance().fetchMultaSync(this);
//			if (multas != null) {
//				for (Multa m : multas) {
//					FController.getInstance().sendMultaThread(m, this);
//				}
//			}
//	        return true;
//	    default:
//	        return super.onOptionsItemSelected(item);
//	    }
//	}
	
	private class LoadNotes extends AsyncTask<Void, Void, List<Aluno>> {

		@Override
		protected List<Aluno> doInBackground(Void... params) {
			return FController.getInstance().buscarRankingAluno(RankingView.this);
		}
		
		@Override
		protected void onPostExecute(List<Aluno> result) {
			super.onPostExecute(result);
			pd.dismiss();
			
			if (result != null) {
				RankingListAdapter adapter = new RankingListAdapter(RankingView.this, R.layout.ranking_list, result);
				noteListView = (ListView) findViewById(R.id.lv_ranking);
				noteListView.setAdapter(adapter);
				noteListView.setOnItemClickListener(RankingView.this);
			} else {
				final AlertDialog.Builder alert = new AlertDialog.Builder(RankingView.this);
				alert.setTitle("Aviso");
				alert.setMessage("Ranking vazio");
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
		//FController.multa = (Pergunta) adapter.getItemAtPosition(position);
		//startActivity(new Intent(this, ViewMulta.class));
	}
	
	
}
