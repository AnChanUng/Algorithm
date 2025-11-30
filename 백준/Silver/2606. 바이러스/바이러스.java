import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static boolean[] vis;
    static ArrayList<ArrayList<Integer>> graph;
    static int cnt = 0;
    static int ComputerNumber;
    static int Network;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        ComputerNumber = Integer.parseInt(br.readLine());
        Network = Integer.parseInt(br.readLine());

        graph = new ArrayList<>();
        vis = new boolean[ComputerNumber+1];
        for(int i=0; i<=ComputerNumber; i++) {
            graph.add(new ArrayList<>());
        }
        for(int i=0; i<Network; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        dfs(1);
        System.out.println(cnt);
    }

    static void dfs(int x) {
        vis[x] = true;
        for(int i=1; i<=ComputerNumber; i++) {
            if(graph.get(x).contains(i) && !vis[i]) {
                cnt++;
                dfs(i);
            }
        }
    }
}
