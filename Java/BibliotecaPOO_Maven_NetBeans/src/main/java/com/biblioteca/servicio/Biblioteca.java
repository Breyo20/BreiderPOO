package com.biblioteca.servicio;

import java.util.ArrayList;
import com.biblioteca.modelo.Libro;

public class Biblioteca {

    private ArrayList<Libro> libros;

    public Biblioteca() {
        libros = new ArrayList<>();
    }

    public void agregarLibro(Libro libro) {
        libros.add(libro);
    }

    public void mostrarLibros() {
        for (Libro libro : libros) {
            libro.mostrarLibro();
            System.out.println("---------------");
        }
    }
}
