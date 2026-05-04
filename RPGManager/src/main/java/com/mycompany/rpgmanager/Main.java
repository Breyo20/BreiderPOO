package com.mycompany.rpgmanager;

import rpgmanager.model.*;

public class Main {
    public static void main(String[] args) {

        Guerrero thorin = new Guerrero("Thorin", 3, 100, 20, 10);
        Mago gandalf = new Mago("Gandalf", 5);
        Arquero legolas = new Arquero("Legolas", 4);

        System.out.println(thorin);
        System.out.println(gandalf);
        System.out.println(legolas);
    }
}