package com.uniquindio.electiva_android.campusuq.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.uniquindio.electiva_android.campusuq.R;
import com.uniquindio.electiva_android.campusuq.fragments.DetalleDeNoticiasFragment;
import com.uniquindio.electiva_android.campusuq.vo.noticia;


/**
 * Actividad que permite visualizar el detalle de una noticia
 * a traves del fragmento fragmento_detalle_noticia
 * @author Marisol Ocampo

 */

public class DetalleDeNoticiaActivity extends AppCompatActivity {


    /**
     * Metodo que se llama en la creacion de la actividad
     * e inicializacion de sus componentes
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_de_noticia);

        DetalleDeNoticiasFragment detalleDeNoticiasFragment = (DetalleDeNoticiasFragment)getSupportFragmentManager().findFragmentById(R.id.fragmento_detalle_noticia);

        noticia noticias = (noticia) getIntent().getExtras().get("Noticia");
        detalleDeNoticiasFragment.mostrarNoticia(noticias);
    }


}
