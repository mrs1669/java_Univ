package moji0;
/**
 * しりとりプレイヤーの基本機能クラス
 * @author b1018104 Takumi Muraishi
 * 
 */

import java.io.*;
import java.net.URL;
import java.util.*;

public class Player {
	
	// TODO ここにTangoクラスのオブジェクトを格納するTreeSetを，dicwordという名前でprotectedで宣言
	protected TreeSet<Tango> dicword;
	protected int score;
	protected String name;
	protected String book;
	
	public Player(String name, String site) {
		this.name = name;
		this.score = 0;
		this.dicword = new TreeSet<>();

		System.out.print(name + "が読込中... ");
			
		try {
			BufferedReader br = null;
			URL url = new URL(site);
			InputStream is = url.openStream();
			InputStreamReader isr = new InputStreamReader(is, "SJIS");
			br = new BufferedReader(isr);
			String str;
			
			while ((str = br.readLine()) != null) {
				// read a title
				if(str.contains("<title>")) { // TODO <title>が含まれている行を抽出
					// TODO 先頭から任意の文字列で<title>までを削除し，</title>から任意の文字列で末尾までを削除
					book = str.replaceAll("^.<title>", "").replaceAll("</title>.*$", ""); 
				}
				String[] s = str.split("</ruby>"); // </ruby>で区切ってsに格納
				
				for(int i = 0; i < s.length; ++i)
					if(s[i].contains("<rt>")) { //TODO <rt>が含まれている文字列を抽出
						String s2 = s[i];
						s2 = s2.replaceAll("<rp>.</rp>", ""); // TODO <rp>任意1字</rp>で囲まれる部分を削除
						s2 = s2.replaceAll("^.*<rb>", ""); // TODO 先頭から任意文字列<rb>までの部分を削除
						s2 = s2.replaceAll("</rt>",""); // </rt>を削除
						s2 = s2.replaceAll("<img.*/>", ""); // TODO <img 任意文字列 />の部分を削除
						s2 = s2.replaceAll("</rt>",""); // </rt>を削除
						String[] s3 = s2.split("</rb><rt>"); // </rb><rt>で区切る，s3[0]は漢字，s3[1]はかな
						if(s3[1].length()>1) {
							// TODO ここにdicword（辞典）にs3[0]とs3[1]を漢字かなとするTangoオブジェクトを生成して追加
							dicword.add(new Tango(s3[0], s3[1]));
						}
					}
			}
			br.close();
			System.out.println("図書名：" + book);
		}
		catch (IOException e) {
			System.out.println("URL read error.");
		}
	}
	
	public String say() {
		return "";
	}
	
	public String getName() {
		return name;
	}
	
	public int getScore() {
		return score;
	}
	
	public void addScore(int score) {
		this.score = this.score + score;
	}
	
	public Tango followTango(String word) {
		return null;
	}
	
	public String getBook() {
		return book;
	}
	
	// テスト用のメイン
	public static void main(String[] args) {
		int count = 0;
		Player rdr = new Player(
				"テストユーザ", 
				"http://mrs1669.html.xdomain.jp/aozora.html"); // 
		for(Tango t: rdr.dicword) {
			System.out.println(t);
			++count;
		}
		System.out.println("トータル単語数：" + count);
	}

}
