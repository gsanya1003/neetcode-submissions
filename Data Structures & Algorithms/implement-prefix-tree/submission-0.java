class TrieNode{
    HashMap<Character, TrieNode>  child = new HashMap<>();
    boolean  last = false;
   
       
       
    
}

class PrefixTree {
  
   TrieNode root ;
    public PrefixTree() {
         root = new TrieNode();
    }

    public void insert(String word) {
         TrieNode curr = root;
         for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            curr.child.putIfAbsent(c, new TrieNode());
            curr = curr.child.get(c);
         }
         curr.last = true;
    }

    public boolean search(String word) {
         TrieNode curr = root;
         for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(!curr.child.containsKey(c))
            return false;
            curr = curr.child.get(c);
         }
           return curr.last;

    }

    public boolean startsWith(String word) {
          TrieNode curr = root;
         for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
              if(!curr.child.containsKey(c))
             return false;
             curr = curr.child.get(c);
         }
           return true;
    }
}
