package br.com.ufpb.adapter;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import br.com.ufpb.classes.Aluno;
import br.com.ufpb.classes.Pergunta;
import br.com.ufpb.ui.R;

public class RankingListAdapter extends ArrayAdapter<Aluno> {

	private ArrayList<Aluno> items;

	public RankingListAdapter(Context context, int textViewResourceId, List<Aluno> items) {
		super(context, textViewResourceId, items);
		this.items = (ArrayList<Aluno>) items;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LinearLayout v = (LinearLayout)convertView;
        if (v == null) {
            LayoutInflater vi = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = (LinearLayout)vi.inflate(R.layout.ranking_list, null);
        }
        Aluno aluno = items.get(position);
        if (aluno != null) {

            TextView tv_nome = (TextView) v.findViewById(R.id.tv_nome_aluno);
            if (tv_nome != null){
            	tv_nome.setText("Aluno: " +aluno.getNome());
            }

            TextView tv_matricula = (TextView) v.findViewById(R.id.tv_mat_aluno);
            if (tv_matricula != null){
            	tv_matricula.setText("Matrícula: " +aluno.getMatricula());
            }
            TextView tv_pontuacao = (TextView) v.findViewById(R.id.tv_pontos);
            if (tv_pontuacao != null){
            	tv_pontuacao.setText("Pontos: " +aluno.getPontuacao());
            }
        }
        return v;
	}
}
