import java.util.*;
import java.lang.*;
import java.io.*;
/* 
    조합 최단거리 DFS  
    1. 치킨집/집 위치를 리스트로 뽑기
    2. 조합 DFS로 치킨집 M개 선택
    3. 선택할 때마다 각 집 → 가장 가까운 치킨집 거리 합산
    4. 최솟값 갱신
*/
class Main {
    static int[] selected;
    static List<int[]> chicken = new ArrayList<>();
    static List<int[]> house = new ArrayList<>();
    static int n, m;
    static int minDist = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][n];
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 2) chicken.add(new int[]{i, j});
                if(arr[i][j] == 1) house.add(new int[]{i, j});
            }
        }
        selected = new int[m];
        dfs(0, 0);
        System.out.println(minDist);
    }
    static void dfs(int start, int depth) {
        if(depth == m) {
            int total = 0;
            for(int[] h : house) {
                int min = Integer.MAX_VALUE;
                for(int i=0; i<m; i++) {
                    int[] c = chicken.get(selected[i]);
                    int dist = Math.abs(h[0] - c[0]) + Math.abs(h[1] - c[1]);
                    min = Math.min(min, dist);
                }
                total += min;
            }
            minDist = Math.min(minDist, total);
            return;
        }
        for(int i=start; i<chicken.size(); i++) {
            selected[depth] = i;
            dfs(i+1, depth+1);
        }
    }
}