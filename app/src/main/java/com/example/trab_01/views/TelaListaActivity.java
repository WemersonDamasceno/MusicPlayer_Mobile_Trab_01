package com.example.trab_01.views;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.trab_01.R;
import com.example.trab_01.adapters.MusicaAdapter;
import com.example.trab_01.models.Musica;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Timer;
import java.util.TimerTask;

public class TelaListaActivity extends AppCompatActivity {
    Spinner spinner;
    //botoes do player
    ImageView btnAnterior;
    ImageView btnPlay;
    ImageView btnProximo;
    ImageView btnPause;
    TextView tvTitulo;
    Timer t;

    LinearLayout mediaPlayer;
    ImageView btnVoltarMedia;

    ProgressBar progressBar;
    int cont = 0;
    int positionLastMusic = 0;
    MediaPlayer myMusic;
    private static ArrayList<Musica> musicas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_lista);

        mediaPlayer = findViewById(R.id.mediaPlayer);
        btnVoltarMedia = findViewById(R.id.btnVoltar);

        t = new Timer();
        btnAnterior = findViewById(R.id.btnAnterior);
        btnPlay = findViewById(R.id.btnPlay);
        btnProximo = findViewById(R.id.btnProximo);
        btnPause = findViewById(R.id.btnPause);
        myMusic = MediaPlayer.create(TelaListaActivity.this, R.raw.silver);
        spinner = findViewById(R.id.spinner);
        tvTitulo = findViewById(R.id.tituloMusica);

        final ListView lista = findViewById(R.id.listView);
        Musica m1 = new Musica("Silver", "Nirvana", "Nevermind", "2:11", R.raw.silver);
        Musica m2 = new Musica("Come As You Are", "Nirvana", "Nevermind", "3:45", R.raw.come);
        Musica m3 = new Musica("About A Girl", "Nirvana", "Nevermind", "2:49", R.raw.about);
        Musica m4 = new Musica("Smells Like Teen Spirit", "Nirvana", "Nevermind", "4:38", R.raw.smells_trinta);
        Musica m5 = new Musica("Polly", "Nirvana", "Nevermind", "2:51", R.raw.polly);
        Musica m6 = new Musica("Dumb", "Nirvana", "Nevermind", "2:34", R.raw.dumb);
        Musica m7 = new Musica("Heart Shaped Box", "Nirvana", "Nevermind", "4:40", R.raw.heart);
        Musica m8 = new Musica("Lithium", "Nirvana", "Nevermind", "4:17", R.raw.lithium);
        Musica m9 = new Musica("All Apologies", "Nirvana", "Nevermind", "3:38", R.raw.apollogies);

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


        //Picasso.get().load(R.drawable.teste).into(teste);
        final ArrayAdapter<Musica> adapter = new MusicaAdapter(TelaListaActivity.this, musicas);
        lista.setAdapter(adapter);

        btnVoltarMedia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.setVisibility(View.INVISIBLE);
            }
        });
        tvTitulo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.setVisibility(View.VISIBLE);
            }
        });

        //colocar a musica pra tocar
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (musicas.get(position).getNome()) {
                    case "Smells Like Teen Spirit":
                        myMusic.stop();
                        positionLastMusic = position;
                        tvTitulo.setText(musicas.get(positionLastMusic).getNome() + "\n" + musicas.get(positionLastMusic).getArtista());
                        myMusic = MediaPlayer.create(TelaListaActivity.this, R.raw.smells_trinta);
                        mediaPlayer.setVisibility(View.VISIBLE);
                        myMusic.start();
                        cont = 0;
                        break;
                    case "Silver":
                        myMusic.stop();
                        positionLastMusic = position;
                        tvTitulo.setText(musicas.get(positionLastMusic).getNome() + "\n" + musicas.get(positionLastMusic).getArtista());
                        myMusic = MediaPlayer.create(TelaListaActivity.this, R.raw.silver);
                        mediaPlayer.setVisibility(View.VISIBLE);
                        myMusic.start();
                        cont = 0;
                        break;
                    case "Come As You Are":
                        myMusic.stop();
                        positionLastMusic = position;
                        tvTitulo.setText(musicas.get(positionLastMusic).getNome() + "\n" + musicas.get(positionLastMusic).getArtista());
                        myMusic = MediaPlayer.create(TelaListaActivity.this, R.raw.come);
                        mediaPlayer.setVisibility(View.VISIBLE);
                        myMusic.start();
                        cont = 0;
                        break;
                    case "About A Girl":
                        myMusic.stop();
                        positionLastMusic = position;
                        tvTitulo.setText(musicas.get(positionLastMusic).getNome() + "\n" + musicas.get(positionLastMusic).getArtista());
                        myMusic = MediaPlayer.create(TelaListaActivity.this, R.raw.about);
                        mediaPlayer.setVisibility(View.VISIBLE);
                        myMusic.start();
                        cont = 0;
                        break;
                    case "Polly":
                        myMusic.stop();
                        positionLastMusic = position;
                        tvTitulo.setText(musicas.get(positionLastMusic).getNome() + "\n" + musicas.get(positionLastMusic).getArtista());
                        myMusic = MediaPlayer.create(TelaListaActivity.this, R.raw.polly);
                        mediaPlayer.setVisibility(View.VISIBLE);
                        myMusic.start();
                        cont = 0;
                        break;
                    case "Dumb":
                        myMusic.stop();
                        positionLastMusic = position;
                        tvTitulo.setText(musicas.get(positionLastMusic).getNome() + "\n" + musicas.get(positionLastMusic).getArtista());
                        myMusic = MediaPlayer.create(TelaListaActivity.this, R.raw.dumb);
                        mediaPlayer.setVisibility(View.VISIBLE);
                        myMusic.start();
                        cont = 0;
                        break;
                    case "Heart Shaped Box":
                        myMusic.stop();
                        positionLastMusic = position;
                        tvTitulo.setText(musicas.get(positionLastMusic).getNome() + "\n" + musicas.get(positionLastMusic).getArtista());
                        myMusic = MediaPlayer.create(TelaListaActivity.this, R.raw.heart);
                        mediaPlayer.setVisibility(View.VISIBLE);
                        myMusic.start();
                        cont = 0;
                        break;
                    case "Lithium":
                        myMusic.stop();
                        positionLastMusic = position;
                        tvTitulo.setText(musicas.get(positionLastMusic).getNome() + "\n" + musicas.get(positionLastMusic).getArtista());
                        mediaPlayer.setVisibility(View.VISIBLE);
                        myMusic = MediaPlayer.create(TelaListaActivity.this, R.raw.lithium);
                        myMusic.start();
                        cont = 0;
                        break;
                    case "All Apologies":
                        myMusic.stop();
                        positionLastMusic = position;
                        tvTitulo.setText(musicas.get(positionLastMusic).getNome() + "\n" + musicas.get(positionLastMusic).getArtista());
                        mediaPlayer.setVisibility(View.VISIBLE);
                        myMusic = MediaPlayer.create(TelaListaActivity.this, R.raw.apollogies);
                        myMusic.start();
                        cont = 0;
                        break;
                    default:
                        Toast.makeText(TelaListaActivity.this, "", Toast.LENGTH_SHORT).show();
                        cont = 0;

                }
            }
        });
        prog();
        //ver as opcoes da musica
        lista.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                myMusic.stop();
                return true;
            }
        });

        playerMusica();

        OrdenarSpinner(adapter);


    }

    private void playerMusica() {
        //botao do PLAY
        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (myMusic == null){
                    Toast.makeText(TelaListaActivity.this, "Escolha uma musica", Toast.LENGTH_SHORT).show();
                }else{
                    myMusic.start();
                }
            }
        });
        //botao do PAUSE
        btnPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myMusic.pause();
            }
        });
        //passar para a proxima musica
        btnProximo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                proximaMusica();
            }
        });
        //voltar a musica anterior
        btnAnterior.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cont = 0;
                myMusic.stop();
                if (positionLastMusic == 0) {
                    cont = 0;
                    positionLastMusic = musicas.size();
                }
                positionLastMusic--;
                tvTitulo.setText(musicas.get(positionLastMusic).getNome() + "\n" + musicas.get(positionLastMusic).getArtista());
                myMusic = MediaPlayer.create(TelaListaActivity.this, musicas.get(positionLastMusic).id);
                myMusic.start();
            }
        });
    }

    private void OrdenarSpinner(final ArrayAdapter<Musica> adapter) {
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
                        positionLastMusic = position;
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
                        positionLastMusic = position;
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
                        positionLastMusic = position;
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });


    }

    private void proximaMusica() {
        myMusic.stop();
        cont = 0;
        positionLastMusic++;
        if (positionLastMusic == musicas.size()) {
            positionLastMusic = 0;
            cont = 0;
        }
        tvTitulo.setText(musicas.get(positionLastMusic).getNome() + "\n" + musicas.get(positionLastMusic).getArtista());
        myMusic = MediaPlayer.create(TelaListaActivity.this, musicas.get(positionLastMusic).id);
        myMusic.start();
    }

    private void prog() {
        progressBar = findViewById(R.id.progressBar);
        int periodo = myMusic.getDuration() / 170;
        int delay = 0;
        final TimerTask tt = new TimerTask() {
            @Override
            public void run() {
                progressBar.setProgress(cont);
                if (myMusic.isPlaying()) {
                    cont++;
                }
                if(cont == 100){
                    myMusic.stop();
                }
            }
        };
        t.schedule(tt, delay, periodo);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.sobreNos) {
            Toast.makeText(this, "Sobre Nos", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(TelaListaActivity.this, SobreNosActivity.class);
            startActivity(intent);
        } else if (item.getItemId() == R.id.modoEscuro) {
            Toast.makeText(this, "Modo Escuro Ativado", Toast.LENGTH_SHORT).show();
            RelativeLayout relativeLayout = findViewById(R.id.layoutLista);
            relativeLayout.setBackgroundColor(R.drawable.fundomusica);
        }


        return super.onOptionsItemSelected(item);
    }
}
