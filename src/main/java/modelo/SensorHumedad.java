package modelo;

public class SensorHumedad extends Sensor {

    public SensorHumedad(String id, String nombre) {
        super(id, nombre);
    }

    @Override
    public void actualizarValor() {
        this.valor = 80.0;
    }
}