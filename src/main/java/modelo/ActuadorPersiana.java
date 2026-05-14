package modelo;

public class ActuadorPersiana extends Actuador {

    public ActuadorPersiana(String id, String nombre) {
        super(id, nombre);
        this.estado = "cerrada";
    }

    @Override
    public void ejecutarAccion(String accion) {
        if (accion.equalsIgnoreCase("abrir")) {
            estado = "abierta";
        } else if (accion.equalsIgnoreCase("cerrar")) {
            estado = "cerrada";
        }
    }

    @Override
    public String[] getAccionesPosibles() {
        return new String[]{"abrir", "cerrar"};
    }
}