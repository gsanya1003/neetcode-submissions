class Solution {
    public int countSubstrings(String s) {
       int n = s.length()-1;
       int cnt =s.length();
       int odd = 0, even = 0;
       for(int i = 0; i< n+1; i++){
          if(i >= 0 && i <= n){
            int j = i-1;
            int k = i+1;
            while(j >= 0 && k <= n && s.charAt(j) == s.charAt(k)){
                odd++;
                j--;
                k++;
            }
          }
       } 
        for(int i = 0; i< n+1; i++){
          if(i >= 0 && i <= n){
            int j = i;
            int k = i+1;
            while(j >= 0 && k <= n && s.charAt(j) == s.charAt(k)){
                even ++;
                j--;
                k++;
            }
          }
       } 
      
       return odd+even+cnt;
    }
}
