import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int[] bam;
    static int[] sadari;
    static int[] dist;
    static int[] dx = {1, 2, 3, 4, 5, 6};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        bam = new int[101];
        sadari = new int[101];
        dist = new int[101];

        Arrays.fill(dist, -1);
        
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            sadari[x] = y;
        }

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            bam[u] = v;
        }

        bfs(1);
        System.out.print(dist[100]);
    }

    static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        dist[start] = 0;
        while(!q.isEmpty()) {
            int cur = q.poll();
            for(int dir=0; dir<6; dir++) {
                int nx = cur + dx[dir];
                if(nx > 100) continue;
                if(sadari[nx] != 0) {
                    nx = sadari[nx];
                } else if(bam[nx] != 0) {
                    nx = bam[nx];
                }

                if(dist[nx] == -1) {
                    q.add(nx);
                    dist[nx] = dist[cur] + 1;
                }
                //if(nx == 100) {
                //    q.add(nx);
                //    dist[nx] = dist[cur] + 1;
                //}
            }
        }
    }
}