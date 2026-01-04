import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] sortArr = arr.clone();

        Arrays.sort(sortArr);
        // 2 4 -10 4 -9
        // -10 -9 2 4 4
        Map<Integer, Integer> map = new HashMap<>();
        int rank = 0;
        for(int i=0; i<n; i++) {
            if(!map.containsKey(sortArr[i])) {
                map.put(sortArr[i], rank);
                rank++;
            }
        }
        for(int i=0; i<n; i++) {
            sb.append(map.get(arr[i])).append(" ");
        }

        System.out.println(sb);
    }
}