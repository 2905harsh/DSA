class Solution {
    public int findContentChildren(int[] g, int[] s) {
        // g represents the greed factor of each child
        // s represents the size of each cookies we have.
        // Child will be satisfied if we give him more or equal to its greed.
        Arrays.sort(g);
        Arrays.sort(s);
        int l = 0; // will l for greedFactor array.
        int r = 0; // will r for sizeOfCookie array.
        while(l<g.length && r<s.length){
            if(g[l]<=s[r]){
                // Assigned
                l++;
                r++;
            }
            else{
                r++;
            }
        return l;
        
    }
}
}

        
