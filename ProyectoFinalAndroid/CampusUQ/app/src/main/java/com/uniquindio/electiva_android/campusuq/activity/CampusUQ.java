package com.uniquindio.electiva_android.campusuq.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.uniquindio.electiva_android.campusuq.R;
import com.uniquindio.electiva_android.campusuq.fragments.DirectorioFragment;
import com.uniquindio.electiva_android.campusuq.fragments.VistaInicio;
import com.uniquindio.electiva_android.campusuq.util.Utilidades;

/**
 * Clase principal de la aplicación.
 * @author Jhon Jaime Ramirez
 * @author Marisol Ocampo
 * @author Carlos A. Ospina
 * @author Universidad del Quindío
 * @version 1.0
 * @since 2016-04-16.
 */
public class CampusUQ extends AppCompatActivity {

    /**
     * Instancia del drawer
     */
    private DrawerLayout drawerLayout;

    /**
     * Titulo inicial del drawer
     */
    private String drawerTitle;

    /**
     * Permite ejecutar el layout, inicializar y cargar las diferentes
     * configuraciones de la aplicacion.
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Utilidades.obtenerLenguaje(this);

        setContentView(R.layout.activity_campus_uq);
        setToolbar(); // Setear Toolbar como action bar

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        if (navigationView != null) {
            // Añadir carácteristicas
            setupDrawerContent(navigationView);
        }

        drawerTitle = getResources().getString(R.string.Inicio);
        if (savedInstanceState == null) {
            // Seleccionar item
            selectItem(drawerTitle);
        }
    }

    /**
     * Método que permite asignar una acción al menú de la aplicación.
     * @param item Item seleccionado
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * Método que permite crear el actionBar de la aplicación.
     */
    private void setToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final ActionBar ab = getSupportActionBar();
        if (ab != null) {
            // Poner ícono del drawer toggle
            ab.setHomeAsUpIndicator(R.drawable.ic_menu);
            ab.setDisplayHomeAsUpEnabled(true);
        }

    }

    /**
     * Método que permite asignar un evento a cada item del menu desplegable (Navigation View).
     * @param navigationView NavigationView al que se le asignara los eventos.
     */
    private void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {

                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        // Marcar item presionado
                        menuItem.setChecked(true);
                        // Crear nuevo fragmento
                        String title = menuItem.getTitle().toString();
                        selectItem(title);
                        return true;
                    }
                }
        );
    }

    /**
     * Metodo que permite visualizar los fragmentos o efectua las
     * acciones elegidas por el usuario.
     * @param title titulo del item seleccionado
     */
    private void selectItem(String title) {

        if(title.equals(getResources().getString(R.string.Inicio))) {
            // Enviar título como arguemento del fragmento
            Bundle args = new Bundle();
            args.putString(VistaInicio.NOMBRE_ACTION_BAR, title);

            Fragment fragment = new VistaInicio();

            FragmentManager fragmentManager = getSupportFragmentManager();

            fragmentManager.beginTransaction().replace(R.id.content_campus_uq, fragment).commit();

            //Cierra el menu desplegable
            drawerLayout.closeDrawers(); // Cerrar drawer

            setTitle(title); // Setear título actual
        }
        if(title.equals(getResources().getString(R.string.Sugerencias))) {
            Utilidades.mostrarDialogoSugerencia(getFragmentManager(), CampusUQ.class.getSimpleName());
            drawerLayout.closeDrawers();
        }

        if(title.equals(getResources().getString(R.string.Directorio)))
        {
            Fragment fragment = (Fragment) DirectorioFragment.instancia;

            FragmentManager fragmentManager = getSupportFragmentManager();

            fragmentManager.beginTransaction().replace(R.id.content_campus_uq, fragment).commit();
            drawerLayout.closeDrawers();

            setTitle(title);
        }

        if(title.equals(getResources().getString(R.string.Idioma))) {
            Utilidades.mostrarDialogoIdioma(getFragmentManager(), CampusUQ.class.getSimpleName(), this);
            drawerLayout.closeDrawers();
        }

        if(title.equals(getResources().getString(R.string.Paginaweb))) {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.uniquindio.edu.co/"));
            startActivity(intent);
            drawerLayout.closeDrawers();
        }
    }

}
