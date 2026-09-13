
class Node{
    int v;
    int f;
    int t;
    int k;
    Node next;
    Node(int k,int v, int t){
        this.k = k;
        this.v = v;
        this.f = 1;
        this.t = t;
        next = null;
    }
}
class LFUCache {
    int size;
     Node head;
       int time;
       int cap;
    public LFUCache(int capacity) {
        size = capacity;
        time = 0;
        cap = 0;
    head = new Node(-1,-1,-1);
    }
    
    public int get(int key) {
        time++;
        Node curr = head;
      
        while(curr!=null){
            if(curr.k == key){
                curr.f = curr.f + 1;
                 curr.t = time;
                return curr.v;
            }
            curr = curr.next;
            
        }
        return -1;
        
    }
    
    public void put(int key, int value) {
          time++;
       /* if(size==1)
        {
            if(node.k == key){
                node.v = value;
                node.f = node.f + 1;
                node.t = time;
            }
            else
            {
                head = new Node(key, value, 1);
            }
        }*/
       boolean flag = false;
        Node curr = head;
        if(cap < size){
        while(curr.next!=null){
            if(curr.next.k == key){
                curr.next.f = curr.next.f + 1;
                 curr.next.t = time;
                 flag = true;
               curr.next.v = value;
               break;
            }
           curr = curr.next;
        }
         if(flag == false){
         curr.next = new Node(key, value, time);
         cap++;
         }
        }
        else
        {
            int minf = 600000;
            int mink = -1;
            int mint = size;
            int freq = 0;
            while(curr.next!=null){
                if(minf > curr.next.f){
                      mint = curr.next.t;
                      mink = curr.next.k;
                      minf = curr.next.f;

                   }
                   else if((minf == curr.next.f) && (mint >= curr.next.t)){
                     mint = curr.next.t;
                      mink = curr.next.k;
                      minf = curr.next.f;
                   }
                   curr = curr.next;

                }
                curr = head.next;
                Node prev = head;
                while(curr!=null){
                    if(curr.k == mink){
                        prev.next = curr.next;
                        break;
                    }
                    curr = curr.next;
                    prev = prev.next;
                }
                curr = head;
            while(curr.next!=null){
            curr = curr.next;
            }
            curr.next = new Node(key, value, time);
        }

        
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */