class Solution {
    public int search(int[] nums, int target) {
        int answer = -1;

        Arrays.sort(nums);

        // nums 배열에 target이 있니
        for(int i=0; i<nums.length; i++) {
            if(nums[i] == target) {
                answer = i;
            }
        }

        return answer;
    }
}
