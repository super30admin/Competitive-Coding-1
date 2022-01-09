//Time complexity-O(n) 2 pass solution
//Space Compexity-O(1)
class GFG {
    static int findMissingNumber(int [] num)
    {
        for(int i=0;i<num.length;i++){
            if(num[i]-1>=0 && num[i]-1<num.length+2){
                num[num[i]-1]=-num[num[i]-1];
            }
            
        }
        for(int i=0;i<num.length;i++){
            if(num[i]>0)
            return i+1;
        }
        return -1;
    }
	public static void main (String[] args) {
	    int [] num= {1, 2, 3, 5, 6, 7, 8};
	    System.out.println("The missing number is "+findMissingNumber(num));
	    
	}
}