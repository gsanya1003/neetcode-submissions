class Solution {
    public boolean checkInclusion(String s1, String s2) {
        
        if(s1.length()> s2.length())
        return false;

        int win = s1.length();
        int f = 1;
        for(int i = 0; i < s2.length()-win + 1; i = i +1){
            f=1;
            String s="";
            for(int j = i ; j < i + win ; j++){
                s = s + s2.charAt(j);
            }
            //System.out.println(s);
            char[] charArray = s.toCharArray();
            char[] charArray2 = s1.toCharArray();
            
            Arrays.sort(charArray);
            Arrays.sort(charArray2);
           // System.out.println(charArray2);
           // System.out.println(charArray);
           
            for (int j = 0; j < win; j++){
                if(charArray[j]!=charArray2[j]){
                f = 0;
                // System.out.println(charArray[j] +"---"+charArray2[j]);
                break;
                }
            }
            //System.out.println(f);
            if(f==1)
            return true;
        }
        return false;
    }
}
