package battle0;
/**
 * 
 * @author b10xxxxx Your Name
 *
 * このクラスはPlayerクラスを継承して自分のプレイヤーを作成する例として示している
 * かならず自分の学生番号下位の数字を付けたクラスを作成して提出すること
 * このクラスは単なるサンプルであり，消してよい
 * 
 */
public class Player00 extends Player {

	public Player00(String name, int seed) {
		super(name, seed);	
	}
	
	// サンプル：ここに自分の意思決定アルゴリズムを記述
	public String decide() {
		// 利用可能なコマンド
		String[] cmd = {"MOVE","ATTACK","STAY"};
		
		// 意思決定のために参照する状態はスーパークラスの変数
		// （たとえば近傍の敵の有無を示すnameRadarなど）を利用すると良い
		// これらの状態から実行するコマンド名とオプション（移動コマンドのときの移動方向）を
		// 決定して，それぞれ command, optionに設定する．commandをreturnする．
		// 以下はランダム行動選択の例
		
		command = cmd[rnd.nextInt(cmd.length)];
		option = rnd.nextInt(9);

		return command;
	}

}
