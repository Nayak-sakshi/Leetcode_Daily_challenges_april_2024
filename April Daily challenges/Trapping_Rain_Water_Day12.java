//Given n non-negative integers representing an elevation map where
// the width of each bar is 1, compute how much water it can trap after raining.
//Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
//Output: 6
//Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1].
// In this case, 6 units of rain water (blue section) are being trapped.

public class Trapping_Rain_Water_Day12 {

        public int trap(int[] height) {
            int n = height.length;
            int leftMax = 0;
            int rightMax = 0;
            int l=0;
            int r=n-1;
            int ans = 0;
            while(l<r){
                if(height[l]>leftMax){
                    leftMax = Math.max(leftMax,height[l]);
                }
                if(height[r]>rightMax){
                    rightMax = Math.max(rightMax,height[r]);
                }
                if(leftMax<rightMax){
                    ans = ans + leftMax - height[l];
                    l++;
                }else{
                    ans = ans + rightMax - height[r];
                    r--;
                }
            }
            return ans;
        }

}
