package com.mycompany.rpgmanager;

import java.util.ArrayList;
import rpgmanager.model.*;

public class Batalla {

    public static void main(String[] args) {

        // Crear héroes
        ArrayList<Personaje> heroes = new ArrayList<>();
        heroes.add(new Guerrero("Thorin", 3, 100, 20, 10));
        heroes.add(new Mago("Gandalf", 5));
        heroes.add(new Arquero("Legolas", 4));

        // Crear enemigo
        Personaje orco = new Guerrero("Orco", 1, 80, 15, 5);

        int turno = 1;

        // Bucle de batalla
        while (orco.estaVivo()) {
            System.out.println("\n--- Turno " + turno + " ---");

            for (Personaje h : heroes) {
                if (orco.estaVivo()) {
                    h.atacar(orco);
                } else {
                    break;
                }
            }

            turno++;
        }

        // Resultado final
        System.out.println("\n🏁 Batalla terminada en " + (turno - 1) + " turnos\n");

        System.out.println("Estado final:");
        for (Personaje h : heroes) {
            System.out.println(h);
        }
        System.out.println(orco);
    }
}