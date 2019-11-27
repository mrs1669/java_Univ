package card;

/**
 * 
 * @author b1018104 Takumi Muraishi
 *
 */

import java.util.*;


public class PointManager {
	
	private ArrayList<Card> cards;
	
	PointManager(){
		this.cards = new ArrayList<Card>();
	}

	public void addMember(String name) {
		int id = 0;
		if(cards.size()==0) {
			id = 1;
		}else{
			id = cards.get(cards.size()-1).getId() + 1;
		}
		cards.add(new Card(name, id));
	}	

	public boolean delMember(String name) {
		int id = 0;
		for(Card i: cards) {
			if(name == i.getName()) {
				id = i.getId();
				cards.remove(id-1);
				return true;
			}
		}
		return false;
	}
	
	Card i = new Card("name",1);
		
		
	public String showAll() {
		String temp = "";
		for(Card i: cards) {
			temp += i.show() + System.getProperty("line.separator");
		}
		return temp;
	}
					
    public static void main(String[] args) {
        PointManager m = new PointManager();
        m.addMember("Lorem Ipsum");
        m.addMember("Dolor Sit");
        m.addMember("Amet Consectetuer");
        m.addMember("Adipiscing Elit");
        System.out.print(m.showAll());
        System.out.println("--------------");

        m.delMember("Dolor Sit");
        System.out.print(m.showAll());
        System.out.println("--------------");

        m.delMember("Lorem Ipsum");
        System.out.print(m.showAll());
        System.out.println("--------------");

        m.delMember("nobody");
        System.out.print(m.showAll());
        System.out.println("--------------");       
    }
	
}

