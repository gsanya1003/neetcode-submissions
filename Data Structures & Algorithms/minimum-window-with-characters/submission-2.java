class Solution {
    public String minWindow(String s, String t) {
        if(t.length() > s.length())
        return "";
        int i = 0, j = 0, cnt = 0, min = 1000001;
        String res="";
        HashMap<Character, Integer> map = new HashMap<>();
        for(int k = 0; k < t.length(); k++){
            map.put(t.charAt(k), map.getOrDefault(t.charAt(k) , 0)  + 1);
        }
        while(j < s.length()){
            char c = s.charAt(j);
           
            if(map.containsKey(c))
            { 
                if(map.get(c) > 0)
                {
                cnt++;
                }
                map.put(c, map.get(c)-1);
            }
            if(cnt == t.length()){
                while(cnt == t.length())
                {
                   char cl = s.charAt(i);
                  if (j-i+1 < min){
                    min = j-i+1;
                     res = s.substring(i, j + 1);
                  }
                     if(map.containsKey(cl)){
                    if(map.get(cl) >= 0){
                       cnt--;
                    }
                    map.put(cl, map.get(cl) + 1);
                   }
                   i++;
                }
            }
            j++;
        }
        
        //System.out.println(min);
        return res;

        
    }
}
