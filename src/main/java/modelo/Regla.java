package modelo;

import java.util.List;

public interface Regla {

    void aplicar(List<Sensor> sensores, List<Actuador> actuadores);
}