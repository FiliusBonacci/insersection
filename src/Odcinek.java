import java.util.ArrayList;

/**
 * Created by Pawel on 03.02.2017.
 */
public class Odcinek{
    Punkt p1 = new Punkt(), p2 = new Punkt();
    int id_odcinka=0;

    static ArrayList<Odcinek> listaOdcinkow = new ArrayList<>();

//    Odcinek(){
//        listaOdcinkow.add(this); //dodaje odcinek na liste
//    }

    Odcinek(double x1, double y1, double x2, double y2){
        p1.x = x1;  p1.y = y1; // 1. pkt
        p2.x = x2;  p2.y = y2; // 2. pkt

        id_odcinka += listaOdcinkow.size()+1 ; //zwieksz id odcinka
        listaOdcinkow.add(this); //dodaje odcinek na liste
    }

    Odcinek(Punkt p1, Punkt p2)
    {
        this.p1 = p1;
        this.p2 = p2;
        this.id_odcinka = p1.id_odcinka;
    }


    
    public static Punkt obliczPunktPrzecieciaProstejIOdcinka(Odcinek odcinek, double yy ) {
    	double x = (odcinek.p2.x - odcinek.p1.x)/(odcinek.p2.y - odcinek.p1.y ) * yy + odcinek.p1.x;
    	Punkt punktPrzeciecia = new Punkt(x, yy);
		//    y =       y1     + ((y2 - y1)/(x2 - x1))*(x - x1)
    	//double y = (double) (odcinek.p1.y + ((odcinek.p2.y - odcinek.p1.y)/(odcinek.p2.x - odcinek.p1.x))*(x - odcinek.p1.x));
    	if (Math.max(odcinek.p1.y, odcinek.p2.y)>= yy && Math.min(odcinek.p1.y, odcinek.p2.y)<= yy &&
    			Math.max(odcinek.p1.x, odcinek.p2.x)>= x && Math.min(odcinek.p1.x, odcinek.p2.x)<= x ) {
    		// punkt przeciecia nalezy do odcinka
    		punktPrzeciecia.id_odcinka = odcinek.id_odcinka; //nadaj id_odcinka
    		return punktPrzeciecia; // zwroc punkt przeciecia
		}
    	return null; // brak punktu przeciecia
	}
    
    public String toString(){
        return  p1 + "------" + p2 ;
    }


}
