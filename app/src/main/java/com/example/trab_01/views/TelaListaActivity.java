package com.example.trab_01.views;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

import com.example.trab_01.models.Musica;
import com.example.trab_01.adapters.MusicaAdapter;
import com.example.trab_01.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import static com.example.trab_01.R.drawable.fundomusica;
import static com.example.trab_01.R.drawable.sobrenos;

public class TelaListaActivity extends AppCompatActivity {
    Button btnVoltar;
    Spinner spinner;

    MediaPlayer myMusic;

    private static ArrayList<Musica> musicas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_lista);

        myMusic = MediaPlayer.create(TelaListaActivity.this, R.raw.smells_trinta);
        spinner = findViewById(R.id.spinner);
        btnVoltar = findViewById(R.id.btnVoltar);

        final ListView lista = (ListView) findViewById(R.id.listView);
        Musica m1 = new Musica("Silver", "Nirvana", "Nevermind","2:11");
        Musica m2 = new Musica("Come As You Are", "Nirvana", "Nevermind","3:45");
        Musica m3 = new Musica("About A Girl", "Nirvana", "Nevermind","2:49");
        Musica m4 = new Musica("Smells Like Teen Spirit", "Nirvana", "Nevermind","4:38");
        Musica m5 = new Musica("Polly", "Nirvana", "Nevermind","2:51");
        Musica m6 = new Musica("Dumb", "Nirvana", "Nevermind","2:34");
        Musica m7 = new Musica("Heart Shaped Box", "Nirvana", "Nevermind","4:40");
        Musica m8 = new Musica("Lithium", "Nirvana", "Nevermind","4:17");
        Musica m9 = new Musica("All Apologies", "Nirvana", "Nevermind","3:38");

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


        //colocar a musica pra tocar
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (musicas.get(position).getNome()){
                    case "Smells Like Teen Spirit":
                        myMusic.stop();
                        myMusic = MediaPlayer.create(TelaListaActivity.this, R.raw.smells_trinta);
                        myMusic.start();
                        break;
                    case "Silver":
                        myMusic.stop();
                        myMusic = MediaPlayer.create(TelaListaActivity.this, R.raw.silver);
                        myMusic.start();
                        break;
                    case "Come As You Are":
                        myMusic.stop();
                        myMusic = MediaPlayer.create(TelaListaActivity.this, R.raw.come);
                        myMusic.start();
                        break;
                    case "About A Girl":
                        myMusic.stop();
                        myMusic = MediaPlayer.create(TelaListaActivity.this, R.raw.about);
                        myMusic.start();
                        break;
                    case "Polly":
                        myMusic.stop();
                        myMusic = MediaPlayer.create(TelaListaActivity.this, R.raw.polly);
                        myMusic.start();
                        break;
                    case "Dumb":
                        myMusic.stop();
                        myMusic = MediaPlayer.create(TelaListaActivity.this, R.raw.dumb);
                        myMusic.start();
                        break;
                    case "Heart Shaped Box":
                        myMusic.stop();
                        myMusic = MediaPlayer.create(TelaListaActivity.this, R.raw.heart);
                        myMusic.start();
                        break;
                    case "Lithium":
                        myMusic.stop();
                        myMusic = MediaPlayer.create(TelaListaActivity.this, R.raw.lithium);
                        myMusic.start();
                        break;
                    case "All Apologies":
                        myMusic.stop();
                        myMusic = MediaPlayer.create(TelaListaActivity.this, R.raw.apollogies);
                        myMusic.start();
                        break;
                    default:
                        Toast.makeText(TelaListaActivity.this, "", Toast.LENGTH_SHORT).show();

                }

            }
        });

        //ver as opcoes da musica
        lista.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                myMusic.stop();
                //aparecer um menu aqui
                return true;
            }
        });



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
                //Toast.makeText(TelaListaActivity.this, "A lista sera exibida por " + list_of_order[position], Toast.LENGTH_SHORT).show();
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



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.sobreNos){
            Toast.makeText(this, "Sobre Nos", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(TelaListaActivity.this,SobreNosActivity.class);
            startActivity(intent);
        }else if(item.getItemId() == R.id.modoEscuro){
            Toast.makeText(this, "Modo Escuro Ativado", Toast.LENGTH_SHORT).show();
            RelativeLayout relativeLayout = findViewById(R.id.layoutLista);
            relativeLayout.setBackgroundColor(R.drawable.fundomusica);
        }



        return super.onOptionsItemSelected(item);
    }
}
