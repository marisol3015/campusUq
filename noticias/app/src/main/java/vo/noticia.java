package vo;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Marisol on 29/04/2016.
 */
public class noticia implements Parcelable{
    private int idImagen;
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

    public int getIdImagen() {
        return idImagen;
    }

    public void setIdImagen(int idImagen) {
        this.idImagen = idImagen;
    }

    public noticia(int idImagen,String titulo, String detalle) {
        this.idImagen=idImagen;
        this.titulo = titulo;
        this.detalle = detalle;
    }
    public noticia(int idImagen,String titulo) {
        this.idImagen=idImagen;
        this.titulo = titulo;

    }
    /**
     * Constructor de la clase pelicula.
     *
     * @param in
     */

    protected noticia(Parcel in) {
        idImagen=in.readInt();
        titulo = in.readString();
       detalle = in.readString();

    }
    /**
     * Es el encargado de crear la noticia con base al Parcel
     */
    public static final Creator<noticia> CREATOR = new Creator<noticia>() {
        @Override
        public noticia createFromParcel(Parcel in) {
            return new noticia(in);
        }

        @Override
        public noticia[] newArray(int size) {
            return new noticia[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(idImagen);
        dest.writeString(titulo);
        dest.writeString(detalle);
    }
}