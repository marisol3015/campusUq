package com.uniquindio.electiva_android.campusuq.dialogos;


import android.app.DialogFragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.uniquindio.electiva_android.campusuq.R;
import com.uniquindio.electiva_android.campusuq.activity.CampusUQ;
import com.uniquindio.electiva_android.campusuq.util.Utilidades;
/**
 * Fragmento de dialogo que representa la vista de seleccion de Idioma de la app.
 * @author Jhon Jaime Ramirez
 * @author Marisol Ocampo
 * @author Carlos A. Ospina
 * @author Universidad del Quindío
 * @version 1.0
 * @since 2016-04-16.
 */
public class Idioma extends DialogFragment {

    /**
     * Atributo que representa el boton espanol de la clase Idioma
     */
    private ImageButton espanol;

    /**
     * Atributo que representa el boton Ingles de la clase Idioma
     */
    private ImageButton ingles;

    /**
     * Atributo que representa la actividad principal de la app.
     */
    private CampusUQ principal;

    /**
     * Constructor de la clase Idioma.
     * @param principal
     */
    public Idioma(CampusUQ principal) {
        this.principal = principal;
    }

    /**
     * Constructor de la clase Idioma.
     */
    public Idioma() {
        // Required empty public constructor
    }

    /**
     * Método que se llama cuando es el momento de que se dibuje el fragmento.
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_idioma, container, false);
    }

    /**
     * Metood que se ejecuta cuando se ha completado el onCreate en la actividad padre
     * @param savedInstanceState
     */
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        espanol = (ImageButton) getView().findViewById(R.id.espanol);
        ingles = (ImageButton) getView().findViewById(R.id.ingles);

        espanol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Utilidades.cambiarIdioma(principal.getBaseContext(), Utilidades.LENGUAJE_ES);
                Intent intent = getActivity().getIntent();
                getActivity().finish();
                startActivity(intent);
            }
        });

        ingles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Utilidades.cambiarIdioma(principal.getBaseContext(), Utilidades.LENGUAJE_EN);
                Intent intent = getActivity().getIntent();
                getActivity().finish();
                startActivity(intent);
            }
        });
    }
}
