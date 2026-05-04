
package com.biblioteca.servicio;

import com.biblioteca.modelo.Usuario;

public class UsuarioService {
    
    public void prestarlibros(Usuario usuario){
        if(usuario.getLibrosPrestados() <4) {
            usuario.prestarLibro();
            System.out.println("Libro prestado correctamente");
        } else {
            System.out.println("Tiene mas de 3 libros no se puede prestar");
        }
    }
}