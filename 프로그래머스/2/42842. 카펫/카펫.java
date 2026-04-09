class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];

        int width = brown + yellow;  
        
        //(가로-2) × (세로-2) = yellow
        for(int x=3; x<=width; x++) {
            for(int y=3; y<=width; y++) {
                if(x * y == width && (x-2) * (y-2) == yellow){
                    return new int[]{y, x};
                }
            }
        }  
        return answer;
    }
}