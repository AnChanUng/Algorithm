import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;
/*
    타입이 다른 것들을 최소 1개 이상 입는 경우의 수

    접근 방식
    - 순서가 상관없는 조합
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test_case = Integer.parseInt(br.readLine());

        for(int t=0; t<test_case; t++) {
            int n = Integer.parseInt(br.readLine());
            HashMap<String, Integer> map = new HashMap<>();
            for(int i=0; i<n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String clothes = st.nextToken(); // 의상 이름
                String type = st.nextToken();    // 의상 종류
                if(map.containsKey(type)) {
                    map.put(type, map.get(type) + 1);
                } else {
                    map.put(type, 1);
                }
            }
            int result = 1;
            for(Integer val : map.values()) {
                result *= val+1;
            }
            System.out.println(result-1);
        }
    }
}