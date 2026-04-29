class Solution {
    public int majorityElement(int[] nums) {
        int[] arr = new int[20000001];
        for(int i=0; i<nums.length; i++) {
            arr[nums[i]]++;
        }

        int max = 0;
        int value = 0;
        for(int i=0; i<20000001; i++) {
            if(arr[i] > max) {
                value = i;
                max = arr[i];
            }
        }
        return value;
    }
}