package com.presslab.noticias.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.presslab.R;
import com.presslab.noticias.noticias.Noticias;

import java.util.List;

public class ListaAdapter extends BaseAdapter {

    private List<Noticias> itens;
    private Context context;

    public ListaAdapter(Context context, List<Noticias> itens){

        this.itens = itens;
        this.context = context;
    }

    @Override
    //retorna a quantidade de itens da lista
    //posso colocar um length no lugar do size(), para percorrer toda lista.
    public int getCount() {
        return itens.size();
    }

    @Override
    //irá retornar o item da lista de acordo com sua posição
    public Object getItem(int position) {
        return itens.get(position);
    }

    @Override
    //rá retornar o id do item de acordo com sua posição
    public long getItemId(int position) {
        return itens.get(position).getId();
    }

    @Override
    //E o método principal, ele é o atualizador da lista,
    // que é frequentemente atualizada a cada vez, esse método
    // é executado de acordo com a quantidade de itens do getCont().
    //Ele recebe 3 parametros:
    // *a posição,
    // *a "view" da atualização anterior que é nosso layout já carregado (desatualizado)
    // *e o "ViewGroup" que é (se houver) o “pai” da view.
    public View getView(int position, View convertView, ViewGroup parent) {

        //pegando á posição da lista e colocando dentro deste objeto
        Noticias obj = itens.get(position);

        //infla á view
        View view = LayoutInflater.from(context).inflate(R.layout.londrina, parent, false);

        //faz findViewById que precisam ser Atualizadas
        TextView text = (TextView)view.findViewById(R.id.descricao);
        TextView txt = (TextView)view.findViewById(R.id.titulo);
        ImageView img = (ImageView)view.findViewById(R.id.img);

        //Atualiza os valores das views
        Noticias lista = itens.get(position);

        text.setText(lista.getNoticia());
        txt.setText(lista.getTitulo());
        img.setImageResource(lista.getImagem());

        //retorna a view desta lista
        return view;
    }

}
