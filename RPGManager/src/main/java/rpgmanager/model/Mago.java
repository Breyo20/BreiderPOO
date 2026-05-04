package rpgmanager.model;

import rpgmanager.interfaces.Habilidoso;
import rpgmanager.interfaces.Sanador;

public class Mago extends Personaje implements Habilidoso, Sanador {

    private int mana;
    private int manaMax;

    // Constructor
    public Mago(String nombre, int nivel) {
        super(nombre, nivel, 80 + nivel * 10);
        this.manaMax = 80 + nivel * 10;
        this.mana = manaMax;
    }

    @Override
    public void atacar(Personaje objetivo) {
        if (mana >= 20) {
            int dano = 25 + nivel * 5;
            System.out.println(nombre + " lanza un hechizo a " + objetivo.nombre + " causando " + dano + " de daño");
            objetivo.recibirDano(dano);
            mana -= 20;
        } else {
            System.out.println(nombre + " no puede atacar: mana insuficiente");
        }
    }

    @Override
    public String getTipoPersonaje() {
        return "Mago";
    }

    public void recuperarMana(int cantidad) {
        mana += cantidad;
        if (mana > manaMax) {
            mana = manaMax;
        }
        System.out.println(nombre + " recupera mana. Mana actual: " + mana + "/" + manaMax);
    }

    // 🔥 HABILIDOSO
    @Override
    public void usarHabilidadEspecial(Personaje obj) {
        if (mana >= 20) {
            System.out.println(nombre + " lanza Bola de Fuego a " + obj.nombre + " (40 daño)");
            obj.recibirDano(40);
            mana -= 20;
        } else {
            System.out.println(nombre + " no puede usar Bola de Fuego: mana insuficiente");
        }
    }

    @Override
    public int getCostoHabilidad() {
        return 20;
    }

    @Override
    public String getNombreHabilidad() {
        return "Bola de Fuego";
    }

    // ✨ SANADOR
    @Override
    public void sanar(Personaje obj) {
        int nuevaVida = obj.puntosVida + 25;
        if (nuevaVida > obj.puntosVidaMax) {
            nuevaVida = obj.puntosVidaMax;
        }
        obj.puntosVida = nuevaVida;

        System.out.println(nombre + " sana a " + obj.nombre + " (+25 HP)");
    }

    @Override
    public int getPotenciaSanacion() {
        return 25;
    }
}