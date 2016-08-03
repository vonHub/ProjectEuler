/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package problem41;

import java.util.ArrayList;

/**
 *
 * @author Christopher Von Hoene
 * This is not a very good solution. It's too inefficient to build a list
 * of all primes in the answer space in a reasonable amount of time. However,
 * the last pandigital prime it generates in the first 1% of the answer space
 * (e.g. 7-digit numbers) happens to be the answer, so it worked, I guess.
 */
public class Problem41 {
    
    static ArrayList<Integer> primes = new ArrayList();
    
    public static void main(String[] args) {
        primes.add(2);
        int max = 2143;
        for (int p = 3; p < 10000000; p += 2) {
            boolean prime = true;
            for (int index = 0; primes.get(index) <= Math.sqrt(p); index++) {
                if (p % primes.get(index) == 0) {
                    prime = false;
                    break;
                }
            }
            if (prime) {
                primes.add(p);
                if (p > max && isPandigital(p)) {
                    max = p;
                    System.out.println(p);
                }
            }
        }
        System.out.println("Answer: " + max);
    }
    
    public static boolean isPandigital(int in) {
        String num = "" + in;
        for (int digit = 1; digit <= num.length(); digit++) {
            if (!num.contains("" + digit)) {
                return false;
            }
        }
        return true;
    }
    
}
