/**
 * 
 */
package seq;

/**
 * @author b1018104 Takumi Muraishi
 *
 */
public class Sequence {
	static int am1,am2,a_n;
	public static int value(int x, int n) {
		if(n == 0) {
			am1 = 0;
			am2 = 0;
			a_n = 0;
		}else if(n == 1){
			am1 = 0;
			am2 = 0;
			a_n = x;
		}else{
			value(x,n-1);
			am1=am2;
			am2=a_n;
			a_n = am1+am2;
		}
		return a_n;
	}

		public static void main(String[] args) {
		for (int i = 0; i < 44; i++) {
		System.out.print(value(3, i));
		System.out.print(" ");
		}
		System.out.println("");
		}
}
