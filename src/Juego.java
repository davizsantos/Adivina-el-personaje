/**
 * Clase principal de la aplicacion. 
 * Se trata de un juego parecido al "Quien es quien", en el que hay que adivinar el personaje escondido mediante una serie de preguntas cuyas respuestas serán SI o NO.
 * 
 * @author david santos palmero
 * @version v1.0
 *
 */
public class Juego {

	static Jugador J1;
	static Jugador PC;

	/**
	 * Constructor por defecto.
	 */
	Juego() {
	}

	/**
	 * Metodo principal de la aplicacion.
	 * 
	 * @param args por defecto
	 */
	public static void main(String[] args) {
		Juego juego = new Juego();
		juego.jugar();
	}

	/**
	 * Metodo que da inicio al juego.
	 */
	public void jugar() {
		crearJugadores();
		calcularTurno();
		generarVentana();
	}

	/**
	 * Metodo mediante el cual se instancia la ventana principal del juego de la que luego saldrán el resto de ventanas emergentes.
	 */
	static void generarVentana() {
		// Se crea el objeto Ventana que es el que engloba todo el juego
		new Ventana();
	}

	/**
	 * Metodo que crea los jugadores que participan en el juego.
	 */
	static void crearJugadores() {
		System.out.println("Creando jugadores...");
		do {
			J1 = new Jugador("J1");
			PC = new Jugador("PC");
			// Se vuelven a elegir personajes si se ha elegido el mismo personaje para J1 que para PC
		} while (J1.personajeAdjudicado.getNombre().equalsIgnoreCase(PC.personajeAdjudicado.getNombre()));
		System.out.println("Jugadores creados");
	}

	/**
	 * Metodo que calcula que jugador comienza primero a jugar.
	 */
	static void calcularTurno() {
		System.out.println("Calculando turno...");
		Turno turno = new Turno();
		turno.calcularTurno();
		System.out.println("Turno calculado");
		System.out.println("Le toca preguntar a " + ((J1.turnoDePreguntar) ? "J1" : " PC"));
	}

}