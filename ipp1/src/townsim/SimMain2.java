package townsim;

import townsim.Town;

/**
 * 
 * @author b1018104 Takumi Muraishi
 *
 */

public class SimMain2 {
    private Town t1, t2, t3;

    SimMain2 () {
        // TODO: t1, t2, t3を函館，札幌，京都の情報でインスタンス生成しなさい
    	this.t1 = new Town (20.0, 53.7, "hakodate");
		this.t2 = new Town (200.0, 52.9, "sapporo");
		this.t3 = new Town (140.0, 51.0, "kyoto");
    }

    public String calc () {
        // 仮にt1の流入流出をそれぞれ0.011, 0.005とする
        t1.setIn(t2.getP()*t1.getAttract()/1000+t3.getP()*t1.getAttract()/1000);
        t2.setIn(t1.getP()*t2.getAttract()/1000+t3.getP()*t2.getAttract()/1000);
        t3.setIn(t1.getP()*t3.getAttract()/1000+t2.getP()*t3.getAttract()/1000);
        
        t1.setOut(t1.getP()*t2.getAttract()/1000+t1.getP()*t3.getAttract()/1000);
        t2.setOut(t2.getP()*t1.getAttract()/1000+t2.getP()*t3.getAttract()/1000);
        t3.setOut(t3.getP()*t1.getAttract()/1000+t3.getP()*t2.getAttract()/1000);
        

        // t1の新しい人口をupdateを呼んで更新する
        t1.update();
        t2.update();
        t3.update();
        

        // t1,t2,t3の情報を文字列で返す
        return 
                t1.disp() + ", " + t2.disp() + ", " + t3.disp();
    }

    public static void main(String[] args) {
    	int i = 100;
        SimMain2 m = new SimMain2();
        while(i > 0) {
        	System.out.println (m.calc());
        	i--;
        }
    }
}