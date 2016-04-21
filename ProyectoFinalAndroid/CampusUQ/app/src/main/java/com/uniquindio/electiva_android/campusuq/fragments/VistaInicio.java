package com.uniquindio.electiva_android.campusuq.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.uniquindio.electiva_android.campusuq.R;
import com.uniquindio.electiva_android.campusuq.util.AdaptadorViewPager;

/**
 * A simple {@link Fragment} subclass.
 */
public class VistaInicio extends Fragment {

    private ViewPager viewPager;
    private int nElementos;
    private ImageView[]radios;
    private AdaptadorViewPager adaptadorViewPager;
    private LinearLayout barraIndicador;

    public static final String NOMBRE_ACTION_BAR = "nombre";

    public static VistaInicio instancia = new VistaInicio();

    public VistaInicio() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_vista_inicio, container, false);
    }

    /**
     * Metodo que se ejecuta cuando se ha completado el onCreate de la actividad padre.
     * @param savedInstanceState
     */
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //Es importante inicializar los componentes aqui para que no esten nulos.
        init();
    }

    public void init() {

        viewPager = (ViewPager)getView().findViewById(R.id.viewPager);
        barraIndicador = (LinearLayout)getView().findViewById(R.id.barraIndicador);

        int []idsDescripcion = {R.string.introduccion, R.string.dirigida, R.string.desarroladores, R.string.version};

        adaptadorViewPager = new AdaptadorViewPager(getContext(), idsDescripcion);
        viewPager.setAdapter(adaptadorViewPager);

        viewPager.setCurrentItem(0);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {

                //Para reiniciar los botones
                for (int i = 0; i < nElementos; i++) {
                    radios[i].setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.radio_no_seleccionado));
                }
                radios[position].setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.radio_seleccionado));
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
        initBarraIndicadora();
    }

    public void initBarraIndicadora() {

        nElementos = adaptadorViewPager.getCount();
        radios = new ImageView[nElementos];

        for(int i = 0; i < nElementos; i++) {
            radios[i] = new ImageView(getContext());
            radios[i].setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.radio_no_seleccionado));

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            );

            params.setMargins(4, 0, 4, 0);

            barraIndicador.addView(radios[i], params);
        }
        //Porque el primer boton es donde estamos parados
        radios[0].setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.radio_seleccionado));
    }

}
