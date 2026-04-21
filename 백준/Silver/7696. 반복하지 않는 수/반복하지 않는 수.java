import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        int[] count = new int[1000000];
        int idx = 0;
        for (int i = 1; idx < 1000000; i++) {
            int n = i, mask = 0;
            boolean dup = false;
            while (n > 0) {
                int d = n % 10;
                if ((mask & (1 << d)) != 0) { dup = true; break; }
                mask |= (1 << d);
                n /= 10;
            }
            if (!dup) count[idx++] = i;
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null) {
            line = line.trim();
            if (line.isEmpty()) continue;
            int n = Integer.parseInt(line);
            if (n == 0) break;
            sb.append(count[n - 1]).append('\n');
        }
        System.out.print(sb);
    }
}