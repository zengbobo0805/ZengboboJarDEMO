package diffutilrecyclerview.javademo.math;

import java.util.Calendar;

/**
 * Created by bobo on 2017/3/21.
 */

public class MathTest {
    public static void main(String[] args) throws Exception {
        System.out.println("Math.asin(0.5) = "+Math.asin(0.5)*180/3.14);
        System.out.println("Math.asin(1) = "+Math.asin(1)*180/3.14);
        Calendar ca = Calendar.getInstance();
        ca.set(2017,2,22,23,59,59);
        System.out.println("MathTest 1:"+ca.getTimeInMillis());
        ca.set(2017,1,22,0,0,0);
        System.out.println("MathTest 2:"+ca.getTimeInMillis());
    }
}
