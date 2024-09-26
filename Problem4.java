import java.util.*;
class Problem4 {
    public static void main(String args[]) {
        HashMap<Character, String> map = new HashMap<Character, String>();
        String pattern = "abba";
        String str = "dog cat cat fish";
        StringTokenizer st1 = new StringTokenizer(
            str, " ");
        if(st1.countTokens() != pattern.length()){ System.out.println("false"); System.exit(0); }
        for(int i = 0; i < pattern.length() && st1.hasMoreTokens(); i++) {
            if(map.containsKey(pattern.charAt(i))) {
                if(!map.get(pattern.charAt(i)).equals(st1.nextToken())) { System.out.println("false"); System.exit(0); }
            }
            else {
                map.put(pattern.charAt(i), st1.nextToken());
            }
        }
        System.out.println("true");
    }
}