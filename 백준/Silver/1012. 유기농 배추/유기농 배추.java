import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/*
    문제
    1.1 테스트 케이스 수 입력 받기
    1.2 가로, 세로, 위치의 개수 입력받기
    1.3 위치의 개수 만큼 배추의 위치 (x, y) 입력 받기
    2

    접근 방식
    - bfs
 */
public class Main {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        for(int t=0; t<testCase; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int m = Integer.parseInt(st.nextToken()); // 가로길이
            int n = Integer.parseInt(st.nextToken()); // 세로길이
            int k = Integer.parseInt(st.nextToken()); // 위치의 개수

            int[][] graph = new int[n+1][m+1];
            for(int i=0; i<k; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken()); // 배추의 위치
                int y = Integer.parseInt(st.nextToken());
                graph[y][x] = 1;
            }

            int cnt = 0;
            for(int i=0; i<n; i++) {
                for(int j=0; j<m; j++) {
                    if(graph[i][j] == 1) {
                        cnt++;

                        Queue<int[]> q = new LinkedList<>();
                        q.offer(new int[]{i, j});
                        graph[i][j] = 0;
                        while(!q.isEmpty()) {
                            int[] cur = q.poll();
                            for(int dir=0; dir<4; dir++) {
                                int ny = cur[0] + dy[dir];
                                int nx = cur[1] + dx[dir];

                                if(ny < 0 || ny >= n || nx < 0 || nx >= m) continue;
                                if(graph[ny][nx] == 0) continue;

                                graph[ny][nx] = 0;
                                q.offer(new int[]{ny, nx});
                            }
                        }
                    }
                }
            }
            System.out.println(cnt);
        }
    }
}