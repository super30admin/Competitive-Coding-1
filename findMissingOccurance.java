package Competitive_Coding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class findMissingOccurance {
	
	//Assuimg numbers are sorted. Hence Applying Binary Search
	public static int missedNumberSorted(int[] numbers)
	{
		int left = 0, right = numbers.length-1;
		int mid = 0;
		
		while(numbers[right] - numbers[left] != 2)
		{
			mid = left + (right-left)/2;
			if(numbers[mid] - mid == 1)
			{
				left = mid;
			}
			else 
			{
				right = mid;
			}
		}
		return  numbers[left]+1;
	}
	
	
	public static int missedNumberNotSorted(int[] numbers)
	{
		int max = Arrays.stream(numbers).max().getAsInt();
		int expectedSum = max*(max+1)/2;
		int actualSum = 0;
		
		for(int num : numbers)
		{
			actualSum += num;
		}
		return expectedSum - actualSum;
	}
	
	
	
	public static void main(String[] args) {
		
		int[] sortedNumbers = {1,2,3,4,5,7,8,9,10};
		System.out.println(missedNumberSorted(sortedNumbers));
		int[] unsortedNumbers = {9,6,8,2,3,5,7,1,11,4};
		System.out.println(missedNumberNotSorted(unsortedNumbers));
		
	}

}
