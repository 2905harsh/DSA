public class code{
class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int lsum = 0 ;
        int rsum = 0 ;
        int sum = 0;
        for(int i=0 ;i<k;i++){
            lsum+=cardPoints[i];
        }
        sum = lsum;
        int lindex = k-1;
        int rindex =cardPoints.length-1; 
        while(lindex>-1){
               lsum -=cardPoints[lindex];
               rsum +=cardPoints[rindex];
               sum = Math.max(sum,lsum+rsum);
               lindex--;
               rindex--;
        }
        return sum;
    }
}
}