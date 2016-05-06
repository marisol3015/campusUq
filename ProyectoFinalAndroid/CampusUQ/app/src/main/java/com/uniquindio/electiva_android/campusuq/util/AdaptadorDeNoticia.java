package com.uniquindio.electiva_android.campusuq.util;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.uniquindio.electiva_android.campusuq.R;
import com.uniquindio.electiva_android.campusuq.fragments.ListaDeNoticiasFragment;
import com.uniquindio.electiva_android.campusuq.vo.noticia;

import java.util.ArrayList;

/**
 * Created by Jhon Jaime on 06/05/2016.
 */
public class AdaptadorDeNoticia extends RecyclerView.Adapter<AdaptadorDeNoticia.noticiaViewHolder> {
    /**
     * Lista de noticias que seran mostradas en la aplicacion.
     */
    private ArrayList<noticia> noticias;

    /**
     * Atributo listener de la clase AdaptadorDeNoticia.
     */
    private static OnClickAdaptadorDeNoticia listener;

    /**
     * Constructor de la clase AdaptadorDeNoticia.
     *
     * @param
     */
    public AdaptadorDeNoticia(ArrayList<noticia> noticia) {

        this.noticias = noticia;
    }

    /**
     * Constructor de la clase AdaptadorDeNoticia.
     *
     * @param noticias
     * @param listaDeNoticiasFragment
     */
    public AdaptadorDeNoticia(ArrayList<noticia> noticias, ListaDeNoticiasFragment listaDeNoticiasFragment) {

        this.noticias = noticias;
        listener = (OnClickAdaptadorDeNoticia) listaDeNoticiasFragment;
    }

    /**
     * Infla o muestra los items o peliculas de la lista (RecyclerView).
     *
     * @param parent
     * @param viewType
     * @return
     */
    @Override
    public noticiaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        //Desde donde se va inflar cada elemento de la lista
        //Params: cardView, el layout contenedor o padre
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.resumen_de_noticia, parent, false);

        noticiaViewHolder noticiaVH = new noticiaViewHolder(itemView);

        return noticiaVH;
    }

    /**
     * Realiza las modificaciones en cada item de la lista
     *
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(noticiaViewHolder holder, int position) {

        noticia noticia = noticias.get(position);

        holder.binNoticia(noticia);

    }

    /**
     * Metodo que permite al adaptador saber la cantidad de elementos que se procesaran.
     *
     * @return numero de noticias
     */
    @Override
    public int getItemCount() {
        return noticias.size();
    }

    /**
     * Clase que extiende de ViewHolder para describir cada item de la lista
     * e implementa OnClickListener para asignarles un evento.
     */
    public static class noticiaViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public ImageView imagen;
        /**
         * Atributo txtTitulo de la clase.
         */
        private TextView txtTitulo;


        /**
         * Constructor de la clase noticiaViewHolder.
         *
         * @param itemView
         */
        public noticiaViewHolder(View itemView) {
            super(itemView);

            //Se le asigna un evento a cada elemento de la lista
            itemView.setOnClickListener(this);
            txtTitulo = (TextView) itemView.findViewById(R.id.titulo);
            imagen = (ImageView) itemView.findViewById(R.id.image);

        }

        /**
         * Actualiza los datos de una noticia.
         *
         * @param n noticia a ser modificada.
         */
        public void binNoticia(noticia n) {
            txtTitulo.setText(n.getTitulo());
            imagen.setImageResource(n.getIdImagen());


        }

        /**
         * Metodo que controla el evento de los componentes.
         *
         * @param v
         */
        @Override
        public void onClick(View v) {


            Toast toast = Toast.makeText(v.getContext(),R.string.Toast, Toast.LENGTH_LONG);
            View view = toast.getView();

            view.setBackgroundResource(R.color.toastColor);

            /*here you can do anything with text*/
            toast.show();

            listener.onClickPosicion(getAdapterPosition());

        }


    }

    /**
     * Interface que permite comunicar el adaptador con la clase ListaDeNoticiasFragment
     */
    public interface OnClickAdaptadorDeNoticia {
        public void onClickPosicion(int pos);
    }

    }
