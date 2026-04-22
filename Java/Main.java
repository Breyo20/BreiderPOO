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
        System.out.println(nombre + " recibió " + d + " de daño. Vida: " + puntosVida);
    }

    public abstract void atacar(Personaje obj);
}

interface Curable {
    void curar(Personaje obj);
}

interface Invencible {
    void activarInvencibilidad();
    boolean esInvencible();
}

class Mario extends Personaje implements Invencible {
    private boolean invencible;

    public Mario() {
        super("Mario", 3, 100);
        invencible = false;
    }

    public void atacar(Personaje obj) {
        System.out.println("Mario ataca ");
        obj.recibirDano(20);
    }

    public void activarInvencibilidad() {
        invencible = true;
        System.out.println("Mario es invencible ");
    }

    public boolean esInvencible() {
        return invencible;
    }
}

class Luigi extends Personaje implements Curable {
    public Luigi() {
        super("Luigi", 3, 90);
    }

    public void atacar(Personaje obj) {
        System.out.println("Luigi ataca ⬆");
        obj.recibirDano(15);
    }

    public void curar(Personaje obj) {
        obj.puntosVida += 20;
        System.out.println("Luigi cura  " + obj.nombre);
    }
}

class Toad extends Personaje implements Curable {
    public Toad() {
        super("Toad", 2, 80);
    }

    public void atacar(Personaje obj) {
        System.out.println("Toad ataca ");
        obj.recibirDano(10);
    }

    public void curar(Personaje obj) {
        obj.puntosVida += 15;
        System.out.println("Toad cura  " + obj.nombre);
    }
}

// Se creo el main para que se pudiera ejecutar todo 
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
            public void atacar(Personaje obj) {
                System.out.println("Orco golpea ");
                obj.recibirDano(12);
            }
        };

        System.out.println(" ATAQUE ");
        for (Personaje p : equipo) {
            p.atacar(enemigo);
        }

        System.out.println("\n HABILIDADES ");
        for (Personaje p : equipo) {

            if (p instanceof Curable) {
                ((Curable) p).curar(mario);
            }

            if (p instanceof Invencible) {
                ((Invencible) p).activarInvencibilidad();
            }
        }
    }
}
