package cardsort;

/**
 * 
 * @author b1018104 Takumi Muraishi
 *
 */

public class ShopCard3 extends ShopCard2 implements Comparable {
	
	ShopCard3(String name, int id, String grade, int age){
		super(name, id, grade, age);
	}

	public int ageRange(int border) {
		if(this.getAge() < border) {
			return -1;
		}else if(this.getAge() >= border){
			return 1;
		}else {
			return 0;
		}
	}
	
	public int compareTo(Object o) {
		ShopCard3 other = (ShopCard3)o;
		if(this.getGradeInt() - other.getGradeInt() < 0) {
			return -1;
		}else if(this.getGradeInt() - other.getGradeInt() > 0) {
			return 1;
		}else if(this.getGradeInt() - other.getGradeInt() == 0) {
			if(this.getAge() >= 55 && other.getAge() < 55) {
				return -1;
			}else if(this.getAge() < 55 && other.getAge() >= 55) {
				return 1;
			}else if((this.getAge() < 55 && other.getAge() < 55) || (this.getAge() >= 55 && other.getAge() >= 55)){
				if(this.getId() - other.getId() < 0) {
					return -1;
				}else if(this.getId() - other.getId() > 0) {
					return 1;
				}else {
					return 0;
				}
			}else {
				return 0;
			}
		}else {
			return 0;
		}
	}
	
    public static void main(String[] args) {
        ShopCard3 c;
        ShopCard3 c2;

        c = new ShopCard3("Lorem Ipsum", 1, "Gold", 55);
        c2 = new ShopCard3("Dolor Sit", 2, "Silver", 57);
        System.out.println("c  is " + c.show());
        System.out.println("c2 is "+ c2.show());
        System.out.println("c.compareTo(c2), assumed minus actual " + c.compareTo(c2));
        System.out.println("--------------");

        c = new ShopCard3("Lorem Ipsum", 1, "Silver", 40);
        c2 = new ShopCard3("Dolor Sit", 2, "Silver", 57);
        System.out.println("c  is " + c.show());
        System.out.println("c2 is "+ c2.show());
        System.out.println("c.compareTo(c2), assumed plus actual " + c.compareTo(c2));
        System.out.println("--------------");

        c = new ShopCard3("Lorem Ipsum", 1, "Bronze", 40);
        c2 = new ShopCard3("Dolor Sit", 2, "Bronze", 32);
        System.out.println("c  is " + c.show());
        System.out.println("c2 is "+ c2.show());
        System.out.println("c.compareTo(c2), assumed minus actual " + c.compareTo(c2));
        System.out.println("--------------");

        c = new ShopCard3("Lorem Ipsum", 1, "Bronze", 40);
        c2 = new ShopCard3("Dolor Sit", 2, "Gold", 32);
        System.out.println("c  is " + c.show());
        System.out.println("c2 is "+ c2.show());
        System.out.println("c.compareTo(c2), assumed plus actual " + c.compareTo(c2));
        System.out.println("--------------");
    }
	
}
