package com.uniquindio.electiva_android.campusuq.util;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.uniquindio.electiva_android.campusuq.R;
import com.uniquindio.electiva_android.campusuq.vo.noticia;

import java.util.ArrayList;



/**
 * Created by Marisol on 29/04/2016.
 */
public class AdaptadorDeNoticia extends RecyclerView.Adapter<AdaptadorDeNoticia.NoticiaViewHolder> {
    private ArrayList<noticia> noticia;

    public AdaptadorDeNoticia(ArrayList<noticia> noticia) {

        this.noticia = noticia;
    }

    @Override
    public NoticiaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //Desde donde se va inflar cada elemento de la lista
        //Params: cardView, el layout contenedor o padre
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.resumen_de_noticia, parent, false);

        NoticiaViewHolder noticiaVH = new NoticiaViewHolder(itemView);

        return noticiaVH;
    }

    @Override
    public void onBindViewHolder(NoticiaViewHolder holder, int position) {
        noticia noticias = noticia.get(position);
        holder.binNoticia(noticias);
    }

    @Override
    public int getItemCount() {
        return noticia.size();
    }

    public static class NoticiaViewHolder extends RecyclerView.ViewHolder {
        private TextView txtTitulo;


        public NoticiaViewHolder(View itemView) {
            super(itemView);
            txtTitulo = (TextView) itemView.findViewById(R.id.titulo);

        }

        public void binNoticia(noticia n) {
            txtTitulo.setText(n.getTitulo());

        }
    }
}
