package com.biblioteca.modelo;

public class Interfaz {
    
    private boolean prestar;
    private boolean devolver;
    
    public Interfaz() {
        this.prestar = false;
        this.devolver = true;
    }
    
    public interface Prestable { 
        void prestar(); 
        void devolver(); 
    }
    
}
