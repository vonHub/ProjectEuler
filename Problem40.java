/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package problem40;

/**
 *
 * @author Christopher Von Hoene
 */
public class Problem40 {
    
    public static void main(String[] args) {
        int digit = 1;
        int num = 1;
        int answer = 1;
        String constant = "";
        while (digit <= 1000000) {
            constant += num;
            num++;
            while (constant.length() > 0) {
                if (Math.log10(digit) == (int)Math.log10(digit)) {
                    int val = Integer.parseInt(constant.substring(0, 1));
                    answer *= val;
                }
                constant = constant.substring(1);
                digit++;
            }
        }
        System.out.println("Answer: " + answer);
    }
    
}
