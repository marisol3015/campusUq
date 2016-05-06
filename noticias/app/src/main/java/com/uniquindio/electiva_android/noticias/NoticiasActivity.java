package com.uniquindio.electiva_android.noticias;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.ArrayList;

import fragmets.DetalleDeNoticiasFragment;
import fragmets.ListaDeNoticiasFragment;
import vo.noticia;

public class NoticiasActivity extends AppCompatActivity implements ListaDeNoticiasFragment.OnNoticiaSeleccionadaListener {
    /**
     * Atributo de clase que rebresenta la lista de noticias.
     */
    private ArrayList<noticia> noticia;
    private ArrayList<noticia> noticiaP;

    /**
     * Metodo que se llama en la creacion de la actividad
     * e inicializacion de sus componentes
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Utilidades.obtenerLenguaje(this);

        setContentView(R.layout.activity_noticias);
        noticia = new ArrayList();
        noticia.add(new noticia(R.drawable.encabezado1,getResources().getString(R.string.noticia1), getResources().getString(R.string.detalle1)));
        noticia.add(new noticia(R.drawable.encabezado2,getResources().getString(R.string.noticia2), getResources().getString(R.string.detalle2)));
        noticia.add(new noticia(R.drawable.encabezado3,getResources().getString(R.string.noticia3), getResources().getString(R.string.detalle3)));
        noticia.add(new noticia(R.drawable.encabezado4,getResources().getString(R.string.noticia4), getResources().getString(R.string.detalle4)));
        noticia.add(new noticia(R.drawable.encabezado5,getResources().getString(R.string.noticia5), getResources().getString(R.string.detalle5)));

        //getSupportFragmentManager() para la gestion de fragmentos
        ListaDeNoticiasFragment listaDeNoticiasFragment = (ListaDeNoticiasFragment) getSupportFragmentManager().findFragmentById(R.id.fragmento_lista_noticia);
        listaDeNoticiasFragment.setNoticia(noticia);
    }


    /**
     * Este metodo permite comunicar a la actividad con los fragmentos
     * para poder visualizar sus componentes y ejecutar sus eventos
     *
     * @param position Posicion en la que se encuentra el adaptador
     */
    @Override
    public void onNoticiaSeleccionadaListener(int position) {


        boolean esFragmento = getSupportFragmentManager().findFragmentById(R.id.fragmento_detalle_noticia) != null;
        boolean compoenente = ((TextView) findViewById(R.id.titulo_de_detalle_noticia)) != null;
        boolean imagenes= findViewById(R.id.image)!=null;

        if (esFragmento && compoenente&&imagenes) {
            ((DetalleDeNoticiasFragment) getSupportFragmentManager().findFragmentById(
                    R.id.fragmento_detalle_noticia
            )).mostrarNoticia(noticia.get(position));
        } else {
            Intent intent = new Intent(this, DetalleDeNoticiaActivity.class);
            intent.putExtra("Noticia", noticia.get(position));

            //Con este metodo se acciona la otra actividad en este caso DetalleDePeliculaActivity
            startActivity(intent);
        }
    }
}
