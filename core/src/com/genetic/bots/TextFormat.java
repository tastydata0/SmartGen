package com.genetic.bots;

import java.util.Map;
import java.util.NavigableMap;

public class TextFormat {

    private static char[] c = new char[]{'K', 'M', 'B', 'T'};

    /**
     * Recursive implementation, invokes itself for each factor of a thousand, increasing the class on each invokation.
     * @param n the number to format
     * @return a String representing the number n formatted in a cool looking way.
     */
    public static String coolFormat(long n) {
        if(n>=1000000000) {
            return n/1000000000+"."+((n%1000000000)+"").charAt(0)+c[2];
        }
        else if(n>=1000000) {
            return n/1000000+"."+((n%1000000)+"").charAt(0)+c[1];
        }
        else if(n>=1000) {
            return n/1000+"."+((n%1000)+"").charAt(0)+c[0];
        }
        else {
            return n+"";
        }
    }
}
