package com.example.trab_01.adapters;


import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.trab_01.models.Musica;
import com.example.trab_01.R;

import java.util.ArrayList;

public class MusicaAdapter extends ArrayAdapter<Musica> {
    private final Context context;
    ArrayList<Musica> elementos;

    public MusicaAdapter(Context context, ArrayList<Musica> elementos) {
        super(context, R.layout.list_item, elementos);
        this.context = context;
        this.elementos = elementos;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        @SuppressLint("ViewHolder") View rowView = inflater.inflate(R.layout.list_item, parent, false);

        TextView nomeMusica = rowView.findViewById(R.id.nomeDaMusica);
        TextView artista = rowView.findViewById(R.id.artista);
        TextView album = rowView.findViewById(R.id.album);
        TextView duracao = rowView.findViewById(R.id.duracao);

        album.setText(elementos.get(position).getAlbum());
        nomeMusica.setText(elementos.get(position).getNome());
        artista.setText(elementos.get(position).getArtista());
        duracao.setText(elementos.get(position).getDuracao());

        return rowView;
    }


}
