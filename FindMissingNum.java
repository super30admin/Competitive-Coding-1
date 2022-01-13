class Missing{
    public int missingArr (int[] arr){
        int low =0; int high=0;
        while(high - low > 1){
            int mid= low+ (high-low)/2;
            if(mid-low != arr[mid]- arr[low]){
                high= mid;
            }
            else if(high- mid != arr[high]- arr[mid]){
                low= mid;
            }
        }
        return arr[high]+arr[low]/2;
    }
}

