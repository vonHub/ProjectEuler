/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package problem44;

import java.util.ArrayList;

/**
 *
 * @author Christopher Von Hoene
 */
public class Problem44 {
    
    // Pn = n(3n - 1)/2
    static int range = 10000;
    // Strategy for tomorrow:
    // Build list of pent numbers.
    // Check adjacent pairs for pentagonal differences.
    // Check for pentagonal sums. If successful, done.
    // Then try adjacent + 1 pairs.
    // Repeat until success.
    
    public static void main(String[] args) {
        int d = 1000000;
        int x = 1;
        int px = 1;
        int py = 0;
        for (int y = 1; y <= range; y++) {
            py = getPentagonNumber(y);
            while (px < getPentagonNumber(y + 1) - py) {
                x++;
                px = getPentagonNumber(x);
            }
            int tempx = x;
            for (; x < y; x++) {
                px = getPentagonNumber(x);
                System.out.println(Math.abs(py - px));
                if (isPentagonal(px + py) && isPentagonal(Math.abs(px - py))) {
                    if (Math.abs(px - py) < d) d = Math.abs(px - py);
                    System.out.println("Success: " + px + ", " + py);
                }
            }
            x = tempx;
            px = getPentagonNumber(x);
        }
        
        System.out.println(d);
    }
    
    public static int getPentagonNumber(int in) {
        return (in * (3 * in - 1)) / 2;
    }
    
    public static boolean isPentagonal(int in) {
        double test = (Math.sqrt(24 * in + 1) + 1) / 6;
        return test == (int)test;
    }
    
    public static ArrayList<Integer> buildPentList(int lim) {
        ArrayList<Integer> pents = new ArrayList();
        int n = 1;
        int p;
        while ((p = getPentagonNumber(n)) < lim) {
            pents.add(p);
            n++;
        }
        return pents;
    }
    
    // Provide solutions for the quadratic formula
    public static ArrayList<Double> quadForm(double a, double b, double c) {
        ArrayList<Double> solutions = new ArrayList();
        double one = b*b - 4*a*c;
        if (one > 0) {
            double sol = (-1*b + Math.sqrt(one)) / (2*a);
            solutions.add(sol);
            sol = (-1*b - Math.sqrt(one)) / (2*a);
            solutions.add(sol);
        } else if (one == 0) {
            double sol = (-1*b + Math.sqrt(one)) / (2*a);
            solutions.add(sol);
        }
        return solutions;
    }
    
}
