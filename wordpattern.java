Time:O(n)
Space:O(n)

public boolean wordPattern(String pattern, String s) {
    if(s==null || pattern==null) return false;
    
    String[] strs = s.split(" ");
    
    if(pattern.length()!=strs.length) return false;
    HashMap<Character,String>h1= new HashMap<>();
    HashMap<String,Character>h2= new HashMap<>();
    
    for(int i=0;i<strs.length;i++){
        
       char letter = pattern.charAt(i);
       String word = strs[i];
    
       //case 1: when letter does'nt match with word
        if(h1.containsKey(letter) && !h1.get(letter).equals(word)){
            return false;
        }
        //case 2:when word does'nt match with letter
        if(h2.containsKey(word) && h2.get(word)!=letter){
            return false;
        }
        h1.put(letter,word);
        h2.put(word,letter);
    }
    
   return true; 
    
}
}
