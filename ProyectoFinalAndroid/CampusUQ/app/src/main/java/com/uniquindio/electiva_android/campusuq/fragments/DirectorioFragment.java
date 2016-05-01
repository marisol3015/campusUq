package com.uniquindio.electiva_android.campusuq.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.uniquindio.electiva_android.campusuq.R;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Fragmento que representa la vista del directorio de la aplicación.
 * @author Jhon Jaime Ramirez
 * @author Marisol Ocampo
 * @author Carlos A. Ospina
 * @author Universidad del Quindío
 * @version 1.0
 * @since 2016-04-16.
 */
public class DirectorioFragment extends Fragment implements View.OnClickListener {

    /**
     * List view
     */
    private ListView lv;

    /**
     * Adaptador para el list view
     */
    ArrayAdapter<String> adaptador;

    /**
     * boton floating
     */
    private FloatingActionButton btnfloat;

    /**
     * Edittext donde ingresaremos nuestra búsqueda
     */
    EditText Busqueda;

    /**
     * ArrayList para el Listview
     */
    ArrayList<HashMap<String, String>> MenuDeComidas;

    /**
     * para inicializar el fragment
     */
    public static DirectorioFragment instancia = new DirectorioFragment();

    /**
     * Constructor de la clase DirectorioFragment.
     */
    public DirectorioFragment() {
    }

    /**
     * El fragment a sido creado
     * @param savedInstanceState
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    /**
     * Inicializo listView, adaptador.
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_directorio, container,
                false);
        // Datos para el ListView
        String dependencias[] = {" Bienestar 7777", " Enfermeria 6687", "ingenieria de sistemas 2222", "ingenieria electronica 3333",
                " Medicina 5556", "porteria 9999", "Rectoria 4444",
        };

        lv = (ListView) rootView.findViewById(R.id.list_view);
        Busqueda = (EditText) rootView.findViewById(R.id.edttxt_buscar);


        btnfloat=(FloatingActionButton) rootView.findViewById(R.id.btn_flotante);
        btnfloat.setOnClickListener(this);

        Busqueda.addTextChangedListener(new TextWatcher(){

            @Override
            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {
                // TODO Auto-generated method stub
                adaptador.getFilter().filter(s);
            }

            @Override
            public void afterTextChanged(Editable s) {


            }

        });

        // Agregar los items
        adaptador = new ArrayAdapter<String>(getActivity(), R.layout.list_item, R.id.depend,dependencias);
        lv.setAdapter(adaptador);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (parent.getItemAtPosition(position) != null) {
                    Toast.makeText(getContext(), parent.getItemAtPosition(position).toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });

        return rootView;
    }

    /**
     * Método que permite mostrar un mensaje a través de la clase Toast.
     * @param context
     * @param message
     */
    public static void  mostrarMensaje(Context context,String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

    /**
     * Método que captura los eventos del fragmento.
     * @param v
     */
    @Override
    public void onClick(View v) {
        if(v.getId()==btnfloat.getId())
            mostrarMensaje(getContext(),"Actualizar Directorio");
    }

}
