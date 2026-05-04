package com.mycompany.rpgmanager;

import java.util.ArrayList;
import rpgmanager.model.*;
import rpgmanager.interfaces.*;

public class BatallaCompleta {

    public static void main(String[] args) {

        // Crear héroes
        Guerrero thorin = new Guerrero("Thorin", 3, 100, 20, 10);
        Mago gandalf = new Mago("Gandalf", 5);
        Arquero legolas = new Arquero("Legolas", 4);

        ArrayList<Personaje> heroes = new ArrayList<>();
        heroes.add(thorin);
        heroes.add(gandalf);
        heroes.add(legolas);

        // Crear enemigo
        Personaje orco = new Guerrero("Orco", 1, 80, 15, 5);

        // 🔵 FASE 1 — Equipar
        thorin.equiparItem("Espada Legendaria");
        legolas.equiparItem("Arco Elfico");

        int turno = 1;

        // 🔴 FASE 2 — Batalla
        while (orco.estaVivo()) {

            System.out.println("\n--- Turno " + turno + " ---");

            for (Personaje h : heroes) {

                if (!orco.estaVivo()) break;

                // 🔥 turno 2: usar habilidades antes de atacar
                if (turno == 2 && h instanceof Habilidoso) {
                    Habilidoso hab = (Habilidoso) h;
                    hab.usarHabilidadEspecial(orco);
                }

                if (orco.estaVivo()) {
                    h.atacar(orco);
                }
            }

            turno++;
        }

        System.out.println("\n🏁 Batalla terminada en " + (turno - 1) + " turnos\n");

        // 🟢 FASE 3 — Sanación
        for (Personaje h : heroes) {

            if (h instanceof Sanador) {

                // buscar héroe con menos vida
                Personaje objetivo = heroes.get(0);

                for (Personaje p : heroes) {
                    if (p.puntosVida < objetivo.puntosVida) {
                        objetivo = p;
                    }
                }

                ((Sanador) h).sanar(objetivo);
            }
        }

        // Estado final
        System.out.println("\nEstado final:");
        for (Personaje h : heroes) {
            System.out.println(h);
        }
        System.out.println(orco);
    }
}