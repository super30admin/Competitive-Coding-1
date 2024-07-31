    // int l=0;
    // int r=n-1,mid=0;
    // while(r-l>=2){
    //         mid=l+(r-l)/2;
    //         int mididx=arr[mid]-mid;
    //         int lidx=arr[l]-l;
    //         int ridx=arr[r]-r;
    //         if(lidx!=mididx)
    //                 r=mid;
    //         else if(ridx!=mididx)
    //                 l=mid;
    //     }
    //     return (arr[l]+arr[r])/2;

    int tot=n*(n+1)/2;
    int a=0;
    for(int i=0;i<nums.length;i++){
        a+=nums[i];
    }
    return tot-a;
