package modelo;

import java.util.List;

public class ReglaVentilacionConfortable implements Regla {

    @Override
    public void aplicar(List<Sensor> sensores, List<Actuador> actuadores) {
        for (Sensor sensor : sensores) {
            if (sensor instanceof SensorTemperatura && sensor.getValor() > 25) {
                for (Actuador actuador : actuadores) {
                    if (actuador instanceof ActuadorVentilador) {
                        actuador.ejecutarAccion("encender");
                    }
                }
            }
        }
    }
}