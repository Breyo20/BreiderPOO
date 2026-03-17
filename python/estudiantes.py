class Estudiante:
    #constructor - se ejecuta al crear un onjeto
    def __init__(self, nombre, edad, carrera):
        self.nombre = nombre
        self.edad = edad
        self.carrera = carrera
        self.materias = []
    
    #Metodo para agregar materias {}
    def inscribir_materias(self, materia):
        self.materias.append(materia)
        print(f"{self.nombre} se inscribio en {materia}")

    #Metodo para mostrar informacion
    def presentarse(self):
        print(f"Hola, soy {self.nombre}")
        print(f"Tengo {self.edad} años")
        print(f"Estudio {self.carrera}")
        print(f"Materias inscritas: {len(self.materias)}")

#Crear objetos (instancia de la clase)
estudiante1 = Estudiante("Breider Hoyos", 19, "Tecn. en Sistematizacion de Datos")

#Usar los metodos 
estudiante1.presentarse()

print("---")

estudiante1.inscribir_materias("POO")
estudiante1.inscribir_materias("Estructura de Datos")
estudiante1.inscribir_materias("Calculo Integral")

print("---")

