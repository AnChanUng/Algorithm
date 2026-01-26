import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

/*
    문제
    단지수와 단지내 집의 수 구하기

    설계
    1. N(가로, 세로) 입력 받기
    2. bfs
    2.1 1인 수들 개수 카운트해서 배열에 저장
    2.2 끝나면 단지수++
    3. 단지수, 단지내 집의 수 오름차순 출력

    접근 방식
    - bfs
 */
public class Main {
    static int[][] graph;
    static boolean[][] vis;
    static ArrayList<Integer> list = new ArrayList<>();
    static final int[] dx = {-1, 0, 1, 0};
    static final int[] dy = {0, -1, 0, 1};
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        graph = new int[n][n];
        vis = new boolean[n][n];
        for(int i=0; i<n; i++) {
            String line = br.readLine();
            for(int j=0; j<line.length(); j++) {
                graph[i][j] = line.charAt(j) - '0';
            }
        }
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(graph[i][j] == 1 && !vis[i][j]) {
                    list.add(bfs(i, j));
                }
            }
        }
        Collections.sort(list);

        System.out.println(list.size());
        for(int i=0; i<list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
    static int bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {x, y});
        vis[x][y] = true;
        int cnt = 1;
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];
            for(int dir=0; dir<4; dir++) {
                int nx = cx + dx[dir];
                int ny = cy + dy[dir];
                if(nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                if(graph[nx][ny] == 1 && !vis[nx][ny]) {
                    cnt++;
                    vis[nx][ny] = true;
                    q.offer(new int[] {nx, ny});
                }
            }
        }
        return cnt;
    }
}