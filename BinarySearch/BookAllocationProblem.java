public class BookAllocationProblem {
  public static void main(String[] args) {
    int [] arr = {12,34,67,90};
    int k =2 ; 
    int ans = findPages(arr, k);
    System.out.println(ans); 
    
    // if number of students are equal to number of books then maximum pages will be the maximum element in the array.
    // if number of student is 1 then maximum pages will be the sum of all elements in the array.
    // That means our answer will be in the range of [max(arr), sum(arr)].
  
  }

   public static int findPages(int[] arr, int k) {
        if(k>arr.length) return -1 ; 
        int[] ans = LargestElementAndSumOfArray(arr);
        int s = ans[0];
        int e = ans[1];
        int mid;
        while(s<e){
            mid = (e+s)/2;
            // Checking if this can be potential answer.
            int sum = 0;
            int students = 1;
            for(int ele : arr){
                if(sum+ele>mid){
                    students++; // new student will be allocated.
                    sum = ele;
                }
                else{
                    sum=sum+ele;
                }
            }
            if(students>k){
                s = mid+1;
                
            }
            else{
                e=mid;
            }
        }
        return e;
        
        
    }
      public static int[] LargestElementAndSumOfArray(int[]nums){
        int []ans = new int[2];
        int max = nums[0];
        int sum = nums[0];
        for(int i =1 ;i<nums.length;i++){
            if(nums[i]>max) max= nums[i];
            sum=sum+nums[i];
        }
        ans[0]=max;
        ans[1]=sum;
        return ans;
    }


}

// Question link https://www.geeksforgeeks.org/problems/allocate-minimum-number-of-pages0937/1