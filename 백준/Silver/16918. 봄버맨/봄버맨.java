import java.util.*;
import java.lang.*;
import java.io.*;
/*
    1.격자판에 폭탄 설치
    2. 반복  
     2.1 기존 상태 동일
     2.2 폭탄이 설치되지 않은 곳에 폭탄 설치
     2.3 초기에 폭탄 있던 곳 폭발 
         인접한 4칸 파괴 (연쇄x)
    3. n초일 때, 격자판 결과 출력
*/
class Main {
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {-1, 0, 1, 0};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        char[][] arr = new char[r][c];
        char[][] res = new char[r][c];
        for(int i=0; i<r; i++) {
            String str = br.readLine();
            for(int j=0; j<str.length(); j++) {
                arr[i][j] = str.charAt(j);
                res[i][j] = '.';
            }
        }
        int time = 0;
        while(true) {
            time++;
            // System.out.println();
            // System.out.println(time + "초");
            if(time == 1) {
                // for(int i=0; i<r; i++) {
                //     for(int j=0; j<c; j++) {
                //         System.out.print(arr[i][j]);
                //     }
                //     System.out.println();
                // }
            } else if (time % 2 == 0) { 
                for(int i=0; i<r; i++) {
                    for(int j=0; j<c; j++) {
                        if(arr[i][j] == '.') {
                            res[i][j] = 'O';
                        }
                    }
                }
            } else { // 초기에 폭탄 있던 곳 폭발. 인접한 4칸 파괴 (연쇄x)                
                for(int i=0; i<r; i++) {
                    for(int j=0; j<c; j++) {
                        if(arr[i][j] == 'O') {
                            arr[i][j] = '.';
                            for(int dir=0; dir<4; dir++) {
                                int nx = i + dx[dir];
                                int ny = j + dy[dir];
                                if(nx < 0 || nx >= r || ny < 0 || ny >= c) continue;
                                res[nx][ny] = '.';
                            }
                        }
                    }
                }
                for(int i=0; i<r; i++) {
                    for(int j=0; j<c; j++) {
                        if(res[i][j] == 'O') {
                            arr[i][j] = 'O';
                        }
                    }
                }
                for(int i=0; i<r; i++) {
                    for(int j=0; j<c; j++) {
                        res[i][j] = '.';
                    }
                }
            }
            // for(int i=0; i<r; i++) {
            //     for(int j=0; j<c; j++) {
            //         System.out.print(arr[i][j]);
            //     }
            //     System.out.println();
            // }
            // System.out.println();

            if(time >= n) {
                for(int i=0; i<r; i++) {
                    for(int j=0; j<c; j++) {
                        if(res[i][j] == 'O') {
                            arr[i][j] = 'O';
                        }
                    }
                }
                break;
            }
        }
        for(int i=0; i<r; i++) {
            for(int j=0; j<c; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }
}