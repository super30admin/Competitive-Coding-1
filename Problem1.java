class MockInterview1 {
    // This is same as LeetCode question 1060
    public static int searchMissing(int[] a) {
        int l, r, m;
        if(a == null || a.length == 0) {
            return -1;
        }
        l = 0;
        r = a.length - 1;
        while(r - l >= 2) {
            m = l + (r - l) / 2;
            if(a[m] - m != a[l] - l) {
                r = m;
            } else {
                l = m;
            }
        }
        return (a[l] + a[r]) / 2;
    }

    public static void main (String[] args)
    {
        int ar[] = { 3, 4, 5, 6, 8 };
        int size = ar.length;
        System.out.println("Missing number: " +
                searchMissing(ar));
    }
}