package com.uniquindio.electiva_android.campusuq.util;

import android.app.FragmentManager;

import com.uniquindio.electiva_android.campusuq.R;
import com.uniquindio.electiva_android.campusuq.dialogos.Sugerencia;

/**
 * Created by Carlos on 23/4/2016.
 */
public class Utilidades {


    public static void mostrarDialogoSugerencia(FragmentManager fragmentManager, String nameClass) {

        Sugerencia sugerencia = new Sugerencia();
        sugerencia.setStyle(sugerencia.STYLE_NO_TITLE, R.style.MiDialogo);
        sugerencia.show(fragmentManager, nameClass);
    }
}
