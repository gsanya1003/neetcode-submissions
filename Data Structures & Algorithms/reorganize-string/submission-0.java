
class Pair{
    char c;
    int f;
    Pair(char c, int f){
        this.c = c;
        this.f = f;
    }
}
class Solution {
    public String reorganizeString(String s) {

        int freq[] = new int[26];
        int n = s.length();
        for(int i = 0; i < n; i++){
            freq[s.charAt(i)-'a']++;
            if(freq[s.charAt(i)-'a'] > (n+1)/2)
            return "";
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->b.f-a.f);
        for(int i = 0; i < 26; i++){
            if(freq[i] > 0)
            pq.add(new Pair((char)('a' + i), freq[i]));
        }
         StringBuilder ans = new StringBuilder();
        while(pq.size()>= 2){
            Pair one = pq.poll();
            Pair two = pq.poll();
            ans.append(one.c);
            ans.append(two.c);
            if(one.f > 1)
            pq.add(new Pair(one.c, one.f -1));
             if(two.f > 1)
            pq.add(new Pair(two.c, two.f -1));
        }
        System.out.println(ans.toString());
        if(!pq.isEmpty())
        ans.append(pq.poll().c);
        return ans.toString();
        
    }
}