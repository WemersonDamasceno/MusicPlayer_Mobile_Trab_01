package com.example.trab_01.fragments;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
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
import com.example.trab_01.adapters.ViewPagerAdapter;
import com.example.trab_01.views.TelaListaActivity;
import com.example.trab_01.views.views_bandas.HistoricoGunsActivity;
import com.example.trab_01.views.views_bandas.HistoricoNirvanaActivity;
import com.example.trab_01.views.views_bandas.HistoricoPearlActivity;
import com.google.android.material.tabs.TabLayout;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {
    private Button btnConfirmar;
    private EditText ediText;
    private TextView textView;
    private TextView tvNome;
    private Button btnBandas;
    private Button btnOk;
    private AutoCompleteTextView txtAutoComplete;


    ViewPager viewPager;
    ViewPagerAdapter viewPagerAdapter;

    public MainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false);


    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ediText = view.findViewById(R.id.edText);
        btnBandas = view.findViewById(R.id.btnBandas);
        textView = view.findViewById(R.id.idText);
        btnConfirmar = view.findViewById(R.id.btnConfimar);
        tvNome = view.findViewById(R.id.tvSejaBemVindo);
        final ToggleButton toggle = view.findViewById(R.id.btnToggle);
        btnOk = view.findViewById(R.id.btnOk);
        txtAutoComplete = view.findViewById(R.id.txtAutoComplete);


        //botao para mudar o TextView
        btnConfirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (toggle.isChecked()) {
                    if (ediText.getText() == null || ediText.length() == 0) {
                        Toast.makeText(getContext(), "Insira um texto", Toast.LENGTH_SHORT).show();
                    } else {
                        textView.setText(ediText.getText());
                    }
                } else {
                    Toast.makeText(getContext(), "Ative o toggle para preencher o texto", Toast.LENGTH_SHORT).show();
                }
            }
        });
        //Botao do Toggle
        toggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Toast.makeText(getContext(), "O Toggle está ATIVADO", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getContext(), "O Toggle está DESATIVADO", Toast.LENGTH_SHORT).show();
                }
            }
        });
        autoComplete();
        if (txtAutoComplete.getText() != null) {
            btnOk.setOnClickListener(new View.OnClickListener() {
                @SuppressLint("SetTextI18n")
                @Override
                public void onClick(View v) {
                    tvNome.setText("Seja Bem Vindo "+txtAutoComplete.getText() + "!");
                }
            });
        }
        //menuPopUp
        btnBandas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(getContext(), btnBandas);
                popupMenu.getMenuInflater().inflate(R.menu.menu_bandas, popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        if (item.getItemId() == R.id.banda1) {
                            Intent intent = new Intent(getContext(), HistoricoNirvanaActivity.class);
                            startActivity(intent);
                            //nirvana
                        } else if (item.getItemId() == R.id.banda2) {
                            Intent intent = new Intent(getContext(), HistoricoGunsActivity.class);
                            startActivity(intent);
                            //guns
                        } else if (item.getItemId() == R.id.banda3) {
                            Intent intent = new Intent(getContext(), HistoricoPearlActivity.class);
                            startActivity(intent);
                            //pearl jam
                        }
                        return true;
                    }
                });
                popupMenu.show();
            }
        });

        autoComplete();

    }
    private void autoComplete() {
        String lista[] = {"Ana", "Matheus", "Vinicius", "Wemerson", "Marcio",
                "Marcelo", "Bruna", "Babu", "Arthur", "Maxwell", "Naruto"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_dropdown_item_1line, lista);
        txtAutoComplete.setThreshold(1);
        txtAutoComplete.setAdapter(adapter);
    }




}
