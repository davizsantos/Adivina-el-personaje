import javax.swing.ImageIcon;

import Personajes.Personaje;
import Personajes.Personajes;

/**
 * Clase que contiene los atributos y metodos de un Jugador.
 * 
 * @author david santos palmero
 * @version v1.0
 *
 */
public class Jugador {

	String nombre;
	boolean turnoDePreguntar;
	boolean haGanado;

	Personaje personajeAdjudicado;
	int cantidadDePreguntasRealizadas;
	static String tiempoConsumido = "00:00:000";

	ImageIcon personajeImageIcon;

	/**
	 * Constructor que recibe el nombre del jugador.
	 * 
	 * @param nombreParam String
	 */
	Jugador(String nombreParam) {
		System.out.println("Creando el jugador " + nombreParam);
		nombre = nombreParam;
		// TODO De momento, solo se puede jugar VS la máquina, por eso siempre es el turno del J1
		if (nombreParam.equalsIgnoreCase("J1")) {
			turnoDePreguntar = true;
		} else {
			turnoDePreguntar = false;
		}
		haGanado = false;
		personajeAdjudicado = seleccionAletoriaPersonaje();
		cantidadDePreguntasRealizadas = 0;
		System.out.println("Jugador " + this.getNombre() + " creado");
	}

	/**
	 * Metodo que asigna uno de los personajes al Jugador de manera aleatoria.
	 * 
	 * @return Personaje asignado al jugador
	 */
	Personaje seleccionAletoriaPersonaje() {
		System.out.println("Asignando personaje al jugador " + this.getNombre() + " ...");
		new Personajes();
		// Calculamos un numero aleatorio de 0 a 24
		int posicion = (int) Math.floor(Math.random() * 24);
		System.out.println("Personaje asignado: " + Personajes.personajes[posicion].getNombre());
		return Personajes.personajes[posicion];
	}

	/**
	 * Metodo que comprueba si el personaje ha sido adivinado o no.
	 * 
	 * @param nombrePersonaje String Nombre del personaje que el jugador a escrito para resolver el juego
	 * @param pc              Jugador "maquina"
	 * @return true si SI se ha acertado, false si NO se ha acertado
	 */
	static boolean personajeAcerdado(String nombrePersonaje, Jugador pc) {
		if (nombrePersonaje.equalsIgnoreCase(pc.personajeAdjudicado.getNombre())) {
			return true;
		} else {
			return false;
		}
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public boolean isTurnoDePreguntar() {
		return turnoDePreguntar;
	}

	public void setTurnoDePreguntar(boolean turnoDePreguntar) {
		this.turnoDePreguntar = turnoDePreguntar;
	}

	public boolean isHaGanado() {
		return haGanado;
	}

	public void setHaGanado(boolean haGanado) {
		this.haGanado = haGanado;
	}

	public Personaje getPersonajeAdjudicado() {
		return personajeAdjudicado;
	}

	public void setPersonajeAdjudicado(Personaje personajeAdjudicado) {
		this.personajeAdjudicado = personajeAdjudicado;
	}

}