class Solution {
    static int[] dr = {1, 0, -1};
    static int[] dc = {0, 1, -1};
    static int[] arr;
    static int dir, row, col;
    static int len;
    public int[] solution(int n) {
        len = n * (n + 1) / 2;
        arr = new int[len];
        
        dir = 0;
        row = 0; 
        col = 0;
        
        for (int num = 1; num <= len; num++) {
            arr[row * (row + 1) / 2 + col] = num;
            
            int nr = row + dr[dir];
            int nc = col + dc[dir];
            
            if (nr < 0 || nr >= n || nc < 0 || nc > nr || arr[nr * (nr + 1) / 2 + nc] != 0) {
                dir = (dir + 1) % 3;
                nr = row + dr[dir];
                nc = col + dc[dir];
            }
            row = nr;
            col = nc;
        }
        return arr;
    }
}