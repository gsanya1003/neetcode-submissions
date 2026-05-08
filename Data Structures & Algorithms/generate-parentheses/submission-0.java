class Solution {
    int cnt = 0;
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        StringBuilder stack = new StringBuilder();
       parenthesis("",0,0,n, res);
       return res;
    }

    public void parenthesis(String s, int open, int close, int n, List<String> list){

        if(open == close && open == n){
            list.add(s);
        return ;
        }
      //  s = s +'(';
       // open ++;
        if(open <n){
        parenthesis(s+'(', open +1, close,n, list);
        System.out.println("1st " +  s);
        
       }
        if(close < open ){
        parenthesis(s+')',open , close +1,n, list);
         System.out.println("2nd " +  s);
        
       }

       
    }
}
