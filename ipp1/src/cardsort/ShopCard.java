package cardsort;

/**
 * 
 * @author b1018104 Takumi Muraishi
 *
 */

public class ShopCard extends Card{
	private String grade;
	private int age;
	
	ShopCard(String name, int id, String grade, int age){
		super(name, id);
		this.grade = grade;
		this.age = age;
	}
	
	public int getAge() {
		return this.age;
	}
	
	public String getGrade() {
		return this.grade;
	}
	
	public int getGradeInt() {
		if(this.grade == "Gold") {
			return 1;
		}else if(this.grade == "Silver") {
			return 2;
		}else if(this.grade == "Bronze") {
			return 3;
		}else {
			return 0;
		}
	}
	
	public String show() {
		return (super.getId() + ", \"" + super.getName() + "\", \"" + this.grade + "\", " + this.age);
	}
	
	public static void main(String[] args) {
        ShopCard c = new ShopCard("Lorem Ipsum", 1, "Silver", 60);
        System.out.println(c.getGradeInt());
        System.out.println(c.show());
    }
	

}
