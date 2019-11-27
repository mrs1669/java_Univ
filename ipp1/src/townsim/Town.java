package townsim;
/**
 * 
 * @author b1018104 Takumi Muraishi
 *
 */
public class Town {
	private double p;
	private double attract;
	private String name;
	private double in;
	private double out;
	
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
        return (name + ":" + (double)Math.round(100*p)/100 + "(" + attract + ")");
	}
	
	public void setIn(double in) {
		this.in = in;
	}

	public void setOut(double out) {
		this.out = out;
	}
	
	public void update() {
		p += in;
		p -= out;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Town t = new Town (20.125, 53.7, "hakodate");
		String b = t.disp();
		System.out.println(b);
	}

}
