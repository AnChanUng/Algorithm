import java.util.*;
import java.lang.*;
import java.io.*;
/*
    (0, 0) -> (n-1, n-1) 최소 금액 이동
    1. bfs(0, 0) 출발
    2. 한칸 이동할 때 마다 해당 위치에 있는 숫자 만큼 cnt에 저장
    3. arr[n-1][n-1]에 도착하면 break
    4. cnt 출력
*/
class Main {
    static int n;
    static int[][] arr;
    static int[][] dist;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int number = 1;
        while(true) {
            n = Integer.parseInt(br.readLine());

            if(n == 0) break;

            arr = new int[n][n];
            dist = new int[n][n];

            for(int i=0; i<n; i++) {
                Arrays.fill(arr[i], 0);
                Arrays.fill(dist[i], Integer.MAX_VALUE); 
            }
            
            for(int i=0; i<n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j=0; j<n; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            bfs(0, 0, arr[0][0]);
            System.out.println("Problem " + number + ": " + dist[n-1][n-1]);
            number++;
        }
    }
    static void bfs(int x, int y, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[2], b[2])
        );
        pq.add(new int[]{x, y, k});
        dist[x][y] = arr[0][0];
        while(!pq.isEmpty()) {
            int[] cur = pq.poll();
            for(int dir=0; dir<4; dir++) {
                int nx = cur[0] + dx[dir];
                int ny = cur[1] + dy[dir];
                
                if(nx < 0 || nx >= n || ny < 0 || ny >= n) continue;

                int nextCost = cur[2] + arr[nx][ny];

                if(nextCost < dist[nx][ny]) {
                    pq.add(new int[]{nx, ny, nextCost});
                    dist[nx][ny] = nextCost;
                }
            }
        }
    }
}