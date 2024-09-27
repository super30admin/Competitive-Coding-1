import java.util.HashMap;
import java.util.HashSet;

/**
 * Time complexity is O(n)
 * Space complexity is O(1)
 * Did this code successfully run on Leet code : Yes
 * Any problem you faced while coding this : No
 * https://leetcode.com/problems/isomorphic-strings/
 */
public class IsomorphicStringsImplUsingMapAndSet {
    public static void main(String[] args) {
        System.out.println(isIsomorphic("foo", "bar"));
        System.out.println(isIsomorphic("paper", "title"));
    }

    private static boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }

        HashMap<Character,Character> sMap = new HashMap<>();
        HashSet<Character> set = new HashSet<>();

        for(int i = 0; i<s.length(); i++){
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);

            if(!sMap.containsKey(sChar)){
                sMap.put(sChar,tChar);
                if(set.contains(tChar)){
                    return false;
                }
                else{
                    set.add(tChar);
                }
            }
            else{
                if(sMap.get(sChar) != tChar){
                    return false;
                }
            }
        }
        return true;
    }
}
