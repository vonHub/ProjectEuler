/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package problem45;

import java.util.ArrayList;

/**
 *
 * @author Christopher Von Hoene
 * Brute force solution is too slow to work with normal integers. There
 * has to be a more clever approach. What am I missing?
 */
public class Problem45 {
    
    public static void main(String[] args) {
        int t = 1;
        int p = 1;
        int h = 1;
        int tn = 1;
        int pn = 1;
        int hn = 1;
        int answer = 0;
        while (true) {
            if (t <= p && t <= h) {
                tn++;
                t = getTriangularNumber(tn);
            } else if (p <= t && p <= h) {
                pn++;
                p = getPentagonalNumber(pn);
            } else {
                hn++;
                h = getHexagonalNumber(hn);
            }
            if (t == p && p == h && t > 40755) {
                answer = t;
                break;
            }
        }
        System.out.println(answer);
    }
    
    public static int getHexagonalNumber(int in) {
        return in * (2*in - 1);
    }
    
    public static int getTriangularNumber(int in) {
        return (in * (in + 1)) / 2;
    }
    
    public static int getPentagonalNumber(int in) {
        return (in * (3*in - 1)) / 2;
    }
    
}
