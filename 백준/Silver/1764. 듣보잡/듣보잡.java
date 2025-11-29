import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> map = new HashMap<>();
        for(int i=0; i<n; i++) {
            map.put(br.readLine(), 1);
        }

        ArrayList<String> list = new ArrayList<>();
        for(int i=0; i<m; i++) {
            String str = br.readLine();
            map.put(str, map.getOrDefault(str, 0) + 1);
            if(map.get(str) == 2) {
                list.add(str);
            }
        }

        Collections.sort(list);
        sb.append(list.size()).append("\n");

        for(int i=0; i<list.size(); i++) {
            sb.append(list.get(i)).append(" ");
        }

        System.out.println(sb);
    }
}