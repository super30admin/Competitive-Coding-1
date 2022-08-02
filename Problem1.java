import java.util.*;
class Problem1 {
    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum = 0;
        int lastElement = 0;
        for (int i = 0; i < n; i++) {
            int in = sc.nextInt();
            if(i == n -1)
                lastElement = in;
            sum += in;
        }
        int actualSum = (lastElement * (lastElement + 1))/ 2;
        System.out.println("Output: " + (actualSum - sum));
    }
}