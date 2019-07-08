
class Solution {
	
	public static int find(int[] arr)
	{
		int mid,start=0,end=arr.length-1;
		boolean flag = true;
		while(start<=end)
		{
			mid=start+(end-start)/2;
			//System.out.print(mid);
			if(!check(arr,mid)) {return arr[mid]+1;}
			if(arr[mid]!=mid+1) {end=mid-1;}
			else {start=mid+1;}
		}
		return -1;

	}
	public static boolean check(int[] arr, int pos)
	{
		if((pos==arr.length-1 || arr[pos+1]-arr[pos]==1) && (arr[pos]-arr[pos-1]==1	|| pos==0))return true;
		return false;
	}
    public static void main(String args[]) 
    { 
    	int[] arr = {1,3,4,5,6};
    	int peak=find(arr);
    	if(peak==-1){System.out.println("No missing element found");}
    	else{System.out.println("Missing element: "+peak);}
    	
        
    } 
}