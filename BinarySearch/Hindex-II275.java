class Solution {
    public int hIndex(int[] citations) {
        int l = 0 ;
        int h = citations.length;
        int mid = 0;
        while(l<=h){
            mid = (l+h)/2;
            if(isSafe(citations,mid)){
                l=mid+1;
            }
            else{
                h=mid-1;
            }
        }
        return h;
    }

    public boolean isSafe(int[] citations , int h){
        int r = citations.length-1;
        int count=0;
        while(r>=0 && citations[r]>=h){
            count++;
            r--;
        }
        return (count>=h);
    }
}