package modelo;

import java.util.List;

public class ReglaIluminacionAutomatica implements Regla {

    @Override
    public void aplicar(List<Sensor> sensores, List<Actuador> actuadores) {
        for (Sensor sensor : sensores) {
            if (sensor instanceof SensorLuz && sensor.getValor() < 50) {
                for (Actuador actuador : actuadores) {
                    if (actuador instanceof ActuadorBombilla) {
                        actuador.ejecutarAccion("encender");
                    }
                }
            }
        }
    }
}