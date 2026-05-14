package modelo;

public class SensorPresencia extends Sensor {

    public SensorPresencia(String id, String nombre) {
        super(id, nombre);
    }

    @Override
    public void actualizarValor() {
        this.valor = 1.0;
    }
}