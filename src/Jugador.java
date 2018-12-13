import javax.swing.ImageIcon;

import Personajes.Personaje;
import Personajes.Personajes;

public class Jugador {


	String nombre;
	boolean turnoDePreguntar = true;
	boolean haGanado = false;

	Personaje personajeAdjudicado;
	// "1" pregunta hecha, "0" pregunta sin hacer
	int preguntasHechas[] = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, };
	int cantidadDePruguntasRealizadas = 0;
	static String tiempoConsumido = "00:00:000";

	ImageIcon personajeImageIcon;

	Jugador(String nombreParam) {
		nombre = nombreParam;
		personajeAdjudicado = seleccionAletoriaPersonaje();
	}

	Personaje seleccionAletoriaPersonaje() {
		System.out.println("Asignando personaje al jugador " + this.getNombre() + " ...");
		Personajes p = new Personajes();
		int posicion = (int) Math.floor(Math.random() * 24);
		System.out.println("Personaje asignado: " + p.personajes[posicion].getNombre());
		return p.personajes[posicion];
	}

	static boolean personajeAcerdado(String intentar, Jugador pc) {
		if (intentar.equalsIgnoreCase(pc.personajeAdjudicado.getNombre())) {
			return true;
		} else {
			return false;
		}
	}

	void realizarPregunta() {
		System.out.println("El " + this.nombre + " va a realizar una pregunta");
		String preguntas[] = Preguntas.preguntasArrayStr;
		int i = 0;
		System.out.println("Preguntas disponibles para " + this.nombre);
		for (i = 0; i < preguntas.length; i++) {
			if (preguntasHechas[i] != 1)
				System.out.println("i: " + i + " - " + preguntas[i]);
		}
		// tacharPregunta(preguntasHechas, i);
	}

	void tacharPregunta(int preguntasHechas[], int posicion) {
		System.out.println("Se procede a tachar la pregunta de la posición " + posicion);
		preguntasHechas[posicion] = 1;
		System.out.println("Se ha tachado la pregunta " + preguntasHechas[posicion]);
	}

	/**
	 * Getters y setters
	 */

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

	public int[] getPreguntasHechas() {
		return preguntasHechas;
	}

	public void setPreguntasHechas(int[] preguntasHechas) {
		this.preguntasHechas = preguntasHechas;
	}

}