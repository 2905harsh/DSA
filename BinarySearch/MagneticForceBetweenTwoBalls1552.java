class Solution {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int low = 1; // smallest separation between any two ball 
        int high = position[position.length-1] - position[0]; // largest separation between any two ball 
        int mid = 0;
        int ans = 0 ; 
        while(low<=high){
            mid = (low+high)/2;
            if(IsThisMinDistancePossible(position,mid,m)){
            low = mid+1;
            ans = mid;
            } 
            else high = mid-1;
        }
        return ans;
    }

    public boolean IsThisMinDistancePossible(int[] position , int minDistance,int ballsToPlace){
       // Placed first ball at the starting.
       int lastPlacedPosition = position[0];
       ballsToPlace = ballsToPlace-1;
       // we are now having ballsToPlace-1 balls to place ahead.
       for(int i =1 ; i<position.length; i++){
            if(ballsToPlace==0) return true;
            if(lastPlacedPosition+minDistance<=position[i]){
            // If condition is true place that ball also.
            ballsToPlace=ballsToPlace-1;
            lastPlacedPosition = position[i]; // update the lastPlacedPosition with this ball.
           }
       }
       return (ballsToPlace==0);
    }
}
