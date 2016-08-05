/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package problem43;

import java.math.BigInteger;
import java.util.ArrayList;

/**
 *
 * @author Christopher Von Hoene
 */
public class Problem43 {
    
    static ArrayList<String> pandigitals = new ArrayList();
    static BigInteger total = new BigInteger("0");
    static int[] primes = {2, 3, 5, 7, 11, 13, 17};
    
    public static void main(String[] args) {
        generatePermutations("", "0123456789");
        for (String p: pandigitals) processPermutation(p);
        System.out.println("Total: " + total);
    }
    
    public static void processPermutation(String in) {
        if (in.charAt(0) == '0') return;
        for (int p = 0; p < primes.length; p++) {
            int num = Integer.parseInt(in.substring(p+1, p+4));
            if (num % primes[p] != 0) return;
        }
        System.out.println(in);
        total = total.add(new BigInteger(in));
    }
    
    public static void generatePermutations(String prefix, String suffix) {
        int l = suffix.length();
        if (l == 0) pandigitals.add(prefix);
        else {
            for (int i = 0; i < l; i++) {
                generatePermutations(prefix + suffix.charAt(i), 
                        suffix.substring(0, i) + suffix.substring(i+1, l));
            }
        }
    }
    
}
