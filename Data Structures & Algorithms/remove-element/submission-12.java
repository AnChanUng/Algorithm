class Solution {
    public int removeElement(int[] nums, int val) {
        int cnt = 0;
        for(int i=0; i<nums.length; i++) {
            if(nums[i] == val) {
                cnt++;
            }    
        }

        int[] res = new int[nums.length-cnt];
        int idx = 0;
        for(int i=0; i<nums.length; i++) {
            if(nums[i] != val) {
                nums[idx] = nums[i];
                idx++;
            }
        }
        return idx;
    }
}