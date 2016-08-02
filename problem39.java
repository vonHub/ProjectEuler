package problem39;

/**
 *
 * @author Christopher Von Hoene
 */
public class problem39 {
    
    public static void main(String[] args) {
        //Generate all right triangles of p <= 1000
        //Record perimeter
        //Choose perimeter that occurs most often
        int maxSolutions = 0;
        int bestPerimeter = 0;
        int[] perimeters = new int[1000];
        for (int a = 1; a <= 1000; a++) {
            for (int b = 1; b <= a; b++) {
                double c = Math.sqrt(a*a + b*b);
                if (c != (int)c) continue;
                int perimeter = a + b + (int)c;
                if (perimeter > 1000) break;
                perimeters[perimeter - 1]++;
                if (perimeters[perimeter - 1] > maxSolutions) {
                    maxSolutions++;
                    bestPerimeter = perimeter;
                }
            }
        }
        System.out.println("Best perimeter: " + bestPerimeter);
        System.out.println("Solutions: " + maxSolutions);
    }
    
}
