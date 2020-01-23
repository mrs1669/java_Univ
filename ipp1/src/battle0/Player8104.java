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

public class Player8104 extends Player {

	public Player8104(String name, int seed) {
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
		
		//command = cmd[rnd.nextInt(cmd.length)];
		//option = rnd.nextInt(9);
		
		command = cmd[2];
		
		
		
		if(nameRadar[0].isEmpty() && nameRadar[1].isEmpty() && nameRadar[2].isEmpty() && nameRadar[3].isEmpty() && nameRadar[5].isEmpty() && nameRadar[6].isEmpty() && nameRadar[7].isEmpty() && nameRadar[8].isEmpty()) {
			command = cmd[2];
		}
		
        int counts=0;
		
		if (nameRadar[0].isEmpty()) {
			counts++;
		}
		if (nameRadar[1].isEmpty()) {
			counts++;
		}
		if (nameRadar[2].isEmpty()) {
			counts++;
		}
		if (nameRadar[3].isEmpty()) {
			counts++;
		}
		if (nameRadar[5].isEmpty()) {
			counts++;
		}
		if (nameRadar[6].isEmpty()) {
			counts++;
		}
		if (nameRadar[7].isEmpty()) {
			counts++;
		}
		if (nameRadar[8].isEmpty()) {
			counts++;
		}
						
			
		if(counts == 5) {
			if (nameRadar[0].isEmpty() == false&&nameRadar[1].isEmpty() == false&&nameRadar[3].isEmpty() == false) {
				command = cmd[0];
				option = 8;
			}
			if (nameRadar[1].isEmpty() == false&&nameRadar[2].isEmpty() == false&&nameRadar[5].isEmpty() == false) {
				command = cmd[0];
				option = 6;
			}
			if (nameRadar[3].isEmpty() == false&&nameRadar[6].isEmpty() == false&&nameRadar[7].isEmpty() == false) {
				command = cmd[0];
				option = 2;
			}
			if (nameRadar[5].isEmpty() == false&&nameRadar[7].isEmpty() == false&&nameRadar[8].isEmpty() == false) {
				command = cmd[0];
				option = 0;
			}
			if (nameRadar[0].isEmpty() == false&&nameRadar[1].isEmpty() == false&&nameRadar[2].isEmpty() == false) {
				command = cmd[0];
				option = 7;
			}
			if (nameRadar[2].isEmpty() == false&&nameRadar[5].isEmpty() == false&&nameRadar[8].isEmpty() == false) {
				command = cmd[0];
				option = 3;
			}
			if (nameRadar[6].isEmpty() == false&&nameRadar[7].isEmpty() == false&&nameRadar[8].isEmpty() == false) {
				command = cmd[0];
				option = 1;
			}
			if (nameRadar[0].isEmpty() == false&&nameRadar[3].isEmpty() == false&&nameRadar[6].isEmpty() == false) {
				command = cmd[0];
				option = 5;
			}
			
		}



		return command;
	}

}
