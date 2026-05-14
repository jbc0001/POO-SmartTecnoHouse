package modelo;

public class ActuadorVentilador extends Actuador {

    public ActuadorVentilador(String id, String nombre) {
        super(id, nombre);
    }

    @Override
    public void ejecutarAccion(String accion) {
        if (accion.equalsIgnoreCase("encender")) {
            estado = "encendido";
        } else if (accion.equalsIgnoreCase("apagar")) {
            estado = "apagado";
        }
    }

    @Override
    public String[] getAccionesPosibles() {
        return new String[]{"encender", "apagar"};
    }
}