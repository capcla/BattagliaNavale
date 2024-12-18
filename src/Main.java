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

		// Elecnto del normale ordine di tutti gli spari che verranno effettuati
		for (int i = 0; i < grigliaAttacco.getRigheColonne(); i++) {
			grigliaAttacco.getRigaColonna(grigliaAttacco.getSparo(i));
		}

		int i = -1;
		
		grigliaAttacco.setGriglia("A", 1);
		grigliaAttacco.setGriglia("A", 10);
		grigliaAttacco.setGriglia("A", 21);
		grigliaAttacco.setGriglia("A", 12);

		while (validInputKeyboard && ++i < grigliaAttacco.getRigheColonne()) {
//			int sparo = grigliaAttacco.getSparo(i);
			int sparo = 11;

			// Se si sta attaccando in una cella vuota
			if (grigliaAttacco.checkEmptyCell(sparo)) {

				ArrayList<Nodo> nodoList = new ArrayList<Nodo>();

				// Controlla se c'è una direzione da esplorare in orizzontale o verticale

				System.out.println();
				grigliaAttacco.getRigaColonna(sparo);
				System.out.print("(" + (i + 1) + ") ");
				System.out.print("Inserisci il report dello sparo\n(A)cqua, " + "(C)olpito, a(F)fondato: ");
				input.setInputTastiera();
				inputKeyboard = input.getInputTastiera();
				validInputKeyboard = input.checkStringFormat(inputKeyboard);

				// se l'input è valido
				if (validInputKeyboard) {
					// Inserimento dello sparo nella sulla griglia e relativa visualizzazione
					grigliaAttacco.setGriglia(inputKeyboard, sparo);
					grigliaAttacco.getGriglia();

					if (input.checkColpito(inputKeyboard)) {
						Nodo nodo = new Nodo(new Cella(sparo / colonne, sparo % colonne));
						nodo.setNodosNeighbours(sparo, grigliaAttacco);
						nodoList.add(nodo);

						if (nodo.getHorizontalVertical().size() > 0) {
							// Scelta casuale della direzione da andare a colpire tra
							// le celle libere
							Random random = new Random();

							// Ripete l'estrazione di una direzione random quando il
							// nodo aggiunto a nodoList è solo uno e la dimensione
							// dell'arrayList horizontalVertical è != 0
							while (nodoList.size() == 1 && nodoList.get(0).getHorizontalVertical().size() != 0) {
								int randomNumber = random.nextInt(nodo.getHorizontalVertical().size());
								int riga = nodo.getHorizontalVertical().get(randomNumber).getRiga();
								int colonna = nodo.getHorizontalVertical().get(randomNumber).getColonna();

								// Se non c'è differenza tra la riga del primo colpo (sparo / colonne)
								// e la riga estratta estratta casualmente, si sta cercando
								// sulle righe
								if ((sparo / colonne) == riga)
									grigliaAttacco.searchAndDestroyOnRow(sparo, riga, colonna, false, nodoList);
								else
									grigliaAttacco.searchAndDestroyOnColumn(sparo, riga, colonna, false, nodoList);
							}

							// Se il nodo non ha vicini orizzontali o verticali liberi,
							// va impostato come assegnato
							if (nodoList.get(0).getHorizontalVertical().size() == 0) {
								grigliaAttacco.changeInAssigned(sparo / colonne, sparo % colonne);
							}
						}

						// Se la cella non ha vicini liberi, deve essere impostata
						// come assegnata
						else {
							grigliaAttacco.setAssigned(sparo / colonne, sparo % colonne);
						}
					}
				}

				// se l'input non è valido
				else {
					System.out.println("Valori dell\'input errati!");
					i--;
				}
				
				grigliaAttacco.getGriglia();
			}

		}
	}
}
