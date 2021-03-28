import java.util.ArrayList;
import java.util.List;

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
