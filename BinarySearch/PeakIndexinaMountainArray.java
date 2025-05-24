public class  PeakIndexinaMountainArray {
  public static void main(String[] args) {
    int []nums = {0,2,1,0};
    int ans = peakIndexInMountainArray(nums);
    System.out.println(ans);
    

    
    
  }
  public static int peakIndexInMountainArray(int[] arr) {
        int s =0;
        int e = arr.length-1;
        int mid;
        while(s<=e){
          mid =(s+e)/2;
          if(mid==0) mid=mid+1; // condition when mid becomes 0 that can't be peak element.
          if(checkPeak(arr,mid)) return mid;
          else{
            if (arr[mid-1]>arr[mid]) e =mid-1;
            if (arr[mid]<arr[mid+1]) s=mid+1;      
           }
        }
        return 0;
    }
    public static boolean checkPeak(int[]arr,int idx){
        if(arr[idx-1]<arr[idx] && arr[idx]>arr[idx+1]) return true ;
        else return false;
    }
}

// Question link : https://leetcode.com/problems/peak-index-in-a-mountain-array/description/

