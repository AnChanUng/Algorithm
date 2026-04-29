class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++) {
            if(map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }

        int maxCnt = 0;
        int key = 0;
        for(Map.Entry<Integer, Integer> e : map.entrySet()) {
            if(e.getValue() > maxCnt) {
                maxCnt = e.getValue();
                key = e.getKey();
            }
        }

        return key;
    }
}