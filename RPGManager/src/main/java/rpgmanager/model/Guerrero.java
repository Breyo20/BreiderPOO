package rpgmanager.model;

import rpgmanager.interfaces.Habilidoso;
import rpgmanager.interfaces.Equipable;

public class Guerrero extends Personaje implements Habilidoso, Equipable {

    private int fuerza;
    private int defensa;

    private String itemEquipado = "Sin equipo";
    private int costoHabilidad = 30;

    // Constructor
    public Guerrero(String nombre, int nivel, int puntosVidaMax, int fuerza, int defensa) {
        super(nombre, nivel, puntosVidaMax);
        this.fuerza = fuerza;
        this.defensa = defensa;
    }

    @Override
    public void atacar(Personaje objetivo) {
        System.out.println(nombre + " ataca a " + objetivo.nombre + " con fuerza " + fuerza);
        objetivo.recibirDano(fuerza);
    }

    @Override
    public String getTipoPersonaje() {
        return "Guerrero";
    }

    public void usarEscudo() {
        System.out.println(nombre + " bloquea con defensa " + defensa);
    }

    // 🔥 HABILIDOSO
    @Override
    public void usarHabilidadEspecial(Personaje obj) {
        System.out.println(nombre + " usa Golpe Devastador sobre " + obj.nombre + " (50 daño)");
        obj.recibirDano(50);
    }

    @Override
    public int getCostoHabilidad() {
        return costoHabilidad;
    }

    @Override
    public String getNombreHabilidad() {
        return "Golpe Devastador";
    }

    // 🛡️ EQUIPABLE
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