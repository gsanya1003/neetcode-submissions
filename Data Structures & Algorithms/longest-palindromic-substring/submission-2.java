class Solution {
    public String longestPalindrome(String s) {
        int resLen_odd = 1, res_odd = 0, resLen_even = 0, res_even = -1;
        for(int i = 0; i < s.length(); i++){
            if(i>= 0 && i <= s.length()-1){
                int j = i-1, k = i+1;
                while(j>= 0 && k <= s.length()-1 && s.charAt(j) == s.charAt(k))
                {   
                    if(k - j + 1 > resLen_odd){
                    res_odd = j;
                    resLen_odd = k - j +1;
                    }
                    j--;
                    k++;
                }
            }
            }

            for(int i = 0; i < s.length(); i++){
            if(i>= 0 && i <= s.length()-1){
                int j = i, k = i+1;
                while(j>= 0 && k <= s.length()-1 && s.charAt(j) == s.charAt(k))
                {
                    if(k - j + 1 > resLen_even){
                    res_even = j;
                    resLen_even = k - j +1;
                    }
                    j--;
                    k++;
                }
            }
            }

            int res_len = 0;
             String ans = "";
            if(resLen_odd > resLen_even){
                 for(int i = res_odd; i <res_odd+resLen_odd; i++)
                 ans = ans + s.charAt(i);
            }
            else
            {
                for(int i = res_even; i < res_even+resLen_even; i++)
                 ans = ans + s.charAt(i);
            }

            
            
        
    return ans;
        
        
    }
}
