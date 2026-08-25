class Solution {
    public int numDecodings(String s) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(s.length(), 1);
        int sol = res(s,0, map);
        return sol;
    }


    public int res(String s, int i, HashMap<Integer, Integer> map){
       if(map.containsKey(i))
       return map.get(i);
        if(s.charAt(i)=='0')
        return 0;
        int ans = res(s, i+1, map);
        if((i+1) < s.length() && (s.charAt(i)=='1'|| (s.charAt(i)=='2' && s.charAt(i+1)< '7')))
        ans = ans + res(s,i+2,map);
        map.put(i, ans);
        return ans;
    }
}
