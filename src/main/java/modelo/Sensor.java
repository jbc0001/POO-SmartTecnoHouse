package modelo;

public abstract class Sensor implements IDispositivo {

    protected String id;
    protected String nombre;
    protected double valor;

    public Sensor(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    @Override
    public String getID() {
        return id;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    public double getValor() {
        return valor;
    }

    public abstract void actualizarValor();

    @Override
    public String getEstadoActual() {
        return "Valor: " + valor;
    }
}