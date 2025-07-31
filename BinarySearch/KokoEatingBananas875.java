class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1 ; // lowest speed koko can have 
        int high = findTheMaxInArray(piles); // highest speed koko can have
        int mid = 0; 
        while(low<high){
          mid = low +(high-low)/2;
          if(canThisSpeedOfKokoWork(piles,h,mid)){
            high=mid;
          } 
          else low=mid+1;
        }
        return low;
    }
    public boolean canThisSpeedOfKokoWork(int[]piles , int h , int speedPerHour){        
         int timeWeNeedWithThisSpeed = 0 ;
         for(int ele : piles){
            timeWeNeedWithThisSpeed+= (int)(Math.ceil((double)(ele)/speedPerHour));
         }
        return (timeWeNeedWithThisSpeed<=h) ;
    }
    public int findTheMaxInArray(int[] arr){
        int maximum = 0;
        for(int ele : arr){
            maximum = Math.max(maximum,ele);
        }
        return maximum;
    }
}
