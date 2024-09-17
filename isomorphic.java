Time:O(n)
Space:O(n)


//Use two hashmaps: for each character add index and compare if the character mapping is same 
public boolean isIsomorphic(String s, String t) {
    if(s.length()!=t.length()) return false;
    if(s==null || t==null) return false;
    
    HashMap<Character,Integer> h1 = new HashMap<>();
    HashMap<Character,Integer> h2 = new HashMap<>();
    
    for(int i=0;i<s.length();i++){
        int map1 = h1.getOrDefault(s.charAt(i) , -1);
        int map2 = h2.getOrDefault(t.charAt(i) , -1);
        
        if(map1!=map2){
            return false;
        }
        
        h1.put(s.charAt(i), i);
        h2.put(t.charAt(i), i);
    }
    
    
    return true;
}
}