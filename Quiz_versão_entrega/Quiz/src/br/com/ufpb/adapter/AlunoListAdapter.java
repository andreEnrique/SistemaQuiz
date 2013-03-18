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

public class AlunoListAdapter extends ArrayAdapter<Aluno> {

	private ArrayList<Aluno> items;

	public AlunoListAdapter(Context context, int textViewResourceId, List<Aluno> items) {
		super(context, textViewResourceId, items);
		this.items = (ArrayList<Aluno>) items;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LinearLayout v = (LinearLayout)convertView;
        if (v == null) {
            LayoutInflater vi = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = (LinearLayout)vi.inflate(R.layout.aluno_list, null);
        }
        Aluno aluno = items.get(position);
        if (aluno != null) {

            TextView tv_titulo_aluno = (TextView) v.findViewById(R.id.tv_titulo_aluno);
            if (tv_titulo_aluno != null){
            	tv_titulo_aluno.setText("Aluno " +aluno.getNome());
            }

            TextView tv_aluno = (TextView) v.findViewById(R.id.tv_aluno);
            if (tv_aluno != null){
            	tv_aluno.setText("Matrícula " +aluno.getId());
            }
            
         
        }
        return v;
	}
}
