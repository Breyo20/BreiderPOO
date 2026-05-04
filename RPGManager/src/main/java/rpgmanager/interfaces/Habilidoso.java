package rpgmanager.interfaces;

import rpgmanager.model.Personaje;

public interface Habilidoso {

    void usarHabilidadEspecial(Personaje obj);

    int getCostoHabilidad();

    String getNombreHabilidad();
}