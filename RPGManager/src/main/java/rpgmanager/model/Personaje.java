package rpgmanager.model;

public abstract class Personaje {

    protected String nombre;
    protected int nivel;
    protected int puntosVida;
    protected int puntosVidaMax;

    // Constructor
    public Personaje(String nombre, int nivel, int puntosVidaMax) {
        this.nombre = nombre;
        this.nivel = nivel;
        this.puntosVidaMax = puntosVidaMax;
        this.puntosVida = puntosVidaMax;
    }

    // Método concreto
    public void recibirDano(int dano) {
        puntosVida -= dano;
        if (puntosVida < 0) {
            puntosVida = 0;
        }
        System.out.println(nombre + " recibió " + dano + " de daño. HP actual: " + puntosVida + "/" + puntosVidaMax);
    }

    // Método concreto
    public boolean estaVivo() {
        return puntosVida > 0;
    }

    // Métodos abstractos
    public abstract void atacar(Personaje objetivo);

    public abstract String getTipoPersonaje();

    // toString
    @Override
    public String toString() {
        return "[" + getTipoPersonaje() + "] " + nombre +
               " Nv." + nivel +
               " | HP: " + puntosVida + "/" + puntosVidaMax;
    }
}