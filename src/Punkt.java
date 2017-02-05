public class Punkt implements Comparable<Punkt>{
    double x,y;  //wspolrzedne punktu
    int id_odcinka=-1;
    
    //konstruktor domyslny
    Punkt(){
//        x=y=0;
    }

    Punkt(double d, double e){
        this.x = d;
        this.y = e;
        id_odcinka = -1;
    }
    
    Punkt(double d, double e, int id){
        this.x = d;
        this.y = e;
        id_odcinka = id;
    }

    public boolean porownajEventPoint(Punkt p1, Punkt p2){
        //if event point = górny koniec odcinka then...
        if (p1.y == p2.y)
            return true;
        else
            return false;
    }

    
    public String toString(){
         return "(" + x  + "," + y +"), id = "+id_odcinka;
    }



//	@Override
//	public boolean equals(Object obj) {
//		if (this.y >= ((Punkt) obj).y) {
//			return true;
//		}
//		return false;
//	}

//    sortuj od najwiekszej do najmniejszej po y
//    potem po x od lewej do prawej
	@Override
	public int compareTo(Punkt o) {
		if (this.y > o.y) {
			return -1;
		}
		else if(this.y == o.y) {
			if (this.x > o.x) {
				return 1;
			} else if(this.x == o.x) return 0;
			else return -1;
		}
		else return 1;
	}
}
