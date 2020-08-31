

// TC: O(
public class KnapSack {
	
	public int Knapsack(int[] values, int[] weight, int maxW) {
		
		int[][] dp = new int[values.length+1][maxW+1];
		
		for(int i=0;i<=values.length;i++)
			dp[i][0] =0;
		
		for(int i=0;i<=maxW;i++)
			dp[0][i] = 0;
		
		for(int i=1;i<=values.length;i++) {
			
			for(int j=1;j<=maxW;j++) {
				
				if(j-weight[i-1]>=0) {
					dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-weight[i-1]]+values[i-1]); // maximum of either previous above value or (sum of present and previous value 
					//where the previous value has different of weights of greater than 0;
					
				}else {
					dp[i][j] = dp[i-1][j];
				}
			}
		}
		return dp[values.length][maxW];
		
		
	}
	
	public static void main(String[] args) {
		
		KnapSack ks = new KnapSack();
		int[] values = {60, 100, 120};
		int[] weight = {10, 20, 30};
		int MaxWeight = 50;
		
		System.out.println(ks.Knapsack(values, weight, MaxWeight));
	}

}
