class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0;
        long sum = 0;       // running sum of the current window
        int maxFreq = 1;

        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];

            // cost to raise everyone in [left, right] up to nums[right]
            while ((long) nums[right] * (right - left + 1) - sum > k) {
                sum -= nums[left];
                left++;
            }

            maxFreq = Math.max(maxFreq, right - left + 1);
        }

        return maxFreq;
        
    }
}