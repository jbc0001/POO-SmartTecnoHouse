package modelo;

public abstract class Actuador implements IDispositivo {

    protected String id;
    protected String nombre;
    protected String estado;

    public Actuador(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.estado = "apagado";
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
        return estado;
    }

    public abstract void ejecutarAccion(String accion);

    public abstract String[] getAccionesPosibles();
}