package modelo;

public abstract class Sensor implements IDispositivo {
    protected String id;
    protected String nombre;
    protected double valor;

    public Sensor(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.valor = 0.0;
    }

    public abstract void actualizarValor();

    public double getValor() {
        return valor;
    }

    @Override
    public String getID() {
        return id;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public String getEstadoActual() {
        return String.valueOf(valor);
    }
}