import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int k = Integer.parseInt(st.nextToken()); // 가지고 있는 랜선의 개수
        int n = Integer.parseInt(st.nextToken()); // 필요한 랜선의 개수

        int[] arr = new int[k];
        long right = 0;

        for(int i=0; i<k; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            right = Math.max(right, arr[i]);
        }

        long left = 1;
        long answer = 0;

        while(left <= right) {
            long mid = (left + right) / 2;
            long cnt = 0;
            for(int i=0; i<k; i++) {
                cnt += arr[i] / mid;
            }
            if(cnt >= n) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println(answer);
    }
}