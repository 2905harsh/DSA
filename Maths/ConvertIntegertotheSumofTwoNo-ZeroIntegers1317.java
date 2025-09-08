// No-Zero integer is a positive integer that does not contain any 0 in its decimal representation.
// Not allowed X 10 20 101 2003 
class Solution {
    public int[] getNoZeroIntegers(int n) {
        int a = 1;
        int b = n-a;


        while((a+"").contains("0") || (b+"").contains("0")){
            a++;
            b--;
        }

        int []ans = new int [2];
        ans[0]=a;
        ans[1]=b;

        return ans;

    }
}
