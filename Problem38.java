package problem38;

import java.util.ArrayList;

/**
 *
 * @author Christopher Von Hoene
 */
public class Problem38 {

    public static void main(String[] args) {
        
        int max = 0;
        String current;
        
        for (int num = 1; num < 10000; num++) {
            
            current = "";
            for (int i = 1; ; i++) {
                int temp = i * num;
                current = current + temp;
                if (current.length() == 9) {
                    int possible = Integer.parseInt(current);
                    if (isPandigital(possible) && possible > max) {
                        max = possible;
                        System.out.println("Possible: " + max + "(" + num + ")");
                    }
                    break;
                } else if (current.length() > 9) break;
            }            
        }
        
        System.out.println("Answer: " + max);
        
    }
    
    public static boolean isPandigital(int in) {
        if ((in + "").length() != 9) return false;
        ArrayList<Integer> digits = new ArrayList();
        for (; in > 0; in = in/10) {
            int digit = in % 10;
            if (digit == 0) return false;
            if (digits.contains(digit)) return false;
            digits.add(digit);
        }
        if (digits.size() == 9) return true;
        return false;
    }
    
}
