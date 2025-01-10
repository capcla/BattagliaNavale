import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;

class Input {
	private int i;
	private char c;
	private BufferedReader iT = new BufferedReader(new InputStreamReader(System.in));
	private String inputTastiera;

	/*
	 * Input (int i){ setInt(i); }
	 * 
	 * Input (char c){ setChar(c); }
	 * 
	 * Input(){
	 * 
	 * }
	 */

	/**
	 * Prende l'input da tastiera dell'utente e lo trasforma in lettere maiuscole
	 */
	void setInputTastiera() {
		try {
			this.inputTastiera = iT.readLine().toUpperCase();
		} catch (IOException e) {
			e.printStackTrace();
		}
//        this.inputTastiera = this.inputTastiera.toUpperCase();
	}

	/**
	 * Restituisce il contenuto della variabile inputTastiera
	 * 
	 * @return inputTastiera
	 */
	String getInputTastiera() {
		return this.inputTastiera;
	}

	/**
	 * Controlla il formato della stringa string mediante espressioni le regolari. I
	 * formati accettati sono: [0-9][A-Z]|[0-9][0-9][A-Z]|[A-Z][0-9]
	 * |[A-Z][0-9][0-9|[A]|[C]|[F]]
	 * 
	 * @param stringa input dell'utente
	 * @return restituisce vero se l'input dell'utente è corrispondete ad un tipo di
	 *         stringa ben formato; falso altrimenti
	 */
	boolean checkStringFormat(final String stringa) {
		boolean checkFormat = true;

		if (stringa.matches("[0-9][A-Z]|[0-9][0-9][A-Z]|[A-Z][0-9]|[A-Z][0-9]" + "[0-9]|[A]|[C]|[F]")) {

			if (stringa.matches("[0-9][A-Z]")) {

			} else if (stringa.matches("[0-9][0-9][A-Z]")) {

			} else if (stringa.matches("[A-Z][0-9]")) {

			} else if (stringa.matches("[A-Z][0-9][0-9]")) {

			} else if (stringa.matches("[A]|[C]|[F]")) {

			}
		} else
			checkFormat = false;

		return checkFormat;
	}

	/**
	 * Controlla se il parametro di ingresso è [F]
	 * 
	 * @param s stringa di ingresso
	 * @return Restituisce VERO se il parametro di ingresso corrisponde al valore
	 *         [F]; FALSO altrimenti
	 */
	boolean checkAffondato(final String s) {
		return s.matches("[F]");
	}

	/**
	 * Controlla se il parametro di ingresso è [C]
	 * 
	 * @param s stringa di ingresso
	 * @return Restituisce VERO se il parametro di ingresso corrisponde al valore
	 *         [C]; FALSO altrimenti
	 */
	boolean checkColpito(final String s) {
		return s.matches("[C]");
	}

	/**
	 * Controlla se il parametro di ingresso è [A]
	 * 
	 * @param s stringa di ingresso
	 * @return Restituisce VERO se il parametro di ingresso corrisponde al valore
	 *         [C]; FALSO altrimenti
	 */
	boolean checkAcqua(final String s) {
		return s.matches("[A]");
	}

	/**
	 * Evita che la nave venga dichiarata affondata trasformando la dichiarazione di
	 * affondamento nello stato di COLPITO
	 */
	public void avoidFalseSinking(ArrayList<Nodo> nodoList, List<Nave> naviList) {

		// Se è stato scoperto un solo nodo e viene dichiarato affondato, la
		// dichirazione viene cambiata in colpito
		/*
		 * if (nodoList.size() == 1) {
		 * 
		 * if (this.inputTastiera.matches("[F]")) { this.inputTastiera = "C";
		 * System.out.println("Non può essere affondata una nave di dimensione " +
		 * nodoList.size() + ". Il report è stato cambiato in COLPITO"); } else {
		 */
		int maxShipDimension = naviList.get(0).getDimensione();
		int minShipDimension = naviList.get(naviList.size() - 1).getDimensione();
		boolean inDimension = (nodoList.size() >= minShipDimension && nodoList.size() <= maxShipDimension);

		boolean trovato = false;

		if (inDimension) {
			for (int i = 0; i < naviList.size() && !trovato; i++) {

				// Confronta la dimensione della nave affondata con la dimensione delle
				// navi presenti nella lista delle navi nemiche
				if (nodoList.size() == naviList.get(i).getDimensione()) {
					trovato = true;
				}

			}
		} else {
			if (nodoList.size() < minShipDimension)
				System.out.println("Nave di dimensione " + nodoList.size() + "troppo piccola!");
			else
				System.out.println("Nave troppo grande di " + (nodoList.size() - maxShipDimension) +  " elementi");
		}

		if (!trovato) {
			System.out.println("Non esiste nessuna nave di questa dimensione!");
		}
	}
//			}

	/*
	 * private void setInt (int i) { this.i = i; }
	 * 
	 * public void setChar(char c){ this.c = c; }
	 * 
	 * public int getInt(){ return this.i; }
	 * 
	 * public char getChar(){ return this.c; }
	 * 
	 * public void setIn(){ this.c = in.next().charAt(0); }
	 * 
	 * public char getIn(){ return this.c; }
	 */
}
