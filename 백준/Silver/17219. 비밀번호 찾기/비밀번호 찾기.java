import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 사이트 주소의 수
        int m = Integer.parseInt(st.nextToken()); // 비밀번호를 찾으려는 사이트 주소의 수

        HashMap<String, String> map = new HashMap<>();
        for(int i=0; i<n; i++) {
            String[] inputs = br.readLine().split(" ");
            String site = inputs[0];
            String password = inputs[1];

            map.put(site, password);
        }

        for(int i=0; i<m; i++) {
            String str = br.readLine();
            if(map.containsKey(str)) {
                sb.append(map.get(str)).append("\n");
            }
        }
        System.out.println(sb);
    }
}