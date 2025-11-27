import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        HashMap<Integer, Integer> map = new HashMap<>();
        String[] inputs = br.readLine().split(" ");
        for(int i=0; i<n; i++) {
            int a = Integer.parseInt(inputs[i]);
            if(map.containsKey(a)) {
                map.put(a, map.get(a) + 1);
            } else {
                map.put(a, 1);
            }
        }

        int m = Integer.parseInt(br.readLine());
        String[] line = br.readLine().split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<m; i++) {
            int b = Integer.parseInt(line[i]);
            if(map.containsKey(b)) {
                sb.append(map.get(b)).append(" ");
            } else {
                sb.append(0).append(" ");
            }
        }
        System.out.println(sb);
    }
}