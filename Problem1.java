//Time complexity: O(N)
//Space complexity: O(N)

class Solution {
    public boolean wordPattern(String pattern, String s) {
        HashMap<Character,String>m=new HashMap<Character,String>();
        char[] c1= pattern.toCharArray();
        String[] s1= s.split(" ");
        if(c1.length!=s1.length)
            return false;
        for(int i=0;i<c1.length;i++)
        {
            if(m.containsKey(c1[i]))
            {
                if(!m.get(c1[i]).equals(s1[i]))
                  return false;
            }
            else
            {
                if(m.containsValue(s1[i]))
                    return false;
                m.put(c1[i],s1[i]);
                
            }
        }
        
        return true;
    }
}
