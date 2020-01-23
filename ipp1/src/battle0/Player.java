package battle0;

import java.util.*;

/**
 * 
 * @author b1018104 Takumi Muraishi
 *
 */
public class Player {
	
	// メンバ変数
	protected Random rnd;
	protected int life;	// ライフ値
	protected int x, y;	// プレイヤーの位置
	protected int attacked;	// 1ターンで攻撃を受けた回数
	protected String name; // 名前
	protected String command; // 実行するコマンド名（STAY,ATTACK,MOVE)
	protected int option; // 実行するコマンドのオプション値（MOVEの移動方向）
	protected String[] nameRadar; // 9近傍の敵のマップ
	protected int[] lifeRadar; // 9近傍の敵のライフマップ
	
	// コンストラクタ
	public Player(String name, int seed) {
		this.rnd = new Random(seed);
		this.name = name;
		this.life = Manager.maxLife;
		this.attacked = 0;
		this.command = "STAY";
		this.option = 0;
	}
	
	// getters and setters
	public int getLife() {
		return life;
	}

	public void addLife(int increment) {
		this.life = Math.min(Manager.maxLife, this.life + increment);
	}

	public int getX() {
		return x;
	}
	
	public String getCommand() {
		return command;
	}
	
	public void setCommand(String command) {
		this.command = command;
	}
	
	public int getOption() {
		return option;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public String getName() {
		return name;
	}
	
	public void setNameRadar(String[] nameRadar) {
		this.nameRadar = nameRadar;
	}
	
	public void setLifeRadar(int[] lifeRadar) {
		this.lifeRadar = lifeRadar;
	}
	
	public void addAttacked() {
		this.attacked += 1;
	}
	
	public int getAttacked() {
		return this.attacked;
	}
	
	public void clearAttacked() {
		this.attacked = 0;
	}
	
	// デフォルトではランダムエージェント
	public String decide() {
		String[] cmd = {"MOVE","ATTACK","STAY"};
		command = cmd[rnd.nextInt(cmd.length)];
		option = rnd.nextInt(9);
		
		return command;
	}

	
}
