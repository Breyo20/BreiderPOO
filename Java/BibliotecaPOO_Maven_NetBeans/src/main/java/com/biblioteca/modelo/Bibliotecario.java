package com.biblioteca.modelo;

public class Bibliotecario extends Persona {

    private double salario;

    public Bibliotecario(String nombre, String identificacion, double salario) {
        super(nombre, identificacion);
        this.salario = salario;
    }

    public double getSalario() {
        return salario;
    }

    @Override
    public void mostrarInformacion() {
        super.mostrarInformacion();
        System.out.println("Salario: $" + salario);
    }
}
