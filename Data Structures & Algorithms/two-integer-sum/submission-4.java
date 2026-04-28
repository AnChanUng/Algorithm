class Solution {
    public int[] twoSum(int[] nums, int target) {
        // 2개를 선택해서 target 이 되는 수의 인덱스 구하기
        int[] res = new int[2];
        for(int i=0; i<nums.length; i++) {
            for(int j=i+1; j<nums.length; j++) {
                if(nums[i] + nums[j] == target) {
                    res[0] = i;
                    res[1] = j;
                }
            }
        }
        
        return res;
    }
}
