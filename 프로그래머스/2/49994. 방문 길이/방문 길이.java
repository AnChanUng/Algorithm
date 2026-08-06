import java.util.*;
class Solution { // 좌 하 우 상
    static boolean[][][] vis;
    static int cnt;
    public int solution(String dirs) {
        vis = new boolean[11][11][2];
        
        cnt = 0;
        move(5, 5, dirs);
        return cnt;
    }
    static void move(int x, int y, String dirs) {
        int d = 0;
        for(int i=0; i<dirs.length(); i++) {
            char ch = dirs.charAt(i);
            int nx = 0;
            int ny = 0;
            if(ch == 'L') {
                nx = x - 1; 
                ny = y;
                d = 0;
            } else if (ch == 'R') {
                nx = x + 1; 
                ny = y;
                d = 0;
            } else if (ch == 'D') {
                nx = x; 
                ny = y + 1;
                d = 1;
            } else if (ch == 'U') {
                nx = x; 
                ny = y - 1;
                d = 1;
            }
            if(nx < 0 || nx >= 11 || ny < 0 || ny >= 11) continue;
            int ux = Math.min(x, nx);
            int uy = Math.min(y, ny);
            if(!vis[ux][uy][d]) {
                vis[ux][uy][d] = true;
                cnt++;
            }
            x = nx;
            y = ny;
        }
    }
}