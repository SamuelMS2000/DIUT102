package com.mycompany.exccliagua;

/**
 *
 * @author SamuelMS
 */

public class controlador {

    private modelo modelo;
    private vista vista;

    public controlador() {
        modelo = new modelo();
        vista = new vista(this);
    }

    public static void main(String[] args) {
        args = new String[]{"-a", "20"};
       //  args = new String[]{"-h"};
        controlador control = new controlador();
        control.inciarVista(args);
    }

    private void inciarVista(String[] args) {
        vista.convertir(args);
    }

    void masGrados(int temp) {
        int subirT = modelo.subirGrados(temp);
        vista.showT(subirT);
    }

    void menosGrados(int temp) {
        int bajarT = modelo.bajarGrados(temp);
        vista.showT(bajarT);
    }

    void grados() {
        int gradosCelsius = modelo.getGrados();
        vista.showT(gradosCelsius);
    }
}