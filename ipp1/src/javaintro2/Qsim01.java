/**
 * @author b1018104 Takumi Muraishi
 */

package javaintro2;
import java.util.Random;

public class Qsim01 {

    static Random  rnd = new Random();
    int count_a;


    public Qsim01() {
        count_a = 0;
    }

    public int next_time(double rate) {
        return (int)(-rate * Math.log(rnd.nextDouble()));
    }

    public boolean arrive(double rate_a) {
        if(count_a == 0) {
        	count_a = next_time(rate_a);
        	return true;
        }else{
        	count_a -= 1;
        	return false;
        }
    }

    public static void main(String[] args) {
        Qsim01 qsim = new Qsim01();
        for(int i = 0; i < 50; ++i)
            System.out.println(qsim.count_a + ":" + qsim.arrive(10.0));
    }
}
