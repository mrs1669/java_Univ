package town;
/**
 * 
 * @author b1018104 Takumi Muraishi
 *
 */

public class TownMain {
	private Town t1;
	private Town t2;
	private Town t3;

	TownMain(){
		this.t1 = new Town (20.0, 53.7, "hakodate");
		this.t2 = new Town (200.0, 52.9, "sapporo");
		this.t3 = new Town (140.0, 51.0, "kyoto");
	}	
	
	public String show () {
        return (t1.disp() + ", " + t2.disp() + ", " + t3.disp());
	}


	public static void main(String[] args) {
	// TODO Auto-generated method stub
	TownMain a = new TownMain();
	System.out.println(a.show());
	}
}