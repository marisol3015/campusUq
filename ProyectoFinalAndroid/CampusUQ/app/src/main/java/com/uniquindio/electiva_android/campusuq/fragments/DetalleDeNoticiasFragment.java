package com.uniquindio.electiva_android.campusuq.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.uniquindio.electiva_android.campusuq.R;
import com.uniquindio.electiva_android.campusuq.vo.noticia;
/**
 * A simple {@link Fragment} subclass.
 */
public class DetalleDeNoticiasFragment extends Fragment {

    /**
     * Atributo titulo de la clase DetalleDeNoticiaFragment.
     */

    private ImageView imagen;

    private ImageButton imagen2;


    private TextView titulo;
    private TextView detalle;
    private ImageButton face;
    /**
     * Atributo pelicula de la clase DetalleDeNoticiaFragment.
     */
    private noticia noticia;

    /**
     * Constructor de la clase DetalleDeNoticia Fragment.
     */
    public DetalleDeNoticiasFragment() {
        // Required empty public constructor
    }

    /**
     * Metodo que se llama cuando es el momento de que se dibuje el fragmento
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detalle_de_noticias, container, false);
    }

    /**
     * Metodo que permite setar los valores de la noticia en
     * los compoenentes de DetalleDeNoticiaFragmente
     * @param noticia
     */
    public void mostrarNoticia(noticia noticia) {
        this.noticia = noticia;

        imagen = (ImageView) getView().findViewById(R.id.imagen_detalle);
        imagen.setImageResource(noticia.getIdImagen());
        face= (ImageButton) getView().findViewById(R.id.BtnImagen);
        imagen2= (ImageButton) getView().findViewById(R.id.BtnImagen2);
        // face.setImageResource(noticia.getIdImagen());
        titulo = (TextView)getView().findViewById(R.id.titulo_de_detalle_noticia);
        titulo.setText(noticia.getTitulo());
        detalle = (TextView)getView().findViewById(R.id.descripcion_de_detalle_noticia);
        detalle.setText(noticia.getDetalle());


    }


}
