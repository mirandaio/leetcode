public class Solution {
    public int maxArea(int[] height) {
        if(height.length <= 1)
            return 0;

        int maxArea = 0;
        int left = 0;
        int right = height.length - 1;

        while(left < right) {
            int area = (right - left) * Math.min(height[left], height[right]);
            maxArea = Math.max(maxArea, area);

            if(height[left] < height[right])
                left++;
            else
                right--;
        }

        return maxArea;
    }
}
