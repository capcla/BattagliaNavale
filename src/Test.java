import java.util.ArrayList;
import java.util.Random;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		final int righe = 10;
		final int colonne = 10;
		Griglia grigliaAttacco = new Griglia(righe, colonne, true);
		Input input = new Input();
		boolean validInputKeyboard = true;
		String inputKeyboard;

//		for(int i = 0; i < grigliaAttacco.getRigheColonne(); i++){
//		    grigliaAttacco.getRigaColonna(grigliaAttacco.getSparo(i));
//		}   

		int i = 10;
		grigliaAttacco.setGriglia("A", 1);
		grigliaAttacco.setGriglia("A", 10);
		grigliaAttacco.setGriglia("A", 21);


		while (validInputKeyboard && ++i < grigliaAttacco.getRigheColonne()) {
			int sparo = grigliaAttacco.getSparo(i);

			// Se si sta attaccando in una cella vuota
			if (grigliaAttacco.checkEmptyCell(sparo)) {
				System.out.println();
				grigliaAttacco.getRigaColonna(sparo);

				ArrayList<Nodo> nodoList = new ArrayList<Nodo>();
				Nodo nodo = new Nodo(new Cella(sparo / colonne, sparo % colonne));
				nodo.setNodoAndNeighbours(i, grigliaAttacco);
				nodoList.add(nodo);
				
				ArrayList<FreePosition> freePosition = new ArrayList<FreePosition>();
				freePosition = grigliaAttacco.getFreeNearPosition(sparo);
				
				
				
				
				nodo = new Nodo(new Cella(2, 2));
				nodoList.add(nodo);
		//		nodoList.get(0).aggiungiAdiacente(new Cella(3,4));
				
				System.out.println(nodoList.size());
				
				
				
				

				if (freePosition.size() > 0) {

					System.out.print("(" + (i + 1) + ") ");
					System.out.print("Inserisci il report dello sparo\n(A)cqua, " + "(C)olpito, a(F)fondato: ");
					input.setInputTastiera();
					inputKeyboard = input.getInputTastiera();
					validInputKeyboard = input.checkStringFormat(inputKeyboard);

					// se l'input è valido
//		        if (validInputKeyboard){
					grigliaAttacco.setGriglia(inputKeyboard, sparo);


					grigliaAttacco.getGriglia();

					Random random = new Random();
					int randomNumber = random.nextInt(freePosition.size());
					int riga = freePosition.get(randomNumber).getRiga();
					int colonna = freePosition.get(randomNumber).getColonna();
					// DEBUG
					int s = sparo / grigliaAttacco.getColonne();

//		                if(sparo/grigliaAttacco.getColonne() == riga)
					if (true)
						grigliaAttacco.searchAndDestroyOnRow(sparo, riga, colonna, false, 1);
//		                else
//		                	grigliaAttacco.searchAndDestroyOnColumn(sparo, riga, colonna, false);
//		            }
//		            
//		            else {
//		            	grigliaAttacco.setGriglia("A", sparo);
//		            	//DEBUG
//		            	grigliaAttacco.getGriglia();
//		            }	            
//		        }
//		        //se l'input non è valido
//		        else{
//		            System.out.println("Valori dell\'input errati!");
//		            i--;
//		        }
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