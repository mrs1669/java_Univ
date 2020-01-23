package battle0;

import java.util.*;

/**
 * 
 * @author b10xxxxx Your Name
 *
 */
public class Manager {

	// 定数
	public static int moveCost = 1;	// MOVEで消耗するライフ値
	public static int stayRecover = 2; // STAYで回復するライフ値
	public static int maxLife = 10; // ライフの最大値
	public static int attackCost = 2; // ATTACKを選んだときに消耗するライフ値
	public static int attackDamage = 2; // ATTACKで相手から奪うライフ値
	
	// メンバ変数
	private static ArrayList<Player> players;
	private Board brd;
	private int x_size, y_size;
	private Random rnd;
	
	public Manager(int x_size, int y_size) {
		this.rnd = new Random(1);
		this.x_size = x_size;
		this.y_size = y_size;
		players = new ArrayList<>();
		brd = new Board(x_size, y_size);
		
		// playerを追加する
		for(int i = 0; i < 10; ++i)
			players.add
			(new Player("ABCDEFGHIJKLMN".substring(i%12, i%12+3), i));
		players.add(new Player8104("JAL", 8104));
//		players.add(new Player("ABC", 123));
//		players.add(new Player("CDE", 456));
//		players.add(new Player("EFG", 789));
//		players.add(new Player00("ZZZ", 18999));
	}

	public static void main(String[] args) {
		


		int x_size = 8;
		int y_size = 5;

		Manager m = new Manager(x_size, y_size);
		
		// プレイヤーを重ならないようにランダムにゲーム盤に配置する
		for(Player p: players) {
			boolean flag = false;
			while(!flag) {
				p.setX(m.rnd.nextInt(x_size));
				p.setY(m.rnd.nextInt(y_size));
				flag = m.brd.setPlayer(p);
			}
		}
		// ゲームサイクル
		int turn = 0;
		Scanner scan = new Scanner(System.in);
		

		do {
			// ターン表示
			System.out.println((++turn) + " ===========================");
			
			// 盤面表示
			System.out.println("###### player locations");
			m.brd.show(0);

			// プレイヤーに自分自身の近傍のマップデータを与える
			for(Player p: players) {
				String[] nameRadar = new String[9];
				int[] lifeRadar = new int[9];
				for(int dy = -1; dy < 2; ++dy)
					for(int dx = -1; dx < 2; ++dx) {
						int x = (p.getX() + dx + x_size) % x_size;
						int y = (p.getY() + dy + y_size) % y_size;
						nameRadar[(dx + 1) + (dy + 1)*3] = m.brd.getNameOnMap(x, y);
						lifeRadar[(dx + 1) + (dy + 1)*3] = m.brd.getLifeOnMap(x, y);
					}
				p.setNameRadar(nameRadar);
				p.setLifeRadar(lifeRadar);
			}
			
			// プレイヤーの意思決定
			// 1. 意思決定
			for(Player p: players) {
				p.decide();
			}
			
			System.out.print("continue=1 >");
			scan.next();
			
			// 意思決定結果の盤面表示
			System.out.println("###### player decisions");
			m.brd.show(2);
			
			System.out.print("continue=1 >");
			scan.next();
			
			// 2. Attackの実行
			for(Player p: players) {
				if(p.getCommand().equals("ATTACK")) {
					// 攻撃，近傍のプレイヤーに2だけダメージを与える．体力2消費．
					for(int d = 0; d < 9; ++d) {
						int x = ((d % 3) - 1 + p.getX() + x_size) % x_size;
						int y = ((d / 3) - 1 + p.getY() + y_size) % y_size;
						Player q = m.brd.getPlayer(x, y);
						if(d != 4 && q != null) {
							q.addLife(-attackDamage);
							q.addAttacked();
							//System.out.println(q.getName() + " attacked by " + p.getName() + "!");
						}
					}
					p.addLife(-attackCost);
				}
			}
//			System.out.println("1 to continue>");
//			scan.next();
			
			// 2.5 被弾者の表示
			System.out.println("###### attack report ");
			m.brd.show(1);
			
			System.out.print("continue=1 >");
			scan.next();
			
			// ライフの表示盤面表示
			System.out.println("###### life report");
			m.brd.show(3);
			
			// 3. 移動処理
			for(Player p: players) {
				switch(p.getCommand()) {
				case "STAY": // 体力回復．1ターンに2だけ回復させる
					p.addLife(stayRecover);
					break;
				case "MOVE": // 移動, optionの方向（0－8）に進めたら進む．体力1消費．
					m.brd.movePlayer(p.getOption(), p);
					p.addLife(-moveCost);
					break;					
				default: // 上記2つ意外はなにもしない
				}
			}
			
			// プレイヤーの生死判定と削除
			ArrayList<Player> dellist = new ArrayList<>();
			for(Player p: players) {
				if(p.getLife() < 0) {
					System.out.println("Player "+p.getName()+" dead.");
					m.brd.removePlayer(p);
					dellist.add(p);
				}
			}
			players.removeAll(dellist);
			
			System.out.print("end of turn " + turn +". continue=1, quit=q >");
		} while(!scan.next().equals("q"));
		
		System.out.println("game end");
	}

}
