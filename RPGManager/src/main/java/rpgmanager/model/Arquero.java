package rpgmanager.model;

import rpgmanager.interfaces.Equipable;

public class Arquero extends Personaje implements Equipable {

    private int flechas;
    private int alcance;

    private String itemEquipado = "Arco basico";

    // Constructor
    public Arquero(String nombre, int nivel) {
        super(nombre, nivel, 70 + nivel * 8);
        this.flechas = 10 + nivel * 2;
        this.alcance = 30;
    }

    @Override
    public void atacar(Personaje objetivo) {
        if (flechas > 0) {
            int dano = 12 + nivel * 4;

            // 🎯 bono por equipo
            if (!itemEquipado.equals("Arco basico")) {
                dano += 5;
            }

            System.out.println(nombre + " dispara una flecha a " + objetivo.nombre +
                               " causando " + dano + " de daño");
            objetivo.recibirDano(dano);
            flechas--;
        } else {
            System.out.println(nombre + " no puede atacar: no le quedan flechas");
        }
    }

    @Override
    public String getTipoPersonaje() {
        return "Arquero";
    }

    public void recargarFlechas(int cantidad) {
        flechas += cantidad;
        System.out.println(nombre + " recarga flechas. Flechas actuales: " + flechas);
    }

    // 🏹 EQUIPABLE
    @Override
    public void equiparItem(String item) {
        this.itemEquipado = item;
        System.out.println(nombre + " ha equipado: " + item);
    }

    @Override
    public String getItemEquipado() {
        return itemEquipado;
    }
}