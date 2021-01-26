// time complexity is O(n * k);
// space complexity is constant
// works on leetcode

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<Long, List<String>> anagrams = new HashMap<>();
        // Iterate over each string in the list
        for(String s: strs){
            // calculate the value and add it to the hashmap
            long value = calculateValue(s);
            if (anagrams.containsKey(value)){
                anagrams.get(value).add(s);
            }
            else{
                anagrams.put(value, new ArrayList<>(Collections.singleton(s)));
            }
        }
        return new ArrayList<>(anagrams.values());
    }
    
    public long calculateValue(String s){
      // assign a prime number to each letter and then the total is the product of the values of each letter
        int[] primes = new int[] {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103};
        long value = 1;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            value = value * primes[c - 'a'];
        }
        return value;
    }
    
}
