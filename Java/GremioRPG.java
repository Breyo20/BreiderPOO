import java.util.ArrayList;

abstract class Personaje {
    protected String nombre;
    protected int nivel;
    protected int puntosVida;

    public Personaje(String nombre, int nivel, int puntosVida) {
        this.nombre = nombre;
        this.nivel = nivel;
        this.puntosVida = puntosVida;
    }

    public void recibirDano(int d) {
        puntosVida = Math.max(0, puntosVida - d);
    }

    public abstract int atacar(); // ahora retorna daño
}

// Interfaces
interface Curable {
    void curar(Personaje obj);
}

interface Invencible {
    void activarInvencibilidad();
    boolean esInvencible();
}

// Clases concretas
class Mario extends Personaje implements Invencible {
    private boolean invencible;

    public Mario() {
        super("Mario", 3, 100);
        invencible = false;
    }

    public int atacar() {
        return 20;
    }

    public void activarInvencibilidad() {
        invencible = true;
    }

    public boolean esInvencible() {
        return invencible;
    }
}

class Luigi extends Personaje implements Curable {

    public Luigi() {
        super("Luigi", 3, 90);
    }

    public int atacar() {
        return 15;
    }

    public void curar(Personaje obj) {
        obj.puntosVida += 20;
    }
}

class Toad extends Personaje implements Curable {

    public Toad() {
        super("Toad", 2, 80);
    }

    public int atacar() {
        return 10;
    }

    public void curar(Personaje obj) {
        obj.puntosVida += 15;
    }
}

// Nueva clase de presentación (SRP)
class PersonajeView {

    public static void mostrarAtaque(Personaje atacante, Personaje objetivo, int dano) {
        System.out.println(atacante.nombre + " ataca a " + objetivo.nombre);
        System.out.println(objetivo.nombre + " recibe " + dano + " de daño. Vida: " + objetivo.puntosVida);
    }

    public static void mostrarCuracion(Personaje curador, Personaje objetivo) {
        System.out.println(curador.nombre + " cura a " + objetivo.nombre + ". Vida: " + objetivo.puntosVida);
    }

    public static void mostrarInvencible(Personaje p) {
        System.out.println(p.nombre + " es invencible!");
    }
}

// Main
public class Main {
    public static void main(String[] args) {

        ArrayList<Personaje> equipo = new ArrayList<>();

        Mario mario = new Mario();
        Luigi luigi = new Luigi();
        Toad toad = new Toad();

        equipo.add(mario);
        equipo.add(luigi);
        equipo.add(toad);

        Personaje enemigo = new Personaje("Orco", 1, 100) {
            public int atacar() {
                return 12;
            }
        };

        System.out.println("ATAQUE");
        for (Personaje p : equipo) {
            int dano = p.atacar();
            enemigo.recibirDano(dano);
            PersonajeView.mostrarAtaque(p, enemigo, dano);
        }

        System.out.println("\nHABILIDADES");
        for (Personaje p : equipo) {

            if (p instanceof Curable) {
                ((Curable) p).curar(mario);
                PersonajeView.mostrarCuracion(p, mario);
            }

            if (p instanceof Invencible) {
                ((Invencible) p).activarInvencibilidad();
                PersonajeView.mostrarInvencible(p);
            }
        }
    }
}
