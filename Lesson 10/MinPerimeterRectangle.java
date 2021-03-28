import java.util.ArrayList;
import java.util.List;

/*

An integer N is given, representing the area of some rectangle.

The area of a rectangle whose sides are of length A and B is A * B, and the perimeter is 2 * (A + B).

The goal is to find the minimal perimeter of any rectangle whose area equals N. The sides of this rectangle should be only integers.

For example, given integer N = 30, rectangles of area 30 are:

(1, 30), with a perimeter of 62,
(2, 15), with a perimeter of 34,
(3, 10), with a perimeter of 26,
(5, 6), with a perimeter of 22.
Write a function:

class Solution { public int solution(int N); }

that, given an integer N, returns the minimal perimeter of any rectangle whose area is exactly equal to N.

For example, given an integer N = 30, the function should return 22, as explained above.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [1..1,000,000,000].
Copyright 2009–2021 by Codility Limited. All Rights Reserved. Unauthorized copying, publication or disclosure prohibited.

https://app.codility.com/programmers/lessons/10-prime_and_composite_numbers/min_perimeter_rectangle/
 */

public class MinPerimeterRectangle {

    public int solution(int N) {
        List<Integer> factors = factors(N);
        int minPerimeter = Integer.MAX_VALUE;
        int size = factors.size();
        for (int i=0; i<size; i++){
            for (int j=0; j<size; j++ ){
                int length = factors.get(i);
                int width = factors.get(j);
                int area = length * width;
                if (area== N){
                    int currentPerimeter = 2 *(length + width);
                   if ( currentPerimeter < minPerimeter){
                       minPerimeter = currentPerimeter;
                   }

                }
            }
        }
        
	return minPerimeter;
	}
    
	private List<Integer> factors(int n) {
        List<Integer> factors = new ArrayList<Integer>();
        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                factors.add(i);
                if (n/i != i)
                    factors.add(n/i);
            }
        }
        
	return factors;
    }
    public static void main(String args[]){
        MinPerimeterRectangle obj = new MinPerimeterRectangle();
        int minPerimeter = obj.solution(30);
        System.out.println(minPerimeter);
    }
}
