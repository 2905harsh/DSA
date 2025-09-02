class Solution {
    public int balancedString(String s) {
        int []take = new int[26];
        for(char ch : s.toCharArray()){
            take[ch-'A']++;
        }
        int ans =s.length();
        int occ = s.length()/4;
        
        int l = 0;
        int r = 0;

        while(r<s.length()){
            take[s.charAt(r)-'A']--;

            // while the remaining string is balanced shift the left pointer to find a smaller window
            while(l<s.length() && take['Q'-'A']<=occ && take['W'-'A']<=occ && take['E'-'A']<=occ && take['R'-'A']<=occ){
                ans = Math.min(ans,(r-l+1));
                take[s.charAt(l)-'A']++;
                l++;
            }
            r++;

        }
        return ans;
      }
}
