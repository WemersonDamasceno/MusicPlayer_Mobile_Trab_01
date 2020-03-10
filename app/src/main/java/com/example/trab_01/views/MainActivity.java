package com.example.trab_01.views;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.trab_01.R;
import com.example.trab_01.adapters.ViewPagerAdapter;
import com.example.trab_01.fragments.SobreNosFragment;
import com.example.trab_01.views.views_bandas.HistoricoGunsActivity;
import com.example.trab_01.views.views_bandas.HistoricoNirvanaActivity;
import com.example.trab_01.views.views_bandas.HistoricoPearlActivity;
import com.google.android.material.tabs.TabLayout;


public class MainActivity extends AppCompatActivity {


    ViewPager viewPager;
    ViewPagerAdapter viewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        viewPager = findViewById(R.id.pager);
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(viewPagerAdapter);


        //teste para mudar a cor do actionBar
        ActionBar bar = getSupportActionBar();
        bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#232324")));



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.configuracoes) {
            Toast.makeText(this, "Configurações ainda não está disponivel", Toast.LENGTH_SHORT).show();
        } else if (item.getItemId() == R.id.modoClaro) {
            Toast.makeText(this, "Modo Claro ainda não está disponivel", Toast.LENGTH_SHORT).show();
        } else if(item.getItemId() == R.id.vWeb){
            Toast.makeText(this, "Versão web ainda não disponivel", Toast.LENGTH_SHORT).show();
        }else if(item.getItemId() == R.id.feedback){
            Toast.makeText(this, "Feedback ainda não está indiponivel", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }


}
