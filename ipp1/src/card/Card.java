package card;

/**
 * 
 * @author b1018104 Takumi Muraishi
 *
 */

public class Card {
	
	private String name;
	private int id;
	
	Card(String name, int id){
		this.name = name;
		this.id = id;
	}
	
	public int getId () {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public String show() {
		return (id + ", \"" + name + "\"");
	}

	
    public static void main(String[] args) {
        Card c = new Card("Lorem Ipsum", 1);
        System.out.println(c.show());
    }

}
