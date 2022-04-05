/**
 * Time complexity is O(n)
 * Space complexity is O(1)
 * Did this code successfully run on Leet code : Yes
 * Any problem you faced while coding this : No
 * https://leetcode.com/problems/isomorphic-strings/
 */
public class IsomorphicStringsImplUsingCharacterArrays {
    public static void main(String[] args) {
        System.out.println(isIsomorphic("foo", "bar"));
        System.out.println(isIsomorphic("paper", "title"));
    }

    private static boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        char[] sMap = new char[100];
        char[] tMap = new char[100];

        for(int i=0; i<s.length(); i++){
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);

            if(sMap[sChar - ' '] == 0){
                sMap[sChar - ' '] = tChar;
            }
            else{
                if(sMap[sChar - ' '] != tChar){
                    return false;
                }
            }

            if(tMap[tChar - ' '] == 0){
                tMap[tChar - ' '] = sChar;
            }
            else{
                if(tMap[tChar - ' '] != sChar){
                    return false;
                }
            }
        }

        return true;
    }
}
