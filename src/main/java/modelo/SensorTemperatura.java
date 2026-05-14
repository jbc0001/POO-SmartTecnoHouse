package modelo;

public class SensorTemperatura extends Sensor {

    public SensorTemperatura(String id, String nombre) {
        super(id, nombre);
    }

    @Override
    public void actualizarValor() {
        this.valor = 30.0;
    }
}