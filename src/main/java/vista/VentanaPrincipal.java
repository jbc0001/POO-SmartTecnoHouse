package vista;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;

public class VentanaPrincipal extends JFrame {

    private JButton botonActualizar;
    private JTextArea areaEstado;

    public VentanaPrincipal() {
        setTitle("Smart TecnoHouse");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Parte superor con mi mensaje de bienvenida y botón
        JPanel panelSuperior = new JPanel();
        JLabel etiqueta = new JLabel("Bienvenido al RAA Smart TecnoHouse", SwingConstants.CENTER);
        botonActualizar = new JButton("Actualizar estado");
        panelSuperior.add(etiqueta);
        panelSuperior.add(botonActualizar);

        // aqu mostrare los estados de mis dispositivos
        areaEstado = new JTextArea();
        areaEstado.setEditable(false);

        add(panelSuperior, BorderLayout.NORTH);
        add(new JScrollPane(areaEstado), BorderLayout.CENTER);
    }

    // Con esto controlo mi boton en el panel
    public void setControlador(ActionListener listener) {
        botonActualizar.addActionListener(listener);
    }

    // con esto puedo controlar mi ventana
    public void setControladorVentana(WindowListener listener) {
        addWindowListener(listener);
    }

    // aqui muestro mi pantalle el estador de mi contolador
    public void mostrarEstado(String texto) {
        areaEstado.setText(texto);
    }
}