package by.inte.ok;

import java.lang.Math;

/**
 * Created by DK on 1/28/2018.
 */

public class Generate {
    int a;
    int b;
    int c;
    Generate g;


    public Generate generateRandom () {
        int sum = 0;
         a = mRandom();
         b = mRandomSign();
         while( ((a+b) < 0)||((a+b)>100) ) {
            b = mRandomSign();
         }
         c = mRandomSign();
         while( ((a+b+c) < 0)||((a+b+c)>100) ) {
             c = mRandomSign();
         }
         return g;
    }

    public int getSum() {
        return a + b + c;
    }

    @Override
    public String toString() {
        String s = String.format("%d%+d%+d", a, b, c);
        return s;
    }

    private int mRandom() {
        return (int)(Math.random()*100);
    }

    private int mRandomSign() {
        return (int)(Math.random()*200 - 100);
    }

}
