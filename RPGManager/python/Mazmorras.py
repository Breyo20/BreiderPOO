class Personaje:
    def __init__(self, nombre, nivel, hp):
        self.nombre = nombre
        self.nivel = nivel
        self.hp = hp
        self.estado = 'activo'

    def __str__(self):
        return f'[Nv.{self.nivel}] {self.nombre} | HP:{self.hp} | Estado:{self.estado}'


class GremioRPG:
    def __init__(self, nombre):
        self.nombre_gremio = nombre
        self.equipo_principal = [None] * 6
        self.dungeon = [[None]*3 for _ in range(3)]
        self.espera = []

    def unirse_al_equipo(self, p):
        for i in range(len(self.equipo_principal)):
            if self.equipo_principal[i] is None:
                self.equipo_principal[i] = p
                print(f'{p.nombre} se unió al equipo.')
                return True
        self.espera.append(p)
        print(f'{p.nombre} en lista de espera.')
        return False

    def colocar_en_dungeon(self, p, fila, col):
        if 0 <= fila < 3 and 0 <= col < 3:
            if self.dungeon[fila][col] is None:
                self.dungeon[fila][col] = p
            else:
                print(f'Celda [{fila}][{col}] ocupada.')
        else:
            print('Posición fuera de rango.')

    def limpiar_caidos(self):
        # Limpiar vector
        for i in range(len(self.equipo_principal)):
            p = self.equipo_principal[i]
            if p is not None and p.hp == 0:
                print(f'{p.nombre} ha caído.')
                self.equipo_principal[i] = None

        # Limpiar lista de espera
        self.espera = [p for p in self.espera if p.hp > 0]

    def reporte_gremio(self):
        activos = sum(1 for p in self.equipo_principal if p is not None)
        hp_total = sum(p.hp for p in self.equipo_principal if p is not None)
        print(f'\n=== GREMIO: {self.nombre_gremio} ===')
        print(f'Equipo activo: {activos}/6')
        print(f'HP total equipo: {hp_total}')
        print(f'En espera: {len(self.espera)}')
      
    def promedio_nivel(self):
    niveles = [p.nivel for p in self.equipo_principal if p is not None]
    if len(niveles) == 0:
        return 0
    return sum(niveles) / len(niveles)


g = GremioRPG('Heroes de la Luz')

p1 = Personaje('Arthas', 10, 120)
p2 = Personaje('Jaina', 9, 100)
p3 = Personaje('Thrall', 8, 110)
p4 = Personaje('Illidan', 10, 130)
p5 = Personaje('Sylvanas', 9, 95)
p6 = Personaje('Uther', 7, 105)
p7 = Personaje('Guldan', 6, 80)
p8 = Personaje('Velen', 5, 90)

# Agregar al equipo
g.unirse_al_equipo(p1)
g.unirse_al_equipo(p2)
g.unirse_al_equipo(p3)
g.unirse_al_equipo(p4)
g.unirse_al_equipo(p5)
g.unirse_al_equipo(p6)
g.unirse_al_equipo(p7)
g.unirse_al_equipo(p8)

# Colocar en dungeon
g.colocar_en_dungeon(p1, 0, 0)
g.colocar_en_dungeon(p2, 1, 1)
g.colocar_en_dungeon(p3, 2, 2)
g.colocar_en_dungeon(p4, 0, 2)

# Simular batalla
p1.hp = 0
p2.hp = 0

# Limpiar y mostrar reporte
g.limpiar_caidos()
g.reporte_gremio()
