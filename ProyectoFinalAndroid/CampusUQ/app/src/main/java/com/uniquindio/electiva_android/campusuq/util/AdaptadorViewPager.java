package com.uniquindio.electiva_android.campusuq.util;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.uniquindio.electiva_android.campusuq.R;

/**
 * CLase que representa el adaptador para la vista de inicio.
 * @author Jhon Jaime Ramirez
 * @author Marisol Ocampo
 * @author Carlos A. Ospina
 * @author Universidad del Quindío
 * @version 1.0
 * @since 2016-04-16.
 */
public class AdaptadorViewPager extends PagerAdapter {

    /**
     * Atributo contexto de la clase AdaptadorViewPager.
     */
    private Context contexto;

    /**
     * Atributo listaTextos de la clase AdaptadorViewPager.
     */
    private int[] listaTextos;

    /**
     * Constructor de la clase AdaptadorViewPager.
     * @param contexto
     * @param listaTextos
     */
    public AdaptadorViewPager(Context contexto, int[] listaTextos) {
        this.contexto = contexto;
        this.listaTextos = listaTextos;
    }

    /**
     * Metodo que permite obtener la lista de textos o paginas de la vista
     * @return
     */
    @Override
    public int getCount() {
        return listaTextos.length;
    }

    /**
     * Determina si una vista esta asociada con un objeto clave especifico.
     * @param view
     * @param object
     * @return
     */
    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((LinearLayout)object);
    }

    /**
     * Metodo que permite inicializar los componentes en la vista actual.
     * @param container
     * @param position
     * @return
     */
    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        View vista = LayoutInflater.from(contexto).inflate(R.layout.texto_descripcion_inicio, container, false);

        TextView txtView = (TextView)vista.findViewById(R.id.descripcion);
        //txtView.setText(listaTextos[position]);
        txtView.setText(listaTextos[position]);

        container.addView(vista);

        return vista;

    }

    /**
     * Metodo que permite destruir o eliminar la vista que ya no es visible.
     * @param container
     * @param position
     * @param object
     */
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout) object);
    }
}