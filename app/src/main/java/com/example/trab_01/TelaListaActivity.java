package com.example.trab_01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class TelaListaActivity extends AppCompatActivity {
    Button btnVoltar;
    Spinner spinner;
    private static ArrayList<Musica> musicas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_lista);

        spinner = findViewById(R.id.spinner);
        btnVoltar = findViewById(R.id.btnVoltar);

        final ListView lista = (ListView) findViewById(R.id.listView);
        Musica m1 = new Musica("Silver", "Nirvana", "Nevermind","3:40");
        Musica m2 = new Musica("Come As You Are", "Nirvana", "Nevermind","2:40");
        Musica m3 = new Musica("About a Girl", "Nirvana", "Nevermind","4:20");
        Musica m4 = new Musica("Smell Like Teen Spirit", "Nirvana", "Nevermind","5:00");
        Musica m5 = new Musica("Poly", "Nirvana", "Nevermind","3:41");
        Musica m6 = new Musica("Dumb", "Nirvana", "Nevermind","3:40");
        Musica m7 = new Musica("Heart Shaped Box", "Nirvana", "Nevermind","3:50");
        Musica m8 = new Musica("Lithium", "Nirvana", "Nevermind","1:40");
        Musica m9 = new Musica("Apologies", "Nirvana", "Nevermind","3:10");

        if (musicas.size() == 0) {
            musicas.add(m1);
            musicas.add(m2);
            musicas.add(m3);
            musicas.add(m4);
            musicas.add(m5);
            musicas.add(m6);
            musicas.add(m7);
            musicas.add(m8);
            musicas.add(m9);
        }
        final ArrayAdapter<Musica> adapter = new MusicaAdapter(TelaListaActivity.this, musicas);
        lista.setAdapter(adapter);


        final String[] list_of_order = {
                "Aleatório",
                "Alfabetica",
                "Album",
                "Duração",
        };

        ArrayAdapter<String> adp = new ArrayAdapter<>(
                this, android.R.layout.simple_spinner_dropdown_item, list_of_order);

        spinner.setAdapter(adp);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(TelaListaActivity.this, "A lista sera exibida por " + list_of_order[position], Toast.LENGTH_LONG).show();
                //ainda falta implementar isso

                //INICIO
                switch (list_of_order[position]) {
                    case "Alfabetica":
                        Collections.sort(musicas, new Comparator() {
                            @Override
                            public int compare(Object o1, Object o2) {
                                Musica a1 = (Musica) o1;
                                Musica a2 = (Musica) o2;
                                return a1.getNome().compareToIgnoreCase(a2.getNome());
                            }
                        });
                        adapter.notifyDataSetChanged(); //atualizar a lista
                        break;
                    case "Album":
                        Collections.sort(musicas, new Comparator() {
                            @Override
                            public int compare(Object o1, Object o2) {
                                Musica a1 = (Musica) o1;
                                Musica a2 = (Musica) o2;
                                return a1.getAlbum().compareToIgnoreCase(a2.getAlbum());
                            }
                        });
                        adapter.notifyDataSetChanged(); //atualizar a lista
                        break;
                    case "Duração":
                        Collections.sort(musicas, new Comparator() {
                            @Override
                            public int compare(Object o1, Object o2) {
                                Musica a1 = (Musica) o1;
                                Musica a2 = (Musica) o2;
                                return a1.getDuracao().compareToIgnoreCase(a2.getDuracao());
                            }
                        });
                        adapter.notifyDataSetChanged(); //atualizar a lista
                        break;
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });


        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), MainActivity.class);
                startActivity(intent);
            }
        });


    }
}
