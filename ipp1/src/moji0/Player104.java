package moji0;

/**
 * しりとりプレイヤーサンプル
 * @author b1018104 Takumi Muraishi
 * 
 */

public class Player104 extends Player {

	// TODO 自分でつけた任意のチーム名，青空文庫のURLを設定してください．以下の例に上書きしてください．
	private static String name = "「ぷ」責めのニャルラトホテプ";
	private static String url = "http://mrs1669.html.xdomain.jp/aozora.html"; // 参照URLの改変を行いました
	
	
	// TODO コンストラクタもクラス名に直すのをわすれずに
	public Player104() {
		super(name, url);
	}

	// TODO ここを自分のアルゴリズムに書き換えてください
	public Tango followTango(String word) {
		//　単語を自分の辞書から取る部分のサンプル
		for(Tango t: super.dicword) {
			if(word.charAt(word.length()-1) == t.kana.charAt(0)) {
				return t;
			}
		}
		// 文字が見つからないときには必ずnullを返すこと
		return null;
	}
	
	// TODO 文字決定後に出力されるメッセージです．自由に書いてください．文字決定の結果を反映させると良いです．
	public String say() {
		return "メッセージ";
	}
	
	// テスト用メイン．五十音の1文字に対して続く語がきちんと選択されているかをチェック
	public static void main(String[] args) {
		Player104 player = new Player104();
		String test = 
		"あいうえおかきくけこさしすせそたちつてとなにぬねのはひふへほまみむめもやゆよらりるれろわをんがぎぐげござじずぜそだぢづでどばびぶべぼぱぴぷぺぽ";
		for(int i = 0; i < test.length(); ++i)
			System.out.println(test.charAt(i) + "　→　" +
					player.followTango(test.substring(i, i+1)));
	}
}
