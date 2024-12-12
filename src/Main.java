import java.util.Random;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {

		final int righe = 10;
		final int colonne = 10;
		Griglia grigliaAttacco = new Griglia(righe, colonne);
		Input input = new Input();
		boolean validInputKeyboard = true;
		String inputKeyboard;
		ArrayList<Nodo> nodoList = new ArrayList<Nodo>();

		// Elecnto del normale ordine di tutti gli spari che verranno effettuati
		for (int i = 0; i < grigliaAttacco.getRigheColonne(); i++) {
			grigliaAttacco.getRigaColonna(grigliaAttacco.getSparo(i));
		}

		int i = -1;

		while (validInputKeyboard && ++i < grigliaAttacco.getRigheColonne()) {
			int sparo = grigliaAttacco.getSparo(i);

			// Se si sta attaccando in una cella vuota
			if (grigliaAttacco.checkEmptyCell(sparo)) {

				Nodo nodo = new Nodo(new Cella(sparo / colonne, sparo % colonne));
				nodo.setNodosNeighbours(sparo, grigliaAttacco);
				nodoList.add(nodo);

				// Controlla se c'è una direzione da esplorare in orizzontale o verticale
				if (nodo.getHorizontalVertical().size() > 0) {
					System.out.println();
					grigliaAttacco.getRigaColonna(sparo);
					System.out.print("(" + (i + 1) + ") ");
					System.out.print("Inserisci il report dello sparo\n(A)cqua, " + "(C)olpito, a(F)fondato: ");
					input.setInputTastiera();
					inputKeyboard = input.getInputTastiera();
					validInputKeyboard = input.checkStringFormat(inputKeyboard);

					// se l'input è valido
					if (validInputKeyboard) {
//						Inserimento dello sparo nella sulla griglia e relativa visualizzazione
						grigliaAttacco.setGriglia(inputKeyboard, sparo);
						grigliaAttacco.getGriglia();

						// Scelta casuale della direzione da andare a colpire tra
						// le celle libere
						Random random = new Random();
						int randomNumber = random.nextInt(nodo.getHorizontalVertical().size());
						int riga = nodo.getHorizontalVertical().get(randomNumber).getRiga();
						int colonna = nodo.getHorizontalVertical().get(randomNumber).getColonna();

						// Se non c'è differenza tra la riga del primo colpo (sparo / colonne) 
						// e la riga estratta estratta casualmente, si sta cercando
						//sulle righe
						if ((sparo / colonne) == riga)
							grigliaAttacco.searchAndDestroyOnRow(sparo, riga, colonna, false, nodoList);
						else
							grigliaAttacco.searchAndDestroyOnColumn(sparo, riga, colonna, false, nodoList);
					}

					// se l'input non è valido
					else {
						System.out.println("Valori dell\'input errati!");
						i--;
					}
				}

				// Se la cella non ha vicini liberi, deve essere impostata come
				// assegnata
				else {
					grigliaAttacco.setAssigned(sparo / colonne, sparo % colonne);
				}
			}
		}
	}
}
