// Simple recursion 
class Solution {
    public int maximumPoints(int arr[][]) {
        // code here
        return func(arr.length-1 , 4  , arr);
    }
    // func(day,taskWhichIsPerformedPrevoiusly,arr)
    public int func(int day,int lastTaskNumber , int[][]arr){
        if(day<0) return 0;
        int maxi = 0;
        for(int i =0 ;i<3 ;i++){
            if(i!=lastTaskNumber){
                maxi=Math.max(maxi,arr[day][i]+func(day-1,i,arr));
            }
        }
        return maxi;
        
    }
}

// Memoization beacuse of overlapping subproblems when the recursion tree grows large.
class Solution {
    public int maximumPoints(int arr[][]) {
        int [][]dp = new int[arr.length][4];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
        return func(arr.length-1 , 3  , arr,dp);
    }
    // func(day,taskWhichIsPerformedPrevoiusly,arr)
    public int func(int day,int lastTaskNumber , int[][]arr,int[][] dp){
        if(day<0) return 0;
        if(dp[day][lastTaskNumber]!=-1) return dp[day][lastTaskNumber];
        int maxi = 0;
        for(int i =0 ;i<3 ;i++){
            if(i!=lastTaskNumber){
                maxi=Math.max(maxi,arr[day][i]+func(day-1,i,arr,dp));
            }
        }
        dp[day][lastTaskNumber]=maxi;
        return  dp[day][lastTaskNumber];
    }
}

// Tabulation
class Solution {
    public int maximumPoints(int arr[][]) {
        // code here
        int [][] dp = new int[arr.length][4];
        // base cases
        dp[0][0]=Math.max(arr[0][1],arr[0][2]);
        dp[0][1]=Math.max(arr[0][0],arr[0][2]);
        dp[0][2]=Math.max(arr[0][1],arr[0][0]);
        dp[0][3]=Math.max(arr[0][0],Math.max(arr[0][1],arr[0][2]));
        
        for(int day = 1 ; day<arr.length ; day++){
            for(int last =0 ; last<4 ; last++){
                for(int task=0 ; task<3 ;task++){
                    if(task!=last){
                        int point = arr[day][task]+dp[day-1][task];
                        dp[day][last]=Math.max(dp[day][last],point);
                    }
                    
                }
            }
        }
        return dp[arr.length-1][3];
        
    }
}

// Space Optimization
class Solution {
    public int maximumPoints(int arr[][]) {
        // code here
        int [] prev = new int[4];
        // base cases
        prev[0]=Math.max(arr[0][1],arr[0][2]);
        prev[1]=Math.max(arr[0][0],arr[0][2]);
        prev[2]=Math.max(arr[0][1],arr[0][0]);
        prev[3]=Math.max(arr[0][0],Math.max(arr[0][1],arr[0][2]));
        
        for(int day = 1 ; day<arr.length ; day++){
            int [] temp = new int[4];
            for(int last =0 ; last<4 ; last++){
                for(int task=0 ; task<3 ;task++){
                    if(task!=last){
                        int point = arr[day][task]+prev[task];
                        temp[last]=Math.max(temp[last],point);
                    }
                    
                }
            }
            prev=temp;
        }
        return prev[3];
        
    }
}