public class FindFirstandLastPositionofElementinSortedArray {
  public static void main(String[] args) {
    int[]nums = {5,7,7,8,8,10}; 
    int target = 8;
    int[] result = searchRange(nums, target);
    System.out.println("First Position: " + result[0] + ", Last Position: " + result[1]);

  }
  public static int[] searchRange(int[] nums, int target) {
        int []ans = new int[2];
        if(nums.length==0 || nums[nums.length-1]<target){
            ans[0]=ans[1]=-1;
            return ans ; 
        }
        // for first occurence 
         int s = 0 ;
         int e = nums.length-1;
         int mid;
       while(s<=e){
        mid=(s+e)/2;
        if(target <= nums[mid]) e = mid-1 ;
        if(target>nums[mid]) s = mid+1;
       }
        if(nums[s]==target) ans[0]= s ;
        else ans[0]=-1;

        // for last occurence
        s = 0;
        e = nums.length-1;
        while(s<=e){
            mid=(s+e)/2;
            if(nums[mid]<=target) s= mid+1;
            if(nums[mid]>target) e =mid-1;
        }
        
        if(e==-1){
            ans[1]=-1;
            return ans;
        }

        if(nums[e]==target) ans[1]= e ;
        else  ans[1]=-1;
        return ans;

     }
}
