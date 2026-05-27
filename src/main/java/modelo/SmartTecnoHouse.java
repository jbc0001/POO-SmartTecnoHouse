package modelo;

import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;

public class SmartTecnoHouse {

    private List<Sensor> sensores;
    private List<Actuador> actuadores;
    private List<Regla> reglas;

    public SmartTecnoHouse() {
        sensores = new ArrayList<>();
        actuadores = new ArrayList<>();
        reglas = new ArrayList<>();
    }

    public void agregarSensor(Sensor sensor) {
        sensores.add(sensor);
    }

    public void agregarActuador(Actuador actuador) {
        actuadores.add(actuador);
    }

    public void agregarRegla(Regla regla) {
        reglas.add(regla);
    }

    public void aplicarReglas() {
        for (Regla regla : reglas) {
            regla.aplicar(sensores, actuadores);
        }
    }

    public List<Sensor> getSensores() {
        return sensores;
    }

    public List<Actuador> getActuadores() {
        return actuadores;
    }

    public List<Regla> getReglas() {
        return reglas;
    }

    // ====== GUARDAR ======
    public void guardarEstadoActuadores() {
        try {
            java.io.PrintWriter writer = new java.io.PrintWriter("actuadores.txt");
            java.io.PrintWriter log = new java.io.PrintWriter("actuators.log");

            for (Actuador a : actuadores) {
                String linea = a.getID() + ";" + a.getNombre() + ";" + a.getEstadoActual();
                writer.println(linea);   // fichero de persistencia
                log.println(linea);      // fichero de log que pide el enunciado
            }

            writer.close();
            log.close();
            System.out.println("Estado guardado en actuadores.txt y actuators.log");

        } catch (Exception e) {
            System.out.println("Error guardar el estado");
        }
    }

    public void guardarConfiguracionReglas() {
        try {
            java.io.PrintWriter writer = new java.io.PrintWriter("reglas.txt");

            for (Regla r : reglas) {
                writer.println(r.getClass().getSimpleName());
            }

            writer.close();
            System.out.println("Configuración guardada reglas.txt");

        } catch (Exception e) {
            System.out.println("Error guardar las reglas");
        }
    }

    // ====== CARGAR ======
    public void cargarEstadoActuadores() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("actuadores.txt"));
            String linea;

            while ((linea = reader.readLine()) != null) {
                String[] partes = linea.split(";");

                String id = partes[0];
                String estadoGuardado = partes[2];

                for (Actuador a : actuadores) {
                    if (a.getID().equals(id)) {
                        a.estado = estadoGuardado;
                    }
                }
            }

            reader.close();
            System.out.println("Estado cargado desde actuadores.txt");

        } catch (Exception e) {
            System.out.println("No hay estado previo de actuadores para cargar");
        }
    }

    public void cargarConfiguracionReglas() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("reglas.txt"));
            String linea;

            reglas.clear();

            while ((linea = reader.readLine()) != null) {
                if (linea.equals("ReglaIluminacionAutomatica")) {
                    reglas.add(new ReglaIluminacionAutomatica());
                } else if (linea.equals("ReglaVentilacionConfortable")) {
                    reglas.add(new ReglaVentilacionConfortable());
                } else if (linea.equals("ReglaHumedadAlta")) {
                    reglas.add(new ReglaHumedadAlta());
                }
            }

            reader.close();
            System.out.println("Configuración cargada desde reglas.txt");

        } catch (Exception e) {
            System.out.println("No hay configuración previa de reglas para cargar");
        }
    }
}