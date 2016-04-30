package com.uniquindio.electiva_android.campusuq.vo;

/**
 * Created by Marisol on 29/04/2016.
 */
public class noticia {
    private String titulo;
    private String detalle;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public noticia(String titulo) {
        this.titulo = titulo;
    }
}