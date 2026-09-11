class Solution {
    public String decodeString(String s) {
        int n = s.length();
        Stack<String> st = new Stack<>();
        for(int i = 0; i < n; i++){
            if(s.charAt(i)==']'){
                String t="";
                while(!st.isEmpty() && !st.peek().equals("[")){
                    t = st.pop()+t ;
                }
                st.pop();
                String nums="";
              while (!st.isEmpty() && st.peek().matches("\\d")) {
                nums = st.pop() + nums;
}


                int num = Integer.parseInt(nums);
                String ans="";
                for(int j = 0; j < num; j++){
                    ans = ans + t;
                }
                st.push(ans);
        }
        else
        {
            st.push(String.valueOf(s.charAt(i)));
        }
        }
        String res = "";
        while(!st.isEmpty()){
            res = st.pop() + res;
        }
        return res;
    }
}