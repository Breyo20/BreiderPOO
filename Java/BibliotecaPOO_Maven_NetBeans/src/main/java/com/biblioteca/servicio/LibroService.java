package com.biblioteca.servicio;

import com.biblioteca.modelo.Libro;

public class LibroService {

    public void prestarLibro(Libro libro) {
        if (libro.isDisponible()) {
            libro.setDisponible(false);
            System.out.println("Libro prestado correctamente");
        } else {
            System.out.println("El libro no está disponible");
        }
    }

    public void devolverLibro(Libro libro) {
        libro.setDisponible(true);
        System.out.println("Libro devuelto correctamente");
    }
}