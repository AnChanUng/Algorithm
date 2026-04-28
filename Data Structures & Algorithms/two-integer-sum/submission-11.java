class Solution {
    public int[] twoSum(int[] nums, int target) {
        // 2개를 선택해서 target 이 되는 수의 인덱스 구하기
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++) {
            int need = target - nums[i];

            if(map.containsKey(need)) {
                return new int[]{map.get(need), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }
}
