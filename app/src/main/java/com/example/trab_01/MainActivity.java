package com.example.trab_01;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends Activity {
Button btnConfirmar;
EditText ediText;
TextView textView;
Button btnTelaLista;
TextView tvNome;
Button btnOk;
AutoCompleteTextView txtAutoComplete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ediText = findViewById(R.id.edText);
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
                if(toggle.isChecked()) {
                    if (ediText.getText() == null || ediText.length() == 0) {
                        Toast.makeText(MainActivity.this, "Insira um texto", Toast.LENGTH_SHORT).show();
                    } else {
                        textView.setText(ediText.getText());
                    }
                }else {
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
        if (txtAutoComplete.getText() != null){
            btnOk.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    tvNome.setText("Seja Bem Vindo "+txtAutoComplete.getText()+"!");
                }
            });
        }





    }

    private void autoComplete() {
        String lista[]={"Ana","Matheus","Vinicius","Wemerson","Marcio",
                "Marcelo","Bruna","Babu","Arthur","Maxwell","Naruto"};



        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line,lista);

        txtAutoComplete.setThreshold(1);
        txtAutoComplete.setAdapter(adapter);
    }

}
