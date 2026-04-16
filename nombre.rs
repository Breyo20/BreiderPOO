struct Persona {
    nombre: String,
    edad: u32,
}

impl Persona {
    fn new(nombre: String, edad: u32) -> Persona {
        Persona { nombre, edad }
    }

    fn saludar(&self) {
        println!("Hola, mi nombre es {} y tengo {} años.", self.nombre, self.edad);
    }
}

struct Pirata {
    persona: Persona,
    barco: String,
}

impl Pirata {
    fn new(nombre: String, edad: u32, barco: String) -> Pirata {
        Pirata {
            persona: Persona::new(nombre, edad),
            barco,
        }
    }

    fn presentarse(&self) {
        println!(
            "Soy el pirata {} y navego en el barco {}!",
            self.persona.nombre, self.barco
        );
    }
}

fn main() {
    let persona = Persona::new(String::from("Carlos"), 30);
    persona.saludar();

    let pirata = Pirata::new(String::from("Jack"), 40, String::from("Perla Negra"));
    pirata.presentarse();
}
