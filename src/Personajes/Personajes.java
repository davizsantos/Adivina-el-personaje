package Personajes;

/**
 * Clase que contiene un array con todos los ojbetos de tipo Personaje
 * 
 * @author david santos palmero
 * @version v1.0
 *
 */
public class Personajes {

	public static Personaje personajes[] = new Personaje[24];

	/**
	 * Constructor por defecto
	 */
	public Personajes() {
		rellenarArray();
	}

	/**
	 * Metodo que rellena el array con cada objeto de tipo Personaje de la clase Personaje
	 */
	void rellenarArray() {
		personajes[0] = new Personaje();
		personajes[0].Alex();
		personajes[1] = new Personaje();
		personajes[1].Alfred();
		personajes[2] = new Personaje();
		personajes[2].Anita();
		personajes[3] = new Personaje();
		personajes[3].Anne();
		personajes[4] = new Personaje();
		personajes[4].Bernard();
		personajes[5] = new Personaje();
		personajes[5].Bill();
		personajes[6] = new Personaje();
		personajes[6].Charles();
		personajes[7] = new Personaje();
		personajes[7].Claire();
		personajes[8] = new Personaje();
		personajes[8].David();
		personajes[9] = new Personaje();
		personajes[9].Eric();
		personajes[10] = new Personaje();
		personajes[10].Frans();
		personajes[11] = new Personaje();
		personajes[11].George();
		personajes[12] = new Personaje();
		personajes[12].Herman();
		personajes[13] = new Personaje();
		personajes[13].Joe();
		personajes[14] = new Personaje();
		personajes[14].Maria();
		personajes[15] = new Personaje();
		personajes[15].Max();
		personajes[16] = new Personaje();
		personajes[16].Paul();
		personajes[17] = new Personaje();
		personajes[17].Peter();
		personajes[18] = new Personaje();
		personajes[18].Philip();
		personajes[19] = new Personaje();
		personajes[19].Richard();
		personajes[20] = new Personaje();
		personajes[20].Robert();
		personajes[21] = new Personaje();
		personajes[21].Sam();
		personajes[22] = new Personaje();
		personajes[22].Susan();
		personajes[23] = new Personaje();
		personajes[23].Tom();
	}
}