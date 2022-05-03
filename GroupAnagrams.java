// Time Complexity : O(n^2logn) ; 
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * GroupAnagrams
 */
public class GroupAnagrams {
    void swap(char arr[],int i,int j){
         char ch = arr[i];
         arr[i] = arr[j];
         arr[j] = ch;
     }
     
     int partition(char arr[], int low, int high) 
     {
         int pivot = high;
         high--;
         while(low <= high){
             if(arr[low] <= arr[pivot]){
                 low++;
             }
             else if(arr[high] >= arr[pivot]){
                 high--;
             }
             else{
                 swap(arr, low, high);
             }
         }
         if (low != pivot)
             swap(arr, low, pivot);
         
         return low;
     } 
     
     void sort(char arr[], int low, int high) 
     {
         if(low < high){
             
             int partition = partition(arr, low, high);
             
             sort(arr, low, partition-1);
             
             sort(arr, partition+1, high);
         }  
     }
 
     public String getSortedString(String str) {
 
         char[] chars = str.toCharArray();
         sort(chars, 0, chars.length-1);
         return new String(chars);
 
     }
 
     public List<List<String>> groupAnagrams(String[] strs) {
 
         Map<String, List<String>> strsMap = new HashMap<String, List<String>>();
 
         for(int i=0; i<strs.length; i++) {
             //Sorting String using quick sort
             //So that all anagrams generates same key element
             String key = getSortedString(strs[i]);
             if(strsMap.containsKey(key)) {
                 ArrayList<String> list = (ArrayList<String>)strsMap.get(key);
                 list.add(strs[i]);
             }else{
                 ArrayList<String> list = new ArrayList<String>();
                 list.add(strs[i]);
                 strsMap.put(key, list);
             }
         }
 
         List<List<String>> grouppedStrs = new ArrayList(strsMap.values());
 
         return grouppedStrs;
 
     }
 }