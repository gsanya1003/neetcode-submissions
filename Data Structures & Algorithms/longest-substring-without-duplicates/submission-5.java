class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length(), l = 0, r = 0, max = 0;
        HashMap<Character, Integer> map = new HashMap<>();
       while(r < n){
        //System.out.println(max);
        if( map.containsKey(s.charAt(r))){
            l = Math.max(l, 1 + map.get(s.charAt(r)));
        }
        
        
            map.put(s.charAt(r),r);
            
           
        
         max = Math.max(max, r-l+1);
        r++;
       }
       return max;
    }
}
