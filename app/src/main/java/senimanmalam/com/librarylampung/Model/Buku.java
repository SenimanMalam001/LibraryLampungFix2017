package senimanmalam.com.librarylampung.Model;

import android.widget.ImageView;

/**
 * Created by asus on 26/12/2017.
 */

public class Buku {

    private String judul, gambar;

    public Buku(){

    }

    public Buku(String judul, String image){
        judul = judul;
        gambar = image;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getGambar() {
        return gambar;
    }

    public void setGambar(String gambar) {
        this.gambar = gambar;
    }
}