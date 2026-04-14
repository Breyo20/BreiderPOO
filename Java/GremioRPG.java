package rpgmanager;

import java.util.ArrayList;
import java.util.Iterator;

public class GremioRPG {

    private Personaje[] equipoPrincipal;    // vector fijo
    private Personaje[][] dungeon;          // matriz 3x3
    private ArrayList<Personaje> espera;    // lista dinámica
    private String nombreGremio;

    // Constructor
    public GremioRPG(String nombre) {
        this.nombreGremio = nombre;
        this.equipoPrincipal = new Personaje[6];
        this.dungeon = new Personaje[3][3];
        this.espera  = new ArrayList<>();
    }

    // Agrega al equipo principal (primer espacio libre)
    public boolean unirseAlEquipo(Personaje p) {
        for (int i = 0; i < equipoPrincipal.length; i++) {
            if (equipoPrincipal[i] == null) {
                equipoPrincipal[i] = p;
                System.out.println(p.getNombre() + " se unió al equipo.");
                return true;
            }
        }

        // Si está lleno, va a lista de espera
        espera.add(p);
        System.out.println(p.getNombre() + " en lista de espera.");
        return false;
    }

    // Coloca un personaje en el dungeon
    public void colocarEnDungeon(Personaje p, int fila, int col) {
        if (fila >= 0 && fila < 3 && col >= 0 && col < 3) {
            if (dungeon[fila][col] == null) {
                dungeon[fila][col] = p;
            } else {
                System.out.println("Celda [" + fila + "][" + col + "] ocupada.");
            }
        } else {
            System.out.println("Posición fuera de rango.");
        }
    }

    // Elimina personajes con HP = 0
    public void limpiarCaidos() {

        // 1. Limpiar vector
        for (int i = 0; i < equipoPrincipal.length; i++) {
            if (equipoPrincipal[i] != null && equipoPrincipal[i].getHp() == 0) {
                System.out.println(equipoPrincipal[i].getNombre() + " ha caído.");
                equipoPrincipal[i] = null;
            }
        }

        // 2. Limpiar lista de espera (con Iterator)
        Iterator<Personaje> it = espera.iterator();
        while (it.hasNext()) {
            Personaje p = it.next();
            if (p.getHp() == 0) {
                it.remove(); // eliminación segura
            }
        }
    }

    // Mostrar estadísticas
    public void reporteGremio() {
        int activos = 0;
        int hpTotal = 0;

        for (Personaje p : equipoPrincipal) {
            if (p != null) {
                activos++;
                hpTotal += p.getHp();
            }
        }

        System.out.println("\n=== GREMIO: " + nombreGremio + " ===");
        System.out.println("Equipo activo: " + activos + "/6");
        System.out.println("HP total equipo: " + hpTotal);
        System.out.println("En espera: " + espera.size());
    }
}

public double promedioNivel() {
    int suma = 0;
    int contador = 0;

    for (Personaje p : equipoPrincipal) {
        if (p != null) {
            suma += p.getNivel();
            contador++;
        }
    }

    if (contador == 0) return 0;

    return (double) suma / contador;
}

package rpgmanager;

public class Principal {
    public static void main(String[] args) {

        // 1. Crear gremio
        GremioRPG g = new GremioRPG("Heroes de la Luz");

        // 2. Crear 8 personajes
        Personaje p1 = new Personaje("Arthas", 10, 120);
        Personaje p2 = new Personaje("Jaina", 9, 100);
        Personaje p3 = new Personaje("Thrall", 8, 110);
        Personaje p4 = new Personaje("Illidan", 10, 130);
        Personaje p5 = new Personaje("Sylvanas", 9, 95);
        Personaje p6 = new Personaje("Uther", 7, 105);
        Personaje p7 = new Personaje("Guldan", 6, 80);
        Personaje p8 = new Personaje("Velen", 5, 90);

        // 3. Agregar al equipo (6 entran, 2 van a espera)
        g.unirseAlEquipo(p1);
        g.unirseAlEquipo(p2);
        g.unirseAlEquipo(p3);
        g.unirseAlEquipo(p4);
        g.unirseAlEquipo(p5);
        g.unirseAlEquipo(p6);
        g.unirseAlEquipo(p7);
        g.unirseAlEquipo(p8);

        // 4. Colocar 4 personajes en el dungeon
        g.colocarEnDungeon(p1, 0, 0);
        g.colocarEnDungeon(p2, 1, 1);
        g.colocarEnDungeon(p3, 2, 2);
        g.colocarEnDungeon(p4, 0, 2);

        // 5. Simular batalla (dos mueren)
        p1.setHp(0);
        p2.setHp(0);

        // 6. Limpiar caídos
        g.limpiarCaidos();

        // 7. Reporte final
        g.reporteGremio();
    }
}
