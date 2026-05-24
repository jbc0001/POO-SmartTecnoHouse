package modelo;

public class ActuadorBombilla extends Actuador {

    public ActuadorBombilla(String id, String nombre) {
        super(id, nombre);
    }

    @Override
    public void ejecutarAccion(String accion) {
        if (accion.equalsIgnoreCase("encender")) {
            estado = "encendida";
        } else if (accion.equalsIgnoreCase("apagar")) {
            estado = "apagada";
        }
    }

    @Override
    public String[] getAccionesPosibles() {
        return new String[]{"encender", "apagar"};
    }
}
