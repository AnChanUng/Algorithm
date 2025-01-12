class Solution {
    public String solution(int a, int b) {
        String answer = "";

        int[] arr = {0, 31, 60, 91, 121, 152, 182, 213, 244, 274, 305, 335, 365};
        String[] week = {"THU", "FRI", "SAT", "SUN", "MON", "TUE", "WED"};
        
        String weeks = week[(arr[a-1] + b) % 7];
        
        return weeks;
    }
}