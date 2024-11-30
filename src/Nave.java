/**
 * 
 */

/**
 * 
 */
public class Nave {
	// Dimensione massima della nave
	final int MAX_DIM_NAVE = 5;

	// Dimensione minima della nave
	final int MIN_DIM_NAVE = 2;
	
	// Numero delle navi in gioco
	final int NUM_NAVI = 5;
	
	// Numero navi affondate
	int naviAffondate = 0;

	/**
	 * Restituisce la grandezza massima di una nave
	 * 
	 * @return restituisce la dimensione massima delle navi
	 */
	public int getMAX_DIM_NAVE() {
		return MAX_DIM_NAVE;
	}

	/**
	 * Restituisce la grandezza minima di una nave
	 * 
	 * @return restituisce la dimensione minima delle navi
	 */
	public int getMIN_DIM_NAVE() {
		return MIN_DIM_NAVE;
	}

	/**
	 * Restituisce VERO se la dimensione di una nave, indicata dal paramento intero
	 * caselle è compresa tra la dimensione minima o massima di una nave
	 * 
	 * @param caselle intero che indica il numero di caselle colpite di una nave
	 * @return Restituisce VERO se la l'intero è compreso tra i valori delle
	 *         funzioni getMIN_DIM_NAVE e getMAX_DIM_NAVE; FALSO altrimenti
	 */
	public boolean inShipDimensions(int caselle) {
		return getMIN_DIM_NAVE() >= caselle && caselle <= getMAX_DIM_NAVE();
	}
}
