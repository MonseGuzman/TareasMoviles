package com.monse.andrea.practica5;

import android.widget.ImageButton;

public class ClaseMemoria
{
    private ImageButton boton;
    private int par;

    public ClaseMemoria() {
    }

    public ClaseMemoria(ImageButton boton, int par)
    {
        this.boton = boton;
        this.par = par;
    }

    public ImageButton getBoton() {
        return boton;
    }

    public void setBoton(ImageButton boton) {
        this.boton = boton;
    }

    public int getPar() {
        return par;
    }

    public void setPar(int par) {
        this.par = par;
    }
}
