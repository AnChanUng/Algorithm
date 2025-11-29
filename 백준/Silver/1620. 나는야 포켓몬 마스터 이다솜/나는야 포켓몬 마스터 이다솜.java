import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputs = br.readLine().split(" ");

        int n = Integer.parseInt(inputs[0]); // 포켓몬 개수
        int m = Integer.parseInt(inputs[1]); // 문제의 개수

        HashMap<Integer, String> map1 = new HashMap<>();
        HashMap<String, Integer> map2 = new HashMap<>();
        for(int i=1; i<=n; i++) {
            String str = br.readLine();
            map1.put(i, str);
            map2.put(str, i);
        }
        for(int i=0; i<m; i++) {
            String st = br.readLine();
            boolean flag = false;
            for(int j=0; j<st.length(); j++) {
                char ch = st.charAt(j);
                if(Character.isDigit(ch)) {
                    flag = true;
                } else {
                    flag = false;
                    break;
                }
            }
            if(flag) {
                int k = Integer.parseInt(st);
                if(map1.containsKey(k)) {
                    System.out.println(map1.get(k));
                }
            } else {
                if(map2.containsKey(st)) {
                    System.out.println(map2.get(st));
                }
            }
        }
    }
}