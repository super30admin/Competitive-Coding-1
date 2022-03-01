// Time Complexity : O(n*W)
// Space Complexity : O(n*W)
class Knapsack {
    static int knapSack(int W, int weight[], int val[], int n) {
        int K[][] = new int[n+1][W+1];
        
        for(int i=0; i<=n; i++) {
            for(int w=0; w<=W; w++) {
                if(i==0 || w==0)
                    K[i][w] = 0;
                else if(w < weight[i-1])
                    K[i][w] = K[i-1][w];
                else
                     K[i][w] = Math.max(val[i-1] + K[i-1][w-weight[i-1]], K[i-1][w]);
                
            }
        }
        return K[n][W];
    }
    
    public static void main(String args[])
    {
        int val[] = new int[] { 60, 100, 120 };
        int wt[] = new int[] { 10, 20, 30 };
        int W = 50;
        int n = val.length;
        System.out.println(knapSack(W, wt, val, n));
    }
}