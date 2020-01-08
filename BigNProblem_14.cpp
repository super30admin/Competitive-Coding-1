void func_findmissinginteger(int arr[])
{
    int i;
    for(i=0;i<sizeof(arr);)
    {
        if(++arr[i]==arr[i+1])
           i++;
        else 
            break;
        
    }
    cout<<arr[i];
}

int main()
{
    int arr[] = {1000,1001,1002,1003,1005,1006};
    func_findmissinginteger(arr);
    
    
}
