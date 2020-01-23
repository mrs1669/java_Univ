package weather;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

/**
 * @author b1018104 Takumi Muraishi
 *
 */

public class WeatherMain {
	
	private ArrayList<Integer> anum;
	private ArrayList<String> area;
	private ArrayList<String> name;
	private ArrayList<Double> data;
	private int datasize;
	
	public WeatherMain (String maxURL, String minURL) {
//        ２つのWeatherインスタンスを用意
//        もしWeatherインスタンスのどちらかでも「データの個数」が0であれば，なにもせずにそのままreturn;で終了する．
//        最高気温の最大をもつ地区を探しながら，全地区平均も集計する
//        最低気温の最小をもつ地区を探しながら，全地区平均も集計する
		
		anum = new ArrayList<Integer>();
		area = new ArrayList<String>();
		name = new ArrayList<String>();
		data = new ArrayList<Double>();
		try {
			URL maxurl = new URL(maxURL);
			InputStream is = maxurl.openStream();
			InputStreamReader isr = new InputStreamReader(is, "SJIS");
			BufferedReader br = new BufferedReader(isr);
			String line = null;
			String[] word= {};
			br.readLine();
			datasize=0;
			while((line = br.readLine()) != null) {
				word = line.split(",",-1);
				if(word[10]!=null) {
					if(Integer.parseInt(word[10])>=4) {
						anum.add(Integer.valueOf(word[0]));
						area.add(word[1]);
						name.add(word[2]);
						data.add(Double.valueOf(word[9]));
						datasize++;
					}
				}
			}
			br.close();
			
			URL minurl = new URL(minURL);
			InputStream minis = minurl.openStream();
			InputStreamReader minisr = new InputStreamReader(minis, "SJIS");
			BufferedReader minbr = new BufferedReader(minisr);
			String minline = null;
			String[] minword= {};
			minbr.readLine();
			datasize=0;
			while((minline = minbr.readLine()) != null) {
				minword = minline.split(",",-1);
				if(minword[10]!=null) {
					if(Integer.parseInt(minword[10])>=4) {
						anum.add(Integer.valueOf(minword[0]));
						area.add(minword[1]);
						name.add(minword[2]);
						data.add(Double.valueOf(minword[9]));
						datasize++;
					}
				}
			}
			minbr.close();
			
			Weather maxTemp = new Weather(maxURL);
			Weather minTemp = new Weather(minURL);
			double max = -100;
			double min = 100;
			int maxi = 0;
			int mini = 0;
			double maxCount = 0;
			double minCount = 0;
			for (int i = 0; i < maxTemp.getDataSize(); ++i) {
				if(maxTemp.getData(i)>max) {
					max = maxTemp.getData(i);
					maxi = i;
				}
				maxCount += maxTemp.getData(i);
			}
			for (int i = 0; i < minTemp.getDataSize(); ++i) {
				if(minTemp.getData(i)<min) {
					min = minTemp.getData(i);
					mini = i;
				}
				minCount += minTemp.getData(i);
			}

  	System.out.println("LARGEST  MAX TEMP: " + maxTemp.show(maxi));
	System.out.println("SMALLEST MIN TEMP: " + minTemp.show(mini));
	System.out.println("AVERAGE  MAX TEMP: " + maxCount/maxTemp.getDataSize());
	System.out.println("AVERAGE  MIN TEMP: " + minCount/minTemp.getDataSize());
          }catch (IOException e) {
  			System.out.println("URL not found.\n" + 
  					"URL not found.");
  		}
	}

	public static void main(String[] args)  {
		WeatherMain w = new WeatherMain (
		"http://www.trace-info.net/IPP1/2018maxtemp.csv",
		"http://www.trace-info.net/IPP1/2018mintemp.csv");
	}

}
