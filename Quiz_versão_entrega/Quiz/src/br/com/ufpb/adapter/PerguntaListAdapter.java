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
import br.com.ufpb.classes.Pergunta;
import br.com.ufpb.ui.R;

public class PerguntaListAdapter extends ArrayAdapter<Pergunta> {

	private ArrayList<Pergunta> items;

	public PerguntaListAdapter(Context context, int textViewResourceId, List<Pergunta> items) {
		super(context, textViewResourceId, items);
		this.items = (ArrayList<Pergunta>) items;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LinearLayout v = (LinearLayout)convertView;
        if (v == null) {
            LayoutInflater vi = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = (LinearLayout)vi.inflate(R.layout.pergunta_list, null);
        }
        Pergunta pergunta = items.get(position);
        if (pergunta != null) {

            TextView tv_titulo_pergunta = (TextView) v.findViewById(R.id.tv_titulo_pergunta);
            if (tv_titulo_pergunta != null){
            	tv_titulo_pergunta.setText("Pergunta");
            }

            TextView tv_pegunta = (TextView) v.findViewById(R.id.tv_pergunta);
            if (tv_pegunta != null){
            	tv_pegunta.setText(pergunta.getPergunta());
            }
        }
        return v;
	}
}
