package card;

/**
 * 
 * @author b1018104 Takumi Muraishi
 *
 */

import java.util.*;


public class PointManager {
	
	private ArrayList<PointCard> cards;
	
	PointManager(){
		this.cards = new ArrayList<PointCard>();
	}

	public void addMember(String name) {
		int id = 0;
		if(cards.size()==0) {
			id = 1;
		}else{
			id = cards.get(cards.size()-1).getId() + 1;
		}
		cards.add(new PointCard(name, id));
	}	

	public boolean delMember(String name) {
		int id = 0;
		for(PointCard i: cards) {
			if(name == i.getName()) {
				id = i.getId();
				cards.remove(id-1);
				return true;
			}
		}
		return false;
	}
	
	PointCard i = new PointCard("name",1);
		
		
	public String showAll() {
		String temp = "";
		for(PointCard i: cards) {
			temp += i.show() + System.getProperty("line.separator");
		}
		return temp;
	}
	
	public boolean setPoint(String name, int point) {
		int id=0;
		for(PointCard i: cards) {
			if(name == i.getName()) {
				cards.get(id).setPoint(point);
				return true;
			}
			id++;
		}
		return false;
	}

    public static void main(String[] args) {
        PointManager m = new PointManager();
        m.addMember("Lorem Ipsum");
        m.addMember("Dolor Sit");
        m.addMember("Amet Consectetuer");
        m.addMember("Adipiscing Elit");
        System.out.print(m.showAll());
        System.out.println("--------------");

        m.delMember("Amet Consectetuer");
        m.setPoint("Dolor Sit",2);
        System.out.print(m.showAll());
        System.out.println("--------------");

        m.setPoint("Adipiscing Elit",3);
        System.out.print(m.showAll());
        System.out.println("--------------");       
    }
	
}

