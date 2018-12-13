public class Juego {

	static Jugador J1;
	static Jugador PC;

	Juego() {

	}

	public static void main(String[] args) {
		crearJugadores(J1, PC);
		calcularTurno(J1, PC);
		generarVentana(J1, PC);
	}

	static void generarVentana(Jugador j1, Jugador pc) {
		System.out.println("Generando la ventana...");
		Ventana frame = new Ventana();
		frame.setVisible(true);
		System.out.println("Ventana generada");
	}

	static void crearJugadores(Jugador j1, Jugador pc) {
		int contador = 1;
		System.out.println("Creando jugadores...");
		do {
			System.out.println("Intento de creación de jugadores nº " + contador);
			System.out.println("Creando jugador 1...");
			J1 = new Jugador("J1"); // Se crea el Jugador
			System.out.println("Creando jugador PC...");
			PC = new Jugador("PC"); // Se crea el PC
			contador++;
			// Se vuelven a elegir personajes si se ha elegido el mismo personaje para J1
			// que para PC
		} while (J1.personajeAdjudicado.getNombre().equalsIgnoreCase(PC.personajeAdjudicado.getNombre()));
		System.out.println("Jugadores creados");
	}

	static void calcularTurno(Jugador j1, Jugador pc) {
		System.out.println("Calculando turno...");
		Turno turno = new Turno();
		turno.calcularTurno();
		System.out.println("Turno calculado");
		System.out.println("Le toca preguntar a " + ((J1.turnoDePreguntar) ? "J1" : " PC"));
	}

}