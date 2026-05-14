package modelo;

public class SensorLuz extends Sensor {

    public SensorLuz(String id, String nombre) {
        super(id, nombre);
    }

    @Override
    public void actualizarValor() {
        this.valor = 20.0;
    }
}