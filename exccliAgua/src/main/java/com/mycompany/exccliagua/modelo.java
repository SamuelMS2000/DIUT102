package com.mycompany.exccliagua;

/**
 *
 * @author SamuelMS
 */
public class modelo {

    private final static int temperatura = (int) (Math.random() * 100);

    public int subirGrados(int grados) {
        return temperatura + grados;
    }

    public int bajarGrados(int grados) {
        return temperatura - grados;
    }

    public int getGrados() {
        return temperatura;
    }
}
