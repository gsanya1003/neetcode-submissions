class Pair{
    char c;
    int f;
    Pair(char c, int f){
        this.c = c;
        this.f = f;
    }
}


class Solution {
    public String longestDiverseString(int a, int b, int c) {

        PriorityQueue<Pair> pq = new PriorityQueue<>((d,e)->(e.f - d.f));
      if (a > 0) pq.add(new Pair('a', a));
        if (b > 0) pq.add(new Pair('b', b));
        if (c > 0) pq.add(new Pair('c', c));

        StringBuilder res = new StringBuilder();
        while(!pq.isEmpty()){
            Pair p1 = pq.poll();
             int n = res.length();
            if(n >= 2 && res.charAt(n-1)==p1.c && res.charAt(n-2)==p1.c)
            {
                
               if (pq.isEmpty()) {
                    break;
                }

            Pair p2 = pq.poll();
            res.append(p2.c);
            p2.f--;

            if(p2.f > 0){
            //res.append(p2.c);
            //p2.f--;
              pq.add(p2);
            }

          
            pq.add(p1);

            }
            else
            {
                res.append(p1.c);
            p1.f--;

            if(p1.f > 0){
            //res.append(p1.c);
           // p1.f--;
            pq.add(p1);
            }

            
            }

        }

       

        return res.toString();


        
    }
}