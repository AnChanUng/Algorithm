import java.util.*;
/*
    key를 90 ~ 360도 돌리고 이동 시켰을 때, 채우면 true 아니면 false
    
    알고리즘: 시뮬레이션
    
    key를 90~360도 돌리는 함수를 구한다
    key를 상하좌우로 이동시킨다
    key가 lock과 일치 하면 true
    key가 lock과 일치하지 않으면 false
*/
class Solution {
    static boolean answer;
    static int n, m;
    public boolean solution(int[][] key, int[][] lock) {
        answer = false;
        m = key.length;
        n = lock.length;
        
        rotate(key, lock, 0);
        if(answer) return true;
        rotate(key, lock, 90);
        if(answer) return true;
        rotate(key, lock, 180);
        if(answer) return true;
        rotate(key, lock, 270);
        
        return answer;
    }
    
    private static void rotate(int[][] key, int[][] lock, int degree) {
        int[][] rotate = new int[m][m];
       
        for(int i=0; i<m; i++) {
            for(int j=0; j<m; j++) {
                switch(degree) {
                    case 0:
                        rotate[i][j] = key[i][j];
                        break;
                    case 90:
                        rotate[i][j] = key[m-1-j][i];
                        break;
                    case 180:
                        rotate[i][j] = key[m-1-i][m-1-j];
                        break;
                    case 270:
                        rotate[i][j] = key[j][m-1-i];
                        break;
                }
            }
        }      
        // 상하좌우 이동
        moveKey(rotate, lock);
    }
    
    // 상하좌우 이동하는 함수
    private static void moveKey(int[][] key, int[][] lock) {
        // 한번에 다같이 이동해야함 
        // 모두 1인 부분을 오른쪽으로 이동 (왼쪽, 아래, 위)
        for(int x=-(m-1); x<n; x++) {
            for(int y=-(m-1); y<n; y++) {
                keyVerseLock(key, lock, x, y);
                if(answer) return;
            }
        }
    }
    
    // key랑 Lock을 비교하는 함수
    static void keyVerseLock(int[][] key, int[][] lock, int x, int y) {
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                int dx = i - x;
                int dy = j - y;
                int keyVal = 0;
                if(dx >= 0 && dx < m && dy >= 0 && dy < m) {
                    keyVal = key[dx][dy];
                }
                if(keyVal + lock[i][j] != 1) {
                    answer = false;
                    return;
                }
            }
        }
        answer = true;
    }
}