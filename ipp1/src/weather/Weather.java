package weather;

import java.util.*;
import java.io.*;
import java.net.*;


/**
 * @author b1018104 Takumi Muraishi
 *
 */

public class Weather {
	private ArrayList<Integer> anum;
	private ArrayList<String> area;
	private ArrayList<String> name;
	private ArrayList<Double> data;
	private int datasize;

	public Weather(String site) {
		anum = new ArrayList<Integer>();
		area = new ArrayList<String>();
		name = new ArrayList<String>();
		data = new ArrayList<Double>();
		try {
			URL url = new URL(site);
			InputStream is = url.openStream();
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
			
		} catch (IOException e) {
			System.out.println("URL not found.");
		}
	}
	public String show(int i) {
		String sh = String.valueOf(getArea(i)) + ", " + 
					String.valueOf(getName(i)) + ", " +
					String.valueOf(getData(i));
	    return sh;
	}

	public int getAnum(int i) {
		return  anum.get(i);
	}
	public String getArea(int i) {
		return area.get(i);
	}
	public String getName(int i) {
		return name.get(i);
	}
	public double getData(int i) {
		return data.get(i);
	}
	public int getDataSize() {
		return datasize;
	}
	public static void main(String[] args) {
		Weather temp = new Weather
                ("http://www.trace-info.net/IPP1/2018mintemp.csv");
		for (int i = 0; i < temp.getDataSize(); ++i) 
			System.out.println(temp.show(i));
	}

}
