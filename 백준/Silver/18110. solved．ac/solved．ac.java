import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

import static java.lang.Math.round;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        if(n == 0) {
            System.out.println(0);
            return;
        }

        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int people = Math.toIntExact(round(n * 0.15));
        double total = 0;
        int cnt = 0;
        for(int i = people; i<n-people; i++) {
            total += arr[i];
            cnt++;
        }

        int answer = (int) Math.round(total / cnt);
        System.out.print(answer);
    }
}