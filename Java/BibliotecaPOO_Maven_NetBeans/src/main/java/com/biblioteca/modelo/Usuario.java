package com.biblioteca.modelo;

public class Usuario extends Persona {

    private int librosPrestados;

    public Usuario(String nombre, String identificacion) {
        super(nombre, identificacion);
        this.librosPrestados = 0;
    }

    public void prestarLibro() {
        librosPrestados++;
    }

    public int getLibrosPrestados() {
        return librosPrestados;
    }

    @Override
    public void mostrarInformacion() {
        super.mostrarInformacion();
        System.out.println("Libros prestados: " + librosPrestados);
    }
}
