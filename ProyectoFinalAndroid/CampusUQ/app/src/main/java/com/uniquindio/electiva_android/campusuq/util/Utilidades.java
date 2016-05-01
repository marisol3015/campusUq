package com.uniquindio.electiva_android.campusuq.util;

import android.app.FragmentManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;

import com.uniquindio.electiva_android.campusuq.R;
import com.uniquindio.electiva_android.campusuq.activity.CampusUQ;
import com.uniquindio.electiva_android.campusuq.dialogos.Idioma;
import com.uniquindio.electiva_android.campusuq.dialogos.Sugerencia;

import java.util.Locale;

/**
 * Clase que contiene una serie de procesos generales para la facilidad de acceso entre las clases.
 * @author Jhon Jaime Ramirez
 * @author Marisol Ocampo
 * @author Carlos A. Ospina
 * @author Universidad del Quindío
 * @version 1.0
 * @since 2016-04-16.
 */
public class Utilidades {

    /**
     * Constante utilizada como valor general para el nombre de las preferencias
     */
    public final static String MIS_PREFERENCIAS = "MisPreferencias";

    /**
     * Constante utilizada para como llave para el nombre de las preferencias de lenguaje
     */
    public final static String LENGUAJE_DE_PREFERENCIA = "languaje_preferences";

    /**
     * Constante utilizada para definir el idioma español con el codigo ISO-639-1.
     */
    public final static String LENGUAJE_ES = "es";

    /**
     * Constante utilizada para definir el idioma ingles con el codigo ISO-639-1.
     */
    public final static String LENGUAJE_EN = "en";

    /**
     * Método que permite visualizar el dialogFragment Sugerencia.
     * @param fragmentManager Utilizado para la gestion de fragmentos.
     * @param nameClass Nombre de la clase padre.
     */
    public static void mostrarDialogoSugerencia(FragmentManager fragmentManager, String nameClass) {

        Sugerencia sugerencia = new Sugerencia();
        sugerencia.setStyle(sugerencia.STYLE_NO_TITLE, R.style.MiDialogo);
        sugerencia.show(fragmentManager, nameClass);
    }

    /**
     * Método que permite visualizar el dialogFragment Idioma.
     * @param fragmentManager Utilizado para la gestion de fragmentos.
     * @param nameClass Nombre de la clase padre.
     */
    public static void mostrarDialogoIdioma(FragmentManager fragmentManager, String nameClass, CampusUQ campus) {

        Idioma idioma = new Idioma(campus);
        idioma.setStyle(idioma.STYLE_NO_TITLE, R.style.MiDialogo);
        idioma.show(fragmentManager, nameClass);

    }

    /**
     * Metodo que permite cambiar el idioma de la aplicacion
     * @param context
     */
    public static void cambiarIdioma(Context context, String lenguaje) {
        SharedPreferences prefs =
                context.getSharedPreferences(MIS_PREFERENCIAS,
                        context.MODE_PRIVATE);

        if (lenguaje.equals(LENGUAJE_ES)) {
            lenguaje = LENGUAJE_ES;
        } else if (lenguaje.equals(LENGUAJE_EN)) {
            lenguaje = LENGUAJE_EN;
        }
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(LENGUAJE_DE_PREFERENCIA, lenguaje);
        editor.commit();
        obtenerLenguaje(context);
    }

    /**
     * Metodo que permite actualizar la configuracion para obtener el cambio de idioma visualmente.
     * @param context Contexto de la aplicacion que lo invoco.
     */
    public static void obtenerLenguaje(Context context) {
        SharedPreferences prefs =
                context.getSharedPreferences(MIS_PREFERENCIAS, context.MODE_PRIVATE);
        String language = prefs.getString(LENGUAJE_DE_PREFERENCIA,
                LENGUAJE_ES);
        Locale locale = new Locale(language);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;

        context.getApplicationContext().getResources().updateConfiguration(config, null);
    }

}
