package town;
/**
 * 
 * @author b1018104 Takumi Muraishi
 *
 */
public class Town {
	private double p;
	private double attract;
	private String name;
	
	Town(double p, double attract, String name){
		this.p = p;
		this.attract = attract;
		this.name = name;
	}	
	
	public String getName() {
		return name;
	}
	
	public void setP (double p) {
		this.p = p; 
	}
	
	public double getP () {
		return p; 
	}
	
	public void setAttract (double attract) {
		this.attract = attract; 
	}
	
	public double getAttract () {
		return attract; 
	}
	
	public String disp () {
        return (name + ":" + p + "(" + attract + ")");
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Town a = new Town (20.0, 53.7, "hakodate");
		String b = a.disp();
		System.out.println(b);
	}

}
