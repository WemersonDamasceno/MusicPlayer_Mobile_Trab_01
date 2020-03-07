package com.example.trab_01.views;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.example.trab_01.R;
import com.example.trab_01.views.views_bandas.HistoricoGunsActivity;
import com.example.trab_01.views.views_bandas.HistoricoNirvanaActivity;
import com.example.trab_01.views.views_bandas.HistoricoPearlActivity;


public class MainActivity extends Activity {
    Button btnConfirmar;
    EditText ediText;
    TextView textView;
    Button btnTelaLista;
    TextView tvNome;
    Button btnBandas;
    Button btnOk;
    AutoCompleteTextView txtAutoComplete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ediText = findViewById(R.id.edText);
        btnBandas = findViewById(R.id.btnBandas);
        textView = findViewById(R.id.idText);
        btnConfirmar = findViewById(R.id.btnConfimar);
        btnTelaLista = findViewById(R.id.btnTelaLista);
        tvNome = findViewById(R.id.tvSejaBemVindo);
        final ToggleButton toggle = findViewById(R.id.btnToggle);
        btnOk = findViewById(R.id.btnOk);
        txtAutoComplete = findViewById(R.id.txtAutoComplete);


        btnConfirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (toggle.isChecked()) {
                    if (ediText.getText() == null || ediText.length() == 0) {
                        Toast.makeText(MainActivity.this, "Insira um texto", Toast.LENGTH_SHORT).show();
                    } else {
                        textView.setText(ediText.getText());
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Ative o toggle para preencher o texto", Toast.LENGTH_SHORT).show();
                }
            }
        });


        btnTelaLista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), TelaListaActivity.class);
                startActivity(intent);
            }
        });


        toggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Toast.makeText(MainActivity.this, "O Toggle está ATIVADO", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "O Toggle está DESATIVADO", Toast.LENGTH_SHORT).show();
                }
            }
        });


        autoComplete();
        if (txtAutoComplete.getText() != null) {
            btnOk.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    tvNome.setText("Seja Bem Vindo " + txtAutoComplete.getText() + "!");
                }
            });
        }


        btnBandas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(MainActivity.this, btnBandas);
                popupMenu.getMenuInflater().inflate(R.menu.menu_bandas, popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        if (item.getItemId() == R.id.banda1) {
                            Intent intent = new Intent(MainActivity.this, HistoricoNirvanaActivity.class);
                            startActivity(intent);
                            //nirvana
                        } else if (item.getItemId() == R.id.banda2) {
                            Intent intent = new Intent(MainActivity.this, HistoricoGunsActivity.class);
                            startActivity(intent);
                            //guns
                        } else if (item.getItemId() == R.id.banda3) {
                            Intent intent = new Intent(MainActivity.this, HistoricoPearlActivity.class);
                            startActivity(intent);
                            //pearl jam
                        }
                        return true;
                    }
                });
                popupMenu.show();
            }
        });


    }

    private void autoComplete() {
        String lista[] = {"Ana", "Matheus", "Vinicius", "Wemerson", "Marcio",
                "Marcelo", "Bruna", "Babu", "Arthur", "Maxwell", "Naruto"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, lista);

        txtAutoComplete.setThreshold(1);
        txtAutoComplete.setAdapter(adapter);
    }




}
