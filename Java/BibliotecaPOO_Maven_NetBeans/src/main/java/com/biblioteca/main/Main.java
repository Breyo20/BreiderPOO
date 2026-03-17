package com.biblioteca.main;

import com.biblioteca.modelo.*;
import com.biblioteca.servicio.Biblioteca;

public class Main {

    public static void main(String[] args) {

        Biblioteca biblioteca = new Biblioteca();

        Libro libro1 = new Libro("Cien Años de Soledad", "Gabriel García Márquez");
        Libro libro2 = new Libro("El Principito", "Antoine de Saint-Exupéry");

        biblioteca.agregarLibro(libro1);
        biblioteca.agregarLibro(libro2);

        Usuario usuario = new Usuario("Carlos Pérez", "123");
        Bibliotecario admin = new Bibliotecario("Ana Torres", "999", 2500000);

        usuario.prestarLibro();

        biblioteca.mostrarLibros();

        System.out.println("===== Usuario =====");
        usuario.mostrarInformacion();

        System.out.println("===== Bibliotecario =====");
        admin.mostrarInformacion();
    }
}
