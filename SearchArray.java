class SearchArray
{

public int search(int arr[])
{
   int start=0;
   int end=arr.length-1;

	//performing Binary Search
	while(start<=end)
	{
		int mid=start+(end-start)/2;
	
		if(arr[mid]==mid+1)
			start=mid+1;
		else if(arr[mid]!=mid+1 && (mid==0 || arr[mid-1]==mid))
			return mid+1;
		else
			end=mid-1;
	}
	return -1; // When no number is missed return -1
}

public static void main(String args[])
    {
	SearchArray s=new SearchArray();
	int arr[]={1,2,3,4,5,6,7,8};
	int result=s.search(arr);
	if(result!=-1)
	System.out.println("Number missed is "+ result );
	else
	System.out.println(" No number is missed");
		
    }
}