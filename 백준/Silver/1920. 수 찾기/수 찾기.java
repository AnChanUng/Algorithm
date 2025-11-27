import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
/*
    시간복잡도: n = 100,000, m = 100,000;
    O(n^2) = 10^5 * 10^5 = 10^10
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Set<Integer> arr = new HashSet<>();
        String[] inputs1 = br.readLine().split(" ");
        for(int i=0; i<n; i++) {
            arr.add(Integer.parseInt(inputs1[i]));
        }

        int m = Integer.parseInt(br.readLine());
        String[] inputs2 = br.readLine().split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<m; i++) {
            int findNum = Integer.parseInt(inputs2[i]);
            if (arr.contains(findNum)) {
                sb.append(1).append("\n");
            } else {
                sb.append(0).append("\n");
            }
        }
        System.out.println(sb);
    }
}