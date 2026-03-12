import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for(int test=0; test<t; test++) {
            String w = br.readLine();
            int k = Integer.parseInt(br.readLine());

            int minLen = Integer.MAX_VALUE;
            int maxLen = Integer.MIN_VALUE;
            
            int n = w.length();
            int[][] pos = new int[26][n];
            int[] size = new int[26];

            for(int i=0; i<n; i++) {
                char ch = w.charAt(i);
                int idx = ch - 'a';
                pos[idx][size[idx]] = i;
                size[idx]++;
            }

            for(int c=0; c<26; c++) {
                if(size[c] < k) continue;

                for(int i=0; i<=size[c]-k; i++) {
                    int start = pos[c][i];
                    int end = pos[c][i+k-1];
                    int len = end - start + 1;
                    if(minLen > len) minLen = len;
                    if(maxLen < len) maxLen = len;
                }
            }
            if(minLen == Integer.MAX_VALUE && maxLen == Integer.MIN_VALUE) {
                System.out.println(-1);
            } else {
                System.out.println(minLen + " " + maxLen);
            }
        }
    }
}