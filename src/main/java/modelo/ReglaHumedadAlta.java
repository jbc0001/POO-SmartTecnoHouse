package modelo;

import java.util.List;

public class ReglaHumedadAlta implements Regla {

    @Override
    public void aplicar(List<Sensor> sensores, List<Actuador> actuadores) {
        for (Sensor sensor : sensores) {
            if (sensor instanceof SensorHumedad && sensor.getValor() > 70) {
                for (Actuador actuador : actuadores) {
                    if (actuador instanceof ActuadorPersiana) {
                        actuador.ejecutarAccion("cerrar");
                    }
                }
            }
        }
    }
}