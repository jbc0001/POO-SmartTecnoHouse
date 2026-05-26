package controlador;

import modelo.*;
import vista.VentanaPrincipal;

public class Main {

    public static void main(String[] args) {

        // CREAR CASA
        // Aquí se va a gestionar el sistema
        SmartTecnoHouse casa = new SmartTecnoHouse();

        // SENSORES
        // Serán lo que leen lo que pasa

        SensorTemperatura temp = new SensorTemperatura("1", "Temperatura salón");
        SensorLuz luz = new SensorLuz("2", "Luz salón");
        SensorPresencia presencia = new SensorPresencia("3", "Presencia salón");
        SensorHumedad humedad = new SensorHumedad("6", "Humedad salón");

        // ACTUADORES
        // Son los que realizan acciones
        ActuadorBombilla bombilla = new ActuadorBombilla("4", "Bombilla salón");
        ActuadorVentilador ventilador = new ActuadorVentilador("5", "Ventilador salón");
        ActuadorPersiana persiana = new ActuadorPersiana("7", "Persiana salón");
        // AÑADIR A LA CASA
        // Registramos todos los dispositivos que necesitamos según el RAA

        casa.agregarSensor(temp);
        casa.agregarSensor(luz);
        casa.agregarSensor(presencia);
        casa.agregarSensor(humedad);

        casa.agregarActuador(bombilla);
        casa.agregarActuador(ventilador);
        casa.agregarActuador(persiana);

        // REGLAS
        // Si no hay fichero previo, dejamos las reglas básicas cargadas
        casa.agregarRegla(new ReglaIluminacionAutomatica());
        casa.agregarRegla(new ReglaVentilacionConfortable());
        casa.agregarRegla(new ReglaHumedadAlta());

        // CARGAR ESTADO AL INICIAR
        // Aquí sí está bien colocado: los actuadores y reglas ya existen
        casa.cargarEstadoActuadores();
        casa.cargarConfiguracionReglas();

        // SIMULAR DATOS
        // Simulamos lecturas reales de sensores

        temp.actualizarValor();       // ejemplo: 30 → activa ventilador
        luz.actualizarValor();        // ejemplo: 20 → activa bombilla
        presencia.actualizarValor();  // ejemplo: 1 → hay alguien
        humedad.actualizarValor();    // ejemplo: 80 → cierra persiana

        // APLICAR REGLAS
        // El sistema decide automáticamente qué hacer

        casa.aplicarReglas();

        // RESULTADOS
        // Mostramos lo que ha pasado

        System.out.println("Estado bombilla: " + bombilla.getEstadoActual());
        System.out.println("Estado ventilador: " + ventilador.getEstadoActual());
        System.out.println("Estado persiana: " + persiana.getEstadoActual());

        // Iniciamos la interfaz grafica y conectamos
        VentanaPrincipal vista = new VentanaPrincipal();
        ControladorPrincipal controlador = new ControladorPrincipal(casa, vista);
        controlador.iniciar();
    }
}