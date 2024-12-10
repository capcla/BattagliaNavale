
/**
 * 
 */

import java.util.ArrayList;

/**
 * 
 */

class Nodo {
	private Nodo nodo;
	private Cella cella; // Campo Cella
	private ArrayList<Cella> horizontalVertical; // Lista di celle adiacenti libere orizzontali e verticali ad un nodo
	private ArrayList<Cella> diagonals; // Lista delle celle adiacenti diagonali ad un nodo

	// Costruttore
	public Nodo(Cella cella) {
		this.cella = cella;
		this.horizontalVertical = new ArrayList<>();
		this.diagonals = new ArrayList<>();
		nodo = this;
	}

	/**
	 * Aggiunge una cella alla lista dei nodi adiacenti orizzontali e verticali
	 * 
	 * @param cella
	 */
	public void addHorizontalVertical(Cella cella) {
		horizontalVertical.add(cella);
	}

	/**
	 * Aggiunge una cella alla lista dei nodi adiacenti diagonali
	 * 
	 * @param cella cella diagonale da aggiungere
	 */
	public void addDiagonals(Cella cella) {
		diagonals.add(cella);
	}

	/**
	 * Restituisce il riferimento di una cella
	 * 
	 * @return cella
	 */
	public Cella getCella() {
		return cella;
	}

	/**
	 * Restituisce del riferimento dell'arrayList horizontalVertical
	 * 
	 * @return riferimento dell'arrayList horizontalVertical
	 */
	public ArrayList<Cella> getHorizontalVertical() {
		return horizontalVertical;
	}

	/**
	 * Restituisce del riferimento dell'arrayList diagonals
	 * 
	 * @return riferimento dell'arrayList diagonals
	 */
	public ArrayList<Cella> getDiagonals() {
		return diagonals;
	}

	/**
	 * Dato le coordinate di un nodo, la funzione controlla i suoi adiacenti. I nodi
	 * adiacenti orizzontali e verticali vengono aggiunti ad una apposita lista solo
	 * se sono vuoti; i nodi diagonali, invece, vengono aggiunti a prescindere ma si
	 * memorizza il loro status precedente al controllo
	 * 
	 * @param i       Intero complessivo indicante sia la riga che la riga che la
	 *                colonna della prima cella colpita di una nave
	 * 
	 * @param griglia Griglia sulla quale si sta operando
	 */
	public void setNodosNeighbours(int i, Griglia griglia) {
		final int r = i / griglia.getColonne();
		final int c = i % griglia.getColonne();

		for (int riga = r - 1; riga <= r + 1; riga++) {

			// Controlla se gli iteratori sono compresi nei valori validi delle
			// righe
			if ((riga >= 0) && (riga <= griglia.getRighe() - 1)) {

				for (int colonna = c - 1; colonna <= c + 1; colonna++) {

					// Controlla se gli iteratori sono compresi nei valori
					// validi delle colonne
					if ((colonna >= 0) && (colonna <= griglia.getColonne() - 1)) {

						// Condizione vera se le due sotto condizioni si verificano
						// in maniera disgiunta
						if (((riga == r) ^ (colonna == c))) {

							// Verifica se la cella è libera
							if (griglia.checkEmptyCell(riga, colonna))
								nodo.addHorizontalVertical(new Cella(riga, colonna));
						}

						// Riga e colonna sono diagonali rispetto alle coordinate
						// della casella principale
						else if ((riga != r) || (colonna != c))
							nodo.addDiagonals(new Cella(riga, colonna, griglia.getCasella(riga, colonna)));
					}
				}
			}
		}
	}

	// Metodo toString per rappresentare il nodo come stringa
	@Override
	public String toString() {
		return "Nodo{" + "cella=" + cella + ", adiacenti=" + horizontalVertical + '}';
	}
}
