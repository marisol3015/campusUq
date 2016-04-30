package com.uniquindio.electiva_android.campusuq.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.uniquindio.electiva_android.campusuq.R;
import com.uniquindio.electiva_android.campusuq.util.AdaptadorDeNoticia;
import com.uniquindio.electiva_android.campusuq.vo.noticia;

import java.util.ArrayList;



public class Noticias extends AppCompatActivity {
    private ArrayList<noticia> noticia;
    private RecyclerView listaNoticias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_noticias);
        noticia = new ArrayList();
        noticia.add(new noticia(getResources().getString(R.string.noticia1)));
        noticia.add(new noticia(getResources().getString(R.string.noticia2)));
        noticia.add(new noticia(getResources().getString(R.string.noticia3)));
        noticia.add(new noticia(getResources().getString(R.string.noticia4)));
        noticia.add(new noticia(getResources().getString(R.string.noticia5)));



        listaNoticias = (RecyclerView) findViewById(R.id.RecView);
        final AdaptadorDeNoticia adaptador = new AdaptadorDeNoticia(noticia);
        listaNoticias.setAdapter(adaptador);
        listaNoticias.setLayoutManager(         new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
    }
}
