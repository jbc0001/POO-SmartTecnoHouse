package controlador;

import modelo.SmartTecnoHouse;
import modelo.Sensor;
import modelo.Actuador;
import vista.VentanaPrincipal;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowListener;
import java.awt.event.WindowEvent;

public class ControladorPrincipal implements ActionListener, WindowListener {

    private SmartTecnoHouse casa;
    private VentanaPrincipal vista;

    public ControladorPrincipal(SmartTecnoHouse casa, VentanaPrincipal vista) {
        this.casa = casa;
        this.vista = vista;
    }

    public void iniciar() {
        vista.setControlador(this);
        vista.setControladorVentana(this);
        vista.mostrarEstado(construirEstado());   // estado inicial en la ventana
        vista.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Al pulsar el botón: leemos sensores y aplicamos reglas
        for (Sensor s : casa.getSensores()) {
            s.actualizarValor();
        }
        casa.aplicarReglas();

        // Construimos el estado de yba vez
        String estado = construirEstado();

        // Lo mostramos en la ventana
        vista.mostrarEstado(estado);

        // también en la consola podemos verlo
        System.out.println("----- Actualizar estado -----");
        System.out.println(estado);
    }

    // texto del estado a partir del modelo
    private String construirEstado() {
        StringBuilder sb = new StringBuilder();

        sb.append("SENSORES\n");
        for (Sensor s : casa.getSensores()) {
            sb.append("  ").append(s.getNombre()).append(": ").append(s.getEstadoActual()).append("\n");
        }

        sb.append("\nACTUADORES\n");
        for (Actuador a : casa.getActuadores()) {
            sb.append("  ").append(a.getNombre()).append(": ").append(a.getEstadoActual()).append("\n");
        }

        return sb.toString();
    }

    @Override
    public void windowClosing(WindowEvent e) {
        casa.guardarEstadoActuadores();
        casa.guardarConfiguracionReglas();
        System.out.println("Guardado al cerrar la aplicación");
    }
    @Override
    public void windowOpened(WindowEvent e) {
    }
    @Override
    public void windowClosed(WindowEvent e) {
    }
    @Override
    public void windowIconified(WindowEvent e) {
    }
    @Override
    public void windowDeiconified(WindowEvent e) {
    }
    @Override
    public void windowActivated(WindowEvent e) {
    }
    @Override
    public void windowDeactivated(WindowEvent e) {
    }
}