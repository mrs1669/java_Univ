package cardsort;

/**
 * 
 * @author b1018104 Takumi Muraishi
 *
 */

public class ShopCard2 extends ShopCard implements Comparable{
	
	ShopCard2(String name, int id, String grade, int age){
		super(name, id, grade, age);
	}
	
	public int compareTo(Object o) {
		ShopCard2 other = (ShopCard2)o;
		return this.getAge() - other.getAge();
	}
	
    public static void main(String[] args) {
        ShopCard2 c = new ShopCard2("Lorem Ipsum", 1, "Gold", 56);
        System.out.println("c is " + c.show() );
        System.out.println("c.getGradeInt() will be 1, actually " + c.getGradeInt());
        ShopCard2 c2 = new ShopCard2("Dolor Sit", 2, "Silver", 57);
        System.out.println("c2 is " + c2.show() );
        System.out.println("c2.getGradeInt() will be 2, actually " + c2.getGradeInt());
        System.out.println("c.compareTo(c2) will be minus, actually " + c.compareTo(c2));
    }
}
