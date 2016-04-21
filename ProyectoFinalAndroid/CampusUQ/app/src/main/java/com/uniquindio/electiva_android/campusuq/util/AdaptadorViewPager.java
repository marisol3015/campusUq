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
 * Created by Carlos on 17/4/2016.
 */
public class AdaptadorViewPager extends PagerAdapter {

    private Context contexto;
    private int[] listaTextos;

    public AdaptadorViewPager(Context contexto, int[] listaTextos) {
        this.contexto = contexto;
        this.listaTextos = listaTextos;
    }

    @Override
    public int getCount() {
        return listaTextos.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((LinearLayout)object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        View vista = LayoutInflater.from(contexto).inflate(R.layout.texto_descripcion_inicio, container, false);

        TextView txtView = (TextView)vista.findViewById(R.id.descripcion);
        //txtView.setText(listaTextos[position]);
        txtView.setText(listaTextos[position]);

        container.addView(vista);

        return vista;

    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout) object);
    }
}
