class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int res = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int i = 0, j = 0, maxlen=0, max=0;
        while(j < n){
            map.put(s.charAt(j),1 + map.getOrDefault(s.charAt(j), 0));
            max = Math.max(max, map.get(s.charAt(j)));
            while((j-i+1)-max > k){
                map.put(s.charAt(i), map.get(s.charAt(i)) -1);
                i++;
            }
            maxlen = j-i+1;
            j++;
        }
        return maxlen;
    }
}
