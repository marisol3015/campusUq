package com.uniquindio.electiva_android.campusuq.dialogos;


import android.app.DialogFragment;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.uniquindio.electiva_android.campusuq.R;

/**
 * Fragmento de dialogo que representa la vista de una Sugerencia.
 * @author Jhon Jaime Ramirez
 * @author Marisol Ocampo
 * @author Carlos A. Ospina
 * @author Universidad del Quindío
 * @version 1.0
 * @since 2016-04-16.
 */
public class Sugerencia extends DialogFragment {

    /**
     * Atributo btnEnviar de la clase Sugerencia.
     */
    private Button btnEnviar;

    /**
     * Atributo btnCancelar de la clase Sugerencia.
     */
    private Button btnCancelar;

    /**
     * Constructor de la clase Sugerencia.
     */
    public Sugerencia() {
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
        return inflater.inflate(R.layout.fragment_sugerencia, container, false);
    }

    /**
     * Metood que se ejecuta cuando se ha completado el onCreate en la actividad padre
     * @param savedInstanceState
     */
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        btnEnviar = (Button) getView().findViewById(R.id.btnEnviar);
        btnCancelar = (Button) getView().findViewById(R.id.btnCancelar);

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, "Enviar sugerencia", Snackbar.LENGTH_SHORT).show();
            }
        });

        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
    }
}
