// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
//leetcode 205
class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length()!=t.length()) return false;
        HashMap<Character,Character> sMap= new HashMap();
        HashMap<Character,Character> tMap= new HashMap();
        
        for(int i=0;i<s.length();i++){
            char sChar=s.charAt(i);
            char tChar=t.charAt(i);
            if(sMap.containsKey(sChar)){
                if(sMap.get(sChar) != tChar){
                    return false;
                }
            }
            else{
                sMap.put(sChar, tChar);
            }
            if(tMap.containsKey(tChar)){
                if(tMap.get(tChar) != sChar){
                    return false;
                }
            }
            else{
                tMap.put(tChar, sChar);
            }
        }
        return true;
    }
}