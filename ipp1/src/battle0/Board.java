package battle0;
/**
 * 
 * @author b10xxxxx Your Name
 *
 */
public class Board {

	Player[][] map;
	int x_size, y_size;
	
	// コンストラクタ
	public Board(int x_size, int y_size) {
		map = new Player[x_size][y_size];
		this.x_size = x_size;
		this.y_size = y_size;
		clear();
	}
	
	public void clear() {
		for(int x = 0; x < x_size; ++x)
			for(int y = 0; y < y_size; ++y)
				map[x][y] = null;
	}
	
	public boolean 	movePlayer(int direction, Player p) {
		int dx = direction % 3 - 1;
		int dy = direction / 3 - 1;
		int x = (p.getX() + dx + x_size) % x_size;
		int y = (p.getY() + dy + y_size) % y_size;
		if( map[x][y] == null ) {
			// move success
			map[p.getX()][p.getY()] = null;
			map[x][y] = p;
			p.setX(x);
			p.setY(y);
			return true;
		} 
		else {
			// move failure
			return false;
		}
	}
	
	public void removePlayer(Player p) {
		map[p.getX()][p.getY()] = null;
	}
	
	public boolean setPlayer(Player p) {
		if(map[p.getX()][p.getY()] == null) {
			// success
			map[p.getX()][p.getY()] = p;
			return true;
		}
		else {
			return false;
		}
	}
	
	public String getNameOnMap(int x, int y) {
		Player p = map[x][y];
		if(p != null) 	return p.getName();
		else			return "";
	}
	
	public int getLifeOnMap(int x, int y) {
		Player p = map[x][y];
		if(p != null)	return p.getLife();
		else			return 0;
	}
	
	public Player getPlayer(int x, int y) {
		return map[x][y];
	}
	
	public void show(int mode) {
		// mode=0 -> 通常マップ出力
		// mode=1 -> 被弾者を区別して出力
		// mode=2 -> 通常マップ＋行動表示
		// mode=3 -> ライフマップ
		for(int y = 0; y < y_size; ++y) {
			String line1 = "";
			String line2 = "";
			for(int x = 0; x < x_size; ++x) {
				Player p = map[x][y];
				if(p == null) {
					line1 = line1 + " ---";
					line2 = line2 + " ---";
				}
				else {
					line1 = line1 + " "
						+ p.getName().substring(0, 3);
					String cmdlabel = p.getCommand().substring(0,1);
					String lifelabel = (String.format("%02d", p.getLife()));
					
					switch(mode) {
					case 0: // 場所マップ
						cmdlabel = ".";
						//lifelabel = "...";
						break;
					case 1: // 被攻撃マップ
						if(p.getAttacked() != 0) {
							cmdlabel = "XX";
							lifelabel = String.format("%1d", p.getAttacked());
							p.clearAttacked();
						}
						else lifelabel ="..";
						break;
					case 2: // コマンドマップ
						lifelabel ="..";
						if(p.getCommand().equals("MOVE"))
								lifelabel = p.getOption() + " "; 
						break;
					case 3: // ライフマップ
						cmdlabel = ".";
						break;
					default:
					}
					line2 = line2 + " " + cmdlabel + lifelabel;
				}
			}
			System.out.println(line1);
			System.out.println(line2);
			System.out.println();
		}
	}
	
}
