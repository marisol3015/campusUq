package fragmets;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.uniquindio.electiva_android.noticias.R;

import java.util.ArrayList;

import util.AdaptadorDeNoticia;
import vo.noticia;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListaDeNoticiasFragment extends Fragment implements AdaptadorDeNoticia.OnClickAdaptadorDeNoticia {

    /**
     * Atributo de clase que representa el componente visual de la lista de noticia.
     */
    private RecyclerView listadoDeNoticia;

    /**
     * Atributo de clase que representa el adaptador de la lista de noticias.
     */
    private AdaptadorDeNoticia adaptador;

    /**
     * Atributo de la clase que representa la lista de noticias.
     */
    private ArrayList<noticia> noticia;

    /**
     * Atributo que representa el listener de la la clase contenedora.
     */
    private OnNoticiaSeleccionadaListener listener;

    /**
     * Contructor de la clase ListaDePeliculasFragment
     */
    public ListaDeNoticiasFragment() {
        // Required empty public constructor
    }

    /**
     * Es llamado cuando el fragmento es asociado con la actividad.
     *
     * @param context Contexto de la actividad
     */
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        Activity activity;

        if (context instanceof Activity) {

            activity = (Activity) context;

            try {
                //Con esto se busca que la actividad contenedora implemente la interfaz OnNoticiaSeleccionadaListener
                listener = (OnNoticiaSeleccionadaListener) activity;
            } catch (ClassCastException e) {
                throw new ClassCastException(e.toString() + " debe implementar " +
                        "la interfaz OnPeliculaSeleccionadaListener");
            }
        }
    }

    /**
     * El sistema llama a este callback cuando se crea el fragmento
     *
     * @param savedInstanceState
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Permite que el fragmento interactue con el menu

    }

    /**
     * Este metodo se ejecuta cuando el fragment ya va a ser visible o dibujado
     *
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_lista_de_noticias, container, false);
    }

    /**
     * Metood que se ejecuta cuando se ha completado el onCreate en la actividad padre
     *
     * @param savedInstanceState
     */
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        listadoDeNoticia = (RecyclerView) getView().findViewById(R.id.recView);

        adaptador = new AdaptadorDeNoticia(noticia, this);

        listadoDeNoticia.setAdapter(adaptador);

        //Forma en la que se representara cada elemento (cardview) en la lista
        //El false es para saber desde donde va la lista arriba-abajo
        listadoDeNoticia.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
    }

    /**
     * Metodo que permite comunicar las actividades y los fragmentos
     *
     * @param pos Posicion en la que se oprimio y se encuentra el adaptador
     */
    @Override
    public void onClickPosicion(int pos) {
        listener.onNoticiaSeleccionadaListener(pos);
    }

    public void setNoticia(ArrayList<vo.noticia> noticia) {
        this.noticia = noticia;
    }


    /**
     * Interface utilizada para comunicar las actividades y los fragmentos
     */
    public interface OnNoticiaSeleccionadaListener {
        void onNoticiaSeleccionadaListener(int position);
    }

    /**
     * Metodo que permite asignarle una lista de noticia a la clase ListaDeNoticiaFragment
     *
     * @param noticia Lista de Peliculas a ser asignado
     */
    public void setPeliculas(ArrayList<noticia> noticia) {
        this.noticia = noticia;
    }
}