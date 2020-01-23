package moji0;

/**
 * しりとり用単語格納クラス
 * @author  b1018104 Takumi Muraishi
 * 
 */
public class Tango implements Comparable<Tango> {

	public String kanji;
	public String kana;
	
	public Tango(String kanji, String kana) {
		this.kanji = kanji;
		this.kana = kana;
	}
	
	public String getKanji() {
		return kanji;
	}
	
	public String getKana() {
		return kana;
	}

	@Override
	public int compareTo(Tango o) {
		// TODO Auto-generated method stub
		return this.kana.compareTo(o.getKana());
	}
	
	public String toString() {
		return "「" + kana + "（" + kanji + "）」";
	}
}
