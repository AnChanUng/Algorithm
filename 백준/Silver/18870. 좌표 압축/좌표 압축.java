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

        int[] sortArr = Arrays.copyOf(arr, n);

        Arrays.sort(sortArr);

        Map<Integer, Integer> map = new HashMap<>();
        int rank = 0;
        for(int i=0; i<n; i++) {
            if(!map.containsKey(sortArr[i])) {
                map.put(sortArr[i], rank++);
            }
        }
        for(int i=0; i<n; i++) {
            sb.append(map.get(arr[i])).append(" ");
        }
        System.out.print(sb);
    }
}