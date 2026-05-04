class Animal:
    def sonido(self):
        print("El animal hace un sonido")
        
class Lobo(Animal):
    def sonido(self):
        print("El lobo aulla")
        
class Vaca(Animal):
    def sonido(self):
        print("La vaca hace Muu")
        
class Pato(Animal):
    def sonido(self):
        print("El pato graznea")
        
a = Animal()
a.sonido()
b = Pato()
b.sonido()
c = Lobo()
c.sonido()
d = Vaca()
d.sonido()
