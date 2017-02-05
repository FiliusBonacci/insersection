import java.util.*;

public class Main {

	public static void main(String[] args) {

		Punkt p1 = new Punkt(4, 2);	p1.id_odcinka = 1;  //spr dla Punkt(4,2) powinny sie przecinac
		Punkt p2 = new Punkt(-1, 2); p2.id_odcinka = 1;
		Punkt p3 = new Punkt(2, 1.5);p3.id_odcinka = 2;
		Punkt p4 = new Punkt(3, 5);	p4.id_odcinka = 2;

		ArrayList<Odcinek> listaOdcinkow = new ArrayList<>();

		Odcinek o1 = new Odcinek(p1, p2); 
		Odcinek o2 = new Odcinek(p3, p4);

		// status â†’ lista odcinkÃ³w przecinajÄ…cych l
		ArrayList<Integer> status = new ArrayList<>(); // bedzie zawieraÅ‚ liste
														// id_odcinkow ktore
														// obecnie przecinaja l
		Odcinek oo; // odcinek pomocnicza

		listaOdcinkow.add(o1);
		listaOdcinkow.add(o2);

		ArrayList<Double> y = new ArrayList<>();
		// double[] y = new double[1 + 2 * listaOdcinkow.size()]; // y=a

		// dodaj wartosci do statusu
		for (Iterator<Odcinek> i = listaOdcinkow.iterator(); i.hasNext();) {
			oo = i.next();

			// zapis wszystkich punktów y do tablicy y[]
			y.add(oo.p1.y);
			y.add(oo.p2.y);

			// System.out.println(oo.p1.y);
			// System.out.println(oo.p2.y);
			// int id = oo.id_odcinka;
			// System.out.print(id + " ");
			// System.out.println(oo);
		}

		// posortuj y malej¹co
		y.sort(null);
		Collections.reverse(y);
		// System.out.println(y);

		ArrayList<Punkt> listaPunktow = new ArrayList<>();

		listaPunktow.add(p1);
		listaPunktow.add(p2);
		listaPunktow.add(p3);
		listaPunktow.add(p4);
		
		listaPunktow.sort(null); // posortowana lista pktow

		for(int i = 0 ; i < listaPunktow.size(); i++){
//		for (Iterator<Punkt> i = listaPunktow.iterator(); i.hasNext();) {
			Punkt pom = listaPunktow.get(i);
			status.add(pom.id_odcinka);
			int indexPom = status.lastIndexOf(pom.id_odcinka);
			int ind = indexPom;
			

			
			if (status.size() > 1) {
				
				if (status.get(indexPom-1) == status.get(indexPom)) { //odcinek zaczyna sie i zaraz konczy
					System.out.println("Odcinek id: "+ status.get(indexPom-1) +" nie przecina siê z ¿adnym innym");
					status.remove(indexPom);
					status.remove(indexPom - 1);
					
				} else if( status.get(indexPom-1) != status.get(indexPom)  ){ //odc zaczyna sie jest i inny po drodze ...
					//oblicz punkt przeciecia
					// sprawdz czy dla obecnego y=a jest przeciecie z odcinkiem
					Punkt pkt = Odcinek.obliczPunktPrzecieciaProstejIOdcinka(o2,pom.y);
					
					//sprawdz czy punkt przeciecia.x  jest < od kolejnego punktu.x na liscie punktów
					if (pkt != null) {
						try{
							if (pkt.x <= listaPunktow.get(i+1).x) {
								// jesli tak to dodaj punkt przeciecia.id_odcinka do statusu
								status.add(pkt.id_odcinka); //dodaj id do statusu
								//int id = pkt.id_odcinka; //jezeli zostal ustaiony pkt przeciecia zmien ind
								//ind = status.indexOf(id); // index pod ktorym zostala dodana wartosc
								System.out.println( pkt.id_odcinka+ " i "+ listaPunktow.get(i).id_odcinka  +" przecinaj¹ siê");
							}
						} catch (IndexOutOfBoundsException  e) {
							
						}
					}
					
				} else if( status.get(indexPom) != status.get(ind)  ){
					System.out.println("Przecinaj¹ siê");
				} else{
					System.out.println("Podane odcinki nie przecinaj¹ siê");
				}
			}
		}
	}
}
