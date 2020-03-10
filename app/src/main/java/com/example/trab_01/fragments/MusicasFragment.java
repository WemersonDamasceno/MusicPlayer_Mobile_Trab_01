package com.example.trab_01.fragments;


import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.trab_01.R;
import com.example.trab_01.adapters.MusicaAdapter;
import com.example.trab_01.models.Musica;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Timer;
import java.util.TimerTask;

/**
 * A simple {@link Fragment} subclass.
 */
public class MusicasFragment extends Fragment {
    private Spinner spinner;
    //botoes do player
    private ImageView btnAnterior;
    private ImageView btnPlay;
    private ImageView btnProximo;
    private ImageView btnPause;
    private TextView tvTitulo;
    private Timer t;

    private LinearLayout mediaPlayer;
    private ImageView btnVoltarMedia;

    private ProgressBar progressBar;
    private int cont = 0;
    private int positionLastMusic = 0;
    private MediaPlayer myMusic;
    private static ArrayList<Musica> musicas = new ArrayList<>();


    public MusicasFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_musicas, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mediaPlayer = view.findViewById(R.id.mediaPlayer);
        btnVoltarMedia = view.findViewById(R.id.btnVoltar);

        t = new Timer();
        btnAnterior = view.findViewById(R.id.btnAnterior);
        btnPlay = view.findViewById(R.id.btnPlay);
        btnProximo = view.findViewById(R.id.btnProximo);
        btnPause = view.findViewById(R.id.btnPause);
        myMusic = MediaPlayer.create(getContext(), R.raw.silver);
        spinner = view.findViewById(R.id.spinner);
        tvTitulo = view.findViewById(R.id.tituloMusica);
        progressBar = view.findViewById(R.id.progressBar);


        final ListView lista = view.findViewById(R.id.listView);
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
        final ArrayAdapter<Musica> adapter = new MusicaAdapter(getContext(), musicas);
        lista.setAdapter(adapter);
        //voltar pra lista
        btnVoltarMedia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.setVisibility(View.INVISIBLE);
            }
        });
        //mostrar mediaplayer
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
                if (mediaPlayer.getVisibility() == View.INVISIBLE) {
                    switch (musicas.get(position).getNome()) {
                        case "Smells Like Teen Spirit":
                            myMusic.stop();
                            positionLastMusic = position;
                            tvTitulo.setText(musicas.get(positionLastMusic).getNome() + "\n" + musicas.get(positionLastMusic).getArtista());
                            myMusic = MediaPlayer.create(getContext(), R.raw.smells_trinta);
                            mediaPlayer.setVisibility(View.VISIBLE);
                            myMusic.start();
                            cont = 0;
                            break;
                        case "Silver":
                            myMusic.stop();
                            positionLastMusic = position;
                            tvTitulo.setText(musicas.get(positionLastMusic).getNome() + "\n" + musicas.get(positionLastMusic).getArtista());
                            myMusic = MediaPlayer.create(getContext(), R.raw.silver);
                            mediaPlayer.setVisibility(View.VISIBLE);
                            myMusic.start();
                            cont = 0;
                            break;
                        case "Come As You Are":
                            myMusic.stop();
                            positionLastMusic = position;
                            tvTitulo.setText(musicas.get(positionLastMusic).getNome() + "\n" + musicas.get(positionLastMusic).getArtista());
                            myMusic = MediaPlayer.create(getContext(), R.raw.come);
                            mediaPlayer.setVisibility(View.VISIBLE);
                            myMusic.start();
                            cont = 0;
                            break;
                        case "About A Girl":
                            myMusic.stop();
                            positionLastMusic = position;
                            tvTitulo.setText(musicas.get(positionLastMusic).getNome() + "\n" + musicas.get(positionLastMusic).getArtista());
                            myMusic = MediaPlayer.create(getContext(), R.raw.about);
                            mediaPlayer.setVisibility(View.VISIBLE);
                            myMusic.start();
                            cont = 0;
                            break;
                        case "Polly":
                            myMusic.stop();
                            positionLastMusic = position;
                            tvTitulo.setText(musicas.get(positionLastMusic).getNome() + "\n" + musicas.get(positionLastMusic).getArtista());
                            myMusic = MediaPlayer.create(getContext(), R.raw.polly);
                            mediaPlayer.setVisibility(View.VISIBLE);
                            myMusic.start();
                            cont = 0;
                            break;
                        case "Dumb":
                            myMusic.stop();
                            positionLastMusic = position;
                            tvTitulo.setText(musicas.get(positionLastMusic).getNome() + "\n" + musicas.get(positionLastMusic).getArtista());
                            myMusic = MediaPlayer.create(getContext(), R.raw.dumb);
                            mediaPlayer.setVisibility(View.VISIBLE);
                            myMusic.start();
                            cont = 0;
                            break;
                        case "Heart Shaped Box":
                            myMusic.stop();
                            positionLastMusic = position;
                            tvTitulo.setText(musicas.get(positionLastMusic).getNome() + "\n" + musicas.get(positionLastMusic).getArtista());
                            myMusic = MediaPlayer.create(getContext(), R.raw.heart);
                            mediaPlayer.setVisibility(View.VISIBLE);
                            myMusic.start();
                            cont = 0;
                            break;
                        case "Lithium":
                            myMusic.stop();
                            positionLastMusic = position;
                            tvTitulo.setText(musicas.get(positionLastMusic).getNome() + "\n" + musicas.get(positionLastMusic).getArtista());
                            mediaPlayer.setVisibility(View.VISIBLE);
                            myMusic = MediaPlayer.create(getContext(), R.raw.lithium);
                            myMusic.start();
                            cont = 0;
                            break;
                        case "All Apologies":
                            myMusic.stop();
                            positionLastMusic = position;
                            tvTitulo.setText(musicas.get(positionLastMusic).getNome() + "\n" + musicas.get(positionLastMusic).getArtista());
                            mediaPlayer.setVisibility(View.VISIBLE);
                            myMusic = MediaPlayer.create(getContext(), R.raw.apollogies);
                            myMusic.start();
                            cont = 0;
                            break;
                        default:
                            Toast.makeText(getContext(), "", Toast.LENGTH_SHORT).show();
                            cont = 0;
                    }//switch
                }// IF
            } //onItemClick
        });//Lista
        //ver as opcoes da musica
        lista.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                myMusic.stop();
                return true;
            }
        });

        playerMusica();
        prog();
        OrdenarSpinner(adapter);


    }

    private void playerMusica() {
        //botao do PLAY
        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (myMusic == null) {
                    Toast.makeText(getContext(), "Escolha uma musica", Toast.LENGTH_SHORT).show();
                } else {
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
                myMusic = MediaPlayer.create(getContext(), musicas.get(positionLastMusic).id);
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

        ArrayAdapter<String> adp = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_dropdown_item, list_of_order);

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
        myMusic = MediaPlayer.create(getContext(), musicas.get(positionLastMusic).id);
        myMusic.start();
    }

    private void prog() {
        int periodo = myMusic.getDuration() / 170;
        int delay = 0;
        final TimerTask tt = new TimerTask() {
            @Override
            public void run() {
                progressBar.setProgress(cont);
                if (myMusic.isPlaying()) {
                    cont++;
                }
                if (cont == 100) {
                    myMusic.stop();
                }
            }
        };
        t.schedule(tt, delay, periodo);
    }

}



