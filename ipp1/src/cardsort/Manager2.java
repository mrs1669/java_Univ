package cardsort;

/**
 * 
 * @author b1018104 Takumi Muraishi
 *
 */

import java.util.*;


public class Manager2 {
	
	private ArrayList<ShopCard2> cards;
	
	Manager2(){
		this.cards = new ArrayList<ShopCard2>();
	}

	public void addMember(String name, String grade, int age) {
		int id = 0;
		if(cards.size()==0) {
			id = 1;
		}else{
			id = cards.get(cards.size()-1).getId() + 1;
		}
		cards.add(new ShopCard2(name, id, grade, age));
	}	

	public boolean delMember(String name) {
		int id = 0;
		for(ShopCard2 i: cards) {
			if(name == i.getName()) {
				id = i.getId();
				cards.remove(id-1);
				return true;
			}
		}
		return false;
	}
	
	public void sortAll() {
		Collections.sort(cards);
	}
	
	ShopCard2 i = new ShopCard2("name",1,"",0);	
		
	public String showAll() {
		String temp = "";
		for(ShopCard2 i: cards) {
			temp += i.show() + System.getProperty("line.separator");
		}
		return temp;
	}
					
    public static void main(String[] args) {
        Manager2 m = new Manager2();
        m.addMember("Lorem Ipsum","Gold",60);
        m.addMember("Dolor Sit","Bronze",56);
        m.addMember("Amet Consectetuer ","Gold",30);
        m.addMember("Adipiscing Elit","Silver",40);
        m.addMember("Maecenas Porttitor","Gold",35);
        m.addMember("Congue Massa","Silver",70);
        m.addMember("Fusce Posuere","Gold",58);
        m.addMember("Magna Sed","Silver",25);
        m.addMember("Pulvinar Ultricies","Bronze",22);
        m.addMember("Purus Lectus","Bronze",55);
        m.addMember("Malesuada Libero","Silver",56);
        m.addMember("Sit Amet","Bronze",36);
        System.out.print(m.showAll());
        System.out.println("--------------");

        m.sortAll();
        System.out.println(m.showAll());
    }
	
}

