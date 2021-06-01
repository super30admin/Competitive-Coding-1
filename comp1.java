static int search1(int a[], int size){
        int low=0;
        int high = size-1;
        int mid =0;
        while((high-low)>1){
            mid = low + (high - low)/2;
            if((a[low]-low)!=(a[mid]-mid)){
                high=mid;
            }
            if((a[high]-high) != (a[mid]-mid)){
                low=mid;
            }
        }
        return(a[mid]+1);

    }