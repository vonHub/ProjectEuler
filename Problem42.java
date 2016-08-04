/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package problem42;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * @author Christopher Von Hoene
 */
public class Problem42 {
    
    static ArrayList<String> words = new ArrayList();
    
    public static void main(String[] args) {
        try {
            Scanner reader = new Scanner(new File("p042_words.txt"));
            reader.useDelimiter("\"");
            while (reader.hasNext()) {
                String next = reader.next();
                if (!next.equals(",")) words.add(next);
            }
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
        int triangles = 0;
        for (String word: words) {
            if (isTriangleWord(word)) triangles++;
        }
        System.out.println("Triangle words: " + triangles);
    }
    
    // Triangle integer Tn = (1/2)(n)(n+1)  {1, 3, 6, 10...}
    // To to test if x is a triangle integer we solve
    // 0 = n^2 + n - 2x for n
    // and check if one of the solutions is a positive integer
    public static boolean isTriangleWord(String in) {
        int value = getWordValue(in);
        ArrayList<Double> solutions = quadForm(1, 1, -2 * value);
        for (double s: solutions) {
            if (s > 0 && s == (int)s) {
                // Positive integer solution exists
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
    
    // Get the 'value' of a word
    // 'A' = 1, 'B' = 2, etc.
    public static int getWordValue(String in) {
        int total = 0;
        for (int index = 0; index < in.length(); index++) {
            char c = in.charAt(index);
            total += c - 'A' + 1;
        }
        return total;
    }
    
}