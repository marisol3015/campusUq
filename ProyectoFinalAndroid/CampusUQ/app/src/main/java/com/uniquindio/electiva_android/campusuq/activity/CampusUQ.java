package com.uniquindio.electiva_android.campusuq.activity;

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

public class CampusUQ extends AppCompatActivity {

    /**
     * Instancia del drawer
     */
    private DrawerLayout drawerLayout;

    /**
     * Titulo inicial del drawer
     */
    private String drawerTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

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



    @Override
       public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

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

    private void selectItem(String title) {

        if(title.equals("Inicio")) {
            // Enviar título como arguemento del fragmento
            Bundle args = new Bundle();
            args.putString(VistaInicio.NOMBRE_ACTION_BAR, title);

            Fragment fragment = (Fragment) VistaInicio.instancia;

            FragmentManager fragmentManager = getSupportFragmentManager();

            fragmentManager.beginTransaction().replace(R.id.content_campus_uq, fragment).commit();

            //Cierra el menu desplegable
            drawerLayout.closeDrawers(); // Cerrar drawer

            setTitle(title); // Setear título actual
        }
        if(title.equals("Sugerencias")) {
            Utilidades.mostrarDialogoSugerencia(getFragmentManager(), CampusUQ.class.getSimpleName());
            drawerLayout.closeDrawers();
        }

        // fragment directorio
        if(title.equals("Directorio"))
        {
            Fragment fragment = (Fragment) DirectorioFragment.instancia;

            FragmentManager fragmentManager = getSupportFragmentManager();

            fragmentManager.beginTransaction().replace(R.id.content_campus_uq, fragment).commit();
            drawerLayout.closeDrawers();
        }
    }

}
