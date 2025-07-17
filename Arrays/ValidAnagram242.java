class Solution {
    public boolean isAnagram(String s, String t) {
        return getSortedString(s).equals(getSortedString(t)) ;
        
    }
    public String getSortedString(String s){
        int []smallAlphabets = new int[26];
        for(char ch : s.toCharArray()){
            smallAlphabets[ch-97] += 1;
        }
        String ans ="";
        for(int i =0;i<26;i++){
            int count = smallAlphabets[i];
            if(count>=1){
                while(count>0){
                    ans+=(char)(97 + i);
                    count--;
                }
            }
        }
        return ans;
}
}
