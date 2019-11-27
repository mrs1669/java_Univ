package townsim;

import townsim.Town;

/**
 * 
 * @author b1018104 Takumi Muraishi
 *
 */

public class SimMain1 {
    private Town t1, t2, t3;

    SimMain1 () {
        // TODO: t1, t2, t3を函館，札幌，京都の情報でインスタンス生成しなさい
    	this.t1 = new Town (20.0, 53.7, "hakodate");
		this.t2 = new Town (200.0, 52.9, "sapporo");
		this.t3 = new Town (140.0, 51.0, "kyoto");
    }

  public String calc () {
        // 仮にt1の流入流出をそれぞれ0.011, 0.005とする
        t1.setIn(0.011);
        t1.setOut(0.005);

        // t1の新しい人口をupdateを呼んで更新する
        t1.update();

        // t1,t2,t3の情報を文字列で返す
        return 
                t1.disp() + ", " + t2.disp() + ", " + t3.disp();
    }

    public static void main(String[] args) {
        SimMain1 m = new SimMain1();
        System.out.println (m.calc());
    }
}