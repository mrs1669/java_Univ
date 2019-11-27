package card;

public class PointCard extends Card{
	private int point;
	
	PointCard(String name, int id){
		super(name, id);
		this.point = 0;
	}
	
	public void setPoint(int point) {
		this.point = point;
	}
	
	public int getPoint() {
		return this.point;
	}
	
	void setPoint() {	
	}
	
	public String show() {
		return (super.getId() + ". " + super.getName() + ", " + this.point);
	}
	
}
