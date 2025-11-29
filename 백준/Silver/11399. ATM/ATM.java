import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            int p = Integer.parseInt(st.nextToken());
            arr[i] = p;
        }
        Arrays.sort(arr);
        
        int total = 0;
        int answer = 0;
        for(int i=0; i<n; i++) {
            total += arr[i];
            answer += total;
        }

        System.out.print(answer);
    }
}