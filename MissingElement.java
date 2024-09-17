//Time Complexity- log(n)
//Space Complexity-O(1)
/* Approach- if the difference between the element at mid and mid is same as the difference between the element at
low and low then the missing element will be on the right side of the side so, low =mid;
a[mid]-mid==1
a[high]-high==2
then no. of elements missing in bwt mid and high is (2-1)=1;
*/
public class MissingElement {
 public static int findMissing(int[] a) {
	 int l=0;
	 int h=a.length-1;
	 int mid;
	 while((h-l)>=2) {
		 mid=l+(h-l)/2;
		 if(a[mid]-mid==a[l]-l)
			 l=mid;
	     else
			 h=mid;
	 }
	 return (a[l]+a[h])/2;

 }

public static void main(String[] args) {
		int[] a= {1,2,5,4,6};
		int p= findMissing(a);
		System.out.println(p);
	}
}

