import java.io.BufferedReader;
import java.io.InputStreamReader;
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
	 * Controlla il formato della stringa string mediante espressioni le
	 * regolari. I formati accettati sono: [0-9][A-Z]|[0-9][0-9][A-Z]|[A-Z][0-9]
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
