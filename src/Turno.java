/**
 * Clase encargada de gestionar el turno de partida.
 * 
 * @author david santos palmero
 * @version v1.0
 *
 */
public class Turno {

	boolean turnoDeJ1 = true;
	boolean turnoDePC = false;

	/**
	 * Constructor por defecto.
	 */
	public Turno() {

	}

	/**
	 * Metodo que calcula a que jugador le toca jugar.
	 */
	void calcularTurno() {
		this.setTurnoDeJ1(true);
		System.out.println("El turno de J1 es " + this.isTurnoDeJ1());
		this.setTurnoDePC(false);
		System.out.println("El turno de PC es " + this.isTurnoDePC());
	}

	public boolean isTurnoDeJ1() {
		return turnoDeJ1;
	}

	public void setTurnoDeJ1(boolean turnoDeJ1) {
		this.turnoDeJ1 = turnoDeJ1;
	}

	public boolean isTurnoDePC() {
		return turnoDePC;
	}

	public void setTurnoDePC(boolean turnoDePC) {
		this.turnoDePC = turnoDePC;
	}

}