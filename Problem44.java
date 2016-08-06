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
    static int range = 0;
    
    public static void main(String[] args) {
        int d = range;
        for (int x = 1; x <= range; x++) {
            int px = getPentagonNumber(x);
            for (int y = 1; y <= range; y++) {
                int py = getPentagonNumber(y);
                if (isPentagonal(px + py) && isPentagonal(Math.abs(py-px))) {
                    if (Math.abs(px - py) < d) {
                        d = Math.abs(px - py);
                    }
                }
            }
        }
        System.out.println(getPentagonNumber(5));
    }
    
    public static int getPentagonNumber(int in) {
        return (in * (3 * in - 1)) / 2;
    }
    
    public static boolean isPentagonal(int in) {
        ArrayList<Double> solutions = quadForm(3, -1, -2*in);
        for (double s: solutions) {
            if (s > 0 && s == (int)s) {
                // Positive integer solution
                return true;
            }
        }
        return false;
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
